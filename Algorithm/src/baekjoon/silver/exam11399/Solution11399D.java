package baekjoon.silver.exam11399;

import java.io.*;
import java.util.*;

/**
 * 11399. ATM
 * 이다은
 */
public class Solution11399D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += time[i] * (N-i);
        }

        System.out.println(answer);
    }
}
