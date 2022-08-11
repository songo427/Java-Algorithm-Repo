package sw.expert.academy.d2.exam1959;

import java.io.*;
import java.util.*;

/**
 * 1959. 두 개의 숫자열
 * 이다은
 */
public class Solution1959D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(reader.readLine(), " ");
            int[] a = new int[N];
            for (int j = 0; j < N; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(reader.readLine(), " ");
            int[] b = new int[M];
            for (int j = 0; j < M; j++) {
                b[j] = Integer.parseInt(st.nextToken());
            }

            int min[], max[];

            if (N < M) {
                min = a;
                max = b;
            } else {
                min = b;
                max = a;
            }

            int answer = 0;
            for (int j = 0; j < max.length - min.length + 1; j++) {
                int tmp = 0;
                for (int k = 0; k < min.length; k++) {
                    tmp += min[k] * max[j+k];
                }
                if (answer < tmp) {
                    answer = tmp;
                }
            }

            System.out.println("#" + i + " " + answer);

        }
    }
}
