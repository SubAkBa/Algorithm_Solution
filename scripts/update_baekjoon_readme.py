import argparse
import re
import subprocess
from dataclasses import dataclass
from pathlib import Path
from typing import Dict, List

REPO_ROOT = Path(__file__).resolve().parents[1]
BJ_README = REPO_ROOT / "BaekJoon" / "README.md"

TIER_ORDER = ["bronze", "silver", "gold", "platinum", "diamond", "ruby"]

@dataclass(frozen=True)
class BjMeta:
    idx: int
    tier: str
    title: str
    level: str
    tags: str
    complexity: str
    note: str
    solution_relpath: str

def git_changed_files(before: str, after: str) -> List[str]:
    out = subprocess.check_output(
        ["git", "diff", "--name-only", f"{before}..{after}"],
        text=True
    ).strip()
    return [x for x in out.splitlines() if x]

def is_baekjoon_solution(path: str) -> bool:
    return path.startswith("BaekJoon/Solutions/") and (
        path.endswith(".java") or path.endswith(".py") or path.endswith(".cpp")
    )

def parse_meta(abs_path: Path, rel_path: str) -> BjMeta:
    text = abs_path.read_text(encoding="utf-8", errors="ignore")

    def pick(key: str) -> str:
        for line in text.splitlines():
                line = line.strip()
                if line.startswith(f"@boj.{key}:"):
                    return line.split(":", 1)[1].strip()
        return ""

    idx_s = pick("idx")
    if not idx_s.isdigit():
        raise ValueError(f"Missing or invalid @boj.id in {rel_path}")

    tier = pick("tier").lower()
    if tier not in TIER_ORDER:
        raise ValueError(f"Missing/invalid @boj.tier in {rel_path} (expected one of {TIER_ORDER})")

    return BjMeta(
        idx=int(idx_s),
        tier=tier,
        title=pick("title") or "(Unknown Title)",
        level=pick("level") or "",
        tags=pick("tags") or "",
        complexity=pick("complexity") or "",
        note=pick("note") or "",
        solution_relpath=rel_path.replace("\\", "/"),
    )

def build_row(m: BjMeta) -> str:
    boj_url = f"https://www.acmicpc.net/problem/{m.idx}"
    gh_url = f"https://github.com/SubAkBa/Algorithm_Solution/blob/master/{m.solution_relpath}"
    return (
        f"| {m.idx} | "
        f"[{m.title}]({boj_url}) | "
        f"{m.level} | "
        f"{m.tags} | "
        f"[{m.complexity}]({gh_url}) | "
        f"{m.note} |"
    )

def split_by_tier_sections(readme: str) -> Dict[str, str]:
    """
    tier별로 섹션 텍스트를 뽑기.
    기준: <img src="../img/{tier}.png">
    """
    # 각 티어 img 시작 위치 찾기
    positions = []
    for tier in TIER_ORDER:
        token = f'<img src="../img/{tier}.png">'
        idx = readme.find(token)
        if idx != -1:
            positions.append((idx, tier, token))

    if not positions:
        raise RuntimeError("No tier image sections found in BaekJoon/README.md")

    positions.sort()
    sections = {}
    for i, (pos, tier, token) in enumerate(positions):
        end = positions[i + 1][0] if i + 1 < len(positions) else len(readme)
        sections[tier] = readme[pos:end]
    return sections

def extract_table_parts(section_text: str) -> tuple[str, str, str]:
    """
    section_text 내에서:
    - prefix: 테이블 헤더(정렬선 포함)까지
    - rows_block: 기존 행들
    - suffix: </details> 포함 이후
    """
    header_m = re.search(r"(\|  Idx.*\n\|.*\n)", section_text)
    if not header_m:
        raise RuntimeError("Table header not found in tier section.")

    header_end = header_m.end(1)
    after = section_text[header_end:]

    end_m = re.search(r"\n</details>\s*\n", after)
    if not end_m:
        raise RuntimeError("</details> not found after table in tier section.")

    rows_area = after[:end_m.start()]
    suffix = after[end_m.start():]

    rows = []
    for line in rows_area.splitlines():
        line = line.rstrip()
        if line.startswith("|") and re.match(r"^\|\s*\d+\s*\|", line):
            rows.append(line)

    prefix = section_text[:header_end]
    return prefix, "\n".join(rows), suffix

def parse_existing_rows(rows_block: str) -> Dict[int, str]:
    rows = {}
    for line in rows_block.splitlines():
        m = re.match(r"^\|\s*(\d+)\s*\|", line)
        if m:
            rows[int(m.group(1))] = line
    return rows

def update_readme(readme_text: str, metas: List[BjMeta]) -> str:
    sections = split_by_tier_sections(readme_text)

    # tier별로 metas 묶기
    by_tier: Dict[str, List[BjMeta]] = {}
    for m in metas:
        by_tier.setdefault(m.tier, []).append(m)

    # 원본 텍스트에서 tier section 단위로 replace
    new_text = readme_text
    for tier, sec_text in sections.items():
        if tier not in by_tier:
            continue

        prefix, rows_block, suffix = extract_table_parts(sec_text)
        existing = parse_existing_rows(rows_block)

        for meta in by_tier[tier]:
            existing[meta.idx] = build_row(meta)

        new_rows = "\n".join(existing[k] for k in sorted(existing.keys()))
        new_sec = prefix + new_rows + "\n" + suffix

        new_text = new_text.replace(sec_text, new_sec, 1)

    return new_text

def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--before", required=True)
    ap.add_argument("--after", required=True)
    args = ap.parse_args()

    changed = git_changed_files(args.before, args.after)
    targets = [p for p in changed if is_baekjoon_solution(p)]
    if not targets:
        return

    metas: List[BjMeta] = []
    for rel in targets:
        abs_path = REPO_ROOT / rel
        if abs_path.exists():
            metas.append(parse_meta(abs_path, rel))

    if not metas:
        return

    text = BJ_README.read_text(encoding="utf-8")
    new_text = update_readme(text, metas)

    if new_text != text:
        BJ_README.write_text(new_text, encoding="utf-8")

if __name__ == "__main__":
    main()
