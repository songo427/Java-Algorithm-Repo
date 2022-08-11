package sw.expert.academy.d2.exam1989;

import java.util.Scanner;

/**
 * 1989. 초심자의 회문 검사 송현주
 **/

public class Solution1989H {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder input = new StringBuilder(sc.next());
			int answer = -1;

			StringBuilder reversedString = new StringBuilder(input);
			reversedString = reversedString.reverse();

			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) != reversedString.charAt(i)) {
					answer = 0;
					break;
				} else {
					answer = 1;
					continue;
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}
