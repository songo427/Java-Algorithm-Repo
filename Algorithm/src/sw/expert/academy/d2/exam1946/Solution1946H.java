package com.algo.exam1946;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 1946. 간단한 압축 풀기 
 * 송현주
 **/

public class Solution1946H {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder answer = new StringBuilder();
			int N = sc.nextInt();

			for (int i = 0; i < N; i++) {
				char key = sc.next().charAt(0);
				int loop = sc.nextInt();

				for (int k = 0; k < loop; k++) {
					answer.append(key);
				}
			}

			// print
			System.out.println("#" + test_case);
			for (int i = 0; i < answer.length();) {
				if (i + 10 >= answer.length()) {
					System.out.println(answer.substring(i));

				} else {
					System.out.println(answer.substring(i, i + 10));
				}
				i += 10;
			}
		}
	}
}
