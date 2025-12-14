import argparse
import re
import subprocess
from dataclasses import dataclass
from pathlib import Path
from typing import Dict, List, Tuple

REPO_ROOT = Path(__file__).resolve().parents[1]
LC_README = REPO_ROOT / "LeetCode" / "README.md"

SECTION_RE = re.compile(r"^###\s*(\d+)\s*~\s*(\d+)\s*$", re.MULTILINE)

@dataclass(frozen=True)
class LcMeta:
    idx: int               # 문제 번호
    slug: str               # 문제 slug
    title: str             # 문제 이름
    level: str             # 문제 레벨 (Easy, Medium, Hard)
    tags: str              # 문제 태그 (DFS, BFS, ...)
    complexity: str        # 시간/공간 복잡도
    note: str              # 비고
    solution_relpath: str  # 솔루션 URL

def git_changed_files(before: str, after: str) -> List[str]:
    out = subprocess.check_output(
        ["git", "diff", "--name-only", f"{before}..{after}"],
        text=True
    ).strip()
    return [x for x in out.splitlines() if x]

def is_leetcode_solution(path: str) -> bool:
    return path.startswith("LeetCode/Solutions/") and (
        path.endswith(".java") or path.endswith(".sql")
    )

def parse_meta_from_file(abs_path: Path, rel_path: str) -> LcMeta:
    text = abs_path.read_text(encoding="utf-8", errors="ignore")

    def pick(key: str) -> str:
        m = re.search(rf"@lc\.{re.escape(key)}\s*:\s*(.*)\s*$", text, re.MULTILINE)
        return (m.group(1).strip() if m else "")

    idx_s = pick("idx")
    if not idx_s.isdigit():
        raise ValueError(f"Missing or invalid @lc.idx in {rel_path}")

    slug = pick("slug")
    if not slug:
        raise ValueError(f"Missing @lc.slug in {rel_path} (recommended for accurate LeetCode link)")

    return LcMeta(
        idx=int(idx_s),
        slug=slug,
        title=pick("title") or "(Unknown Title)",
        level=pick("level") or "",
        tags=pick("tags") or "",
        complexity=pick("complexity") or "",
        note=pick("note") or "",
        solution_relpath=rel_path.replace("\\", "/"),
    )

def section_range_for_idx(idx: int) -> Tuple[int, int]:
    # README가 1~200, 201~400 ... 형태이므로 200 단위
    start = ((idx - 1) // 200) * 200 + 1
    end = start + 199
    return start, end

def build_row(m: LcMeta) -> str:
    lc_url = f"https://leetcode.com/problems/{m.slug}/"
    gh_url = f"https://github.com/SubAkBa/Algorithm_Solution/blob/master/{m.solution_relpath}"
    return (
        f"| {m.idx} | "
        f"[{m.title}]({lc_url}) | "
        f"{m.level} | "
        f"{m.tags} | "
        f"[{m.complexity}]({gh_url}) | "
        f"{m.note} |"
    )

def extract_table_parts(section_text: str) -> Tuple[str, str, str]:
    """
    section_text 내에서:
    - prefix: 테이블 헤더(정렬선 포함)까지
    - rows_block: 실제 행만(문자열)
    - suffix: </details>부터 끝까지
    """
    header_m = re.search(r"(\| Idx \|.*\n\|:---:.*\n)", section_text)
    if not header_m:
        raise RuntimeError("Table header not found in section.")

    header_end = header_m.end(1)
    after = section_text[header_end:]

    end_m = re.search(r"\n</details>\s*\n", after)
    if not end_m:
        raise RuntimeError("</details> not found after table in section.")

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
    rows: Dict[int, str] = {}
    for line in rows_block.splitlines():
        m = re.match(r"^\|\s*(\d+)\s*\|", line)
        if m:
            rows[int(m.group(1))] = line
    return rows

def update_readme(readme_text: str, metas: List[LcMeta]) -> str:
    # 범위별로 묶기
    bucket: Dict[Tuple[int, int], List[LcMeta]] = {}
    for m in metas:
        r = section_range_for_idx(m.idx)
        bucket.setdefault(r, []).append(m)

    matches = list(SECTION_RE.finditer(readme_text))
    if not matches:
        raise RuntimeError("No '### a ~ b' sections found.")

    out = []
    last = 0

    for i, s in enumerate(matches):
        start_pos = s.start()
        end_pos = matches[i + 1].start() if i + 1 < len(matches) else len(readme_text)

        out.append(readme_text[last:start_pos])
        sec_text = readme_text[start_pos:end_pos]

        a = int(s.group(1)); b = int(s.group(2))
        key = (a, b)

        if key not in bucket:
            out.append(sec_text)
            last = end_pos
            continue

        prefix, rows_block, suffix = extract_table_parts(sec_text)
        existing = parse_existing_rows(rows_block)

        for meta in bucket[key]:
            existing[meta.idx] = build_row(meta)

        new_rows = "\n".join(existing[k] for k in sorted(existing.keys()))
        new_sec = prefix + new_rows + "\n" + suffix

        out.append(new_sec)
        last = end_pos

    out.append(readme_text[last:])
    return "".join(out)

def main():
    ap = argparse.ArgumentParser()
    ap.add_argument("--before", required=True)
    ap.add_argument("--after", required=True)
    args = ap.parse_args()

    changed = git_changed_files(args.before, args.after)
    targets = [p for p in changed if is_leetcode_solution(p)]
    if not targets:
        return

    metas: List[LcMeta] = []
    for rel in targets:
        abs_path = REPO_ROOT / rel
        if abs_path.exists():
            metas.append(parse_meta_from_file(abs_path, rel))

    if not metas:
        return

    text = LC_README.read_text(encoding="utf-8")
    new_text = update_readme(text, metas)

    if new_text != text:
        LC_README.write_text(new_text, encoding="utf-8")

if __name__ == "__main__":
    main()
