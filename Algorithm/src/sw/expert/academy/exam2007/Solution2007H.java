package sw.expert.academy.exam2007;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * 2007. 패턴 마디의 길이                                                                                                 
 * 송현주
 **/

public class Solution2007H {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			StringBuilder input = new StringBuilder(sc.next());
			HashMap<String, Integer> patterns = new HashMap<>();

			for (int i = 1; i <= 10; i++) {
				String pattern = input.substring(0, i);
				String result = input.toString().replaceAll(pattern, "");
				if (result.length() < pattern.length()) {
					patterns.put(pattern, result.length());
				}
			}

			int minCount = Integer.MAX_VALUE;
			String answer = "";
			Set<String> keySet = patterns.keySet();
			for (String key : keySet) {
				if (patterns.get(key) < minCount) {
					minCount = patterns.get(key);
					answer = key;
				} else if (patterns.get(key) == minCount) {
					if (key.length() < answer.length()) {
						minCount = patterns.get(key);
						answer = key;
					}
				}
			}

			System.out.println("#" + test_case + " " + answer.length());
		}
	}
}
