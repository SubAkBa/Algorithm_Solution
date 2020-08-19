import java.util.*;
import java.util.regex.Pattern;

public class Solution_EncodeandDecodeTinyURL {
	public class Codec {
		HashMap<String, String> long2short = new HashMap<>();
		HashMap<String, String> short2long = new HashMap<>();
		int[] prime = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
				83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191,
				193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311,
				313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439,
				443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577,
				587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709,
				719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853,
				857 };

		// Encodes a URL to a shortened URL.
		public String encode(String longUrl) {
			if (!long2short.containsKey(longUrl)) {
				String[] url_part = longUrl.split("\\.");
				String s = url_part[url_part.length - 1];
				int idx = s.indexOf("/");

				StringBuilder sb = new StringBuilder("https://tinyurl" + s.substring(0, idx + 1));
				char[] chs = s.substring(idx + 1).toCharArray();
				String pattern = "[0-9a-zA-Z]";

				for (char ch : chs) {
					char c = (char) (prime[ch] * ch % 127);

					if (!Pattern.matches(pattern, String.valueOf(c)))
						continue;

					sb.append(c);
				}

				long2short.put(longUrl, sb.toString());
				short2long.put(sb.toString(), longUrl);
			}

			return long2short.get(longUrl);
		}

		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl) {
			return short2long.get(shortUrl);
		}
	}
}