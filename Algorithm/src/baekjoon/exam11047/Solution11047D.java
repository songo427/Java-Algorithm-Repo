package baekjoon.exam11047;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 11047. 동전 0
 * 이다은
 */
public class Solution11047D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[n-i-1] = Integer.parseInt(reader.readLine());
        }

        int idx = 0;
        int cnt = 0;
        while (k > 0) {
            if (values[idx] > k) {
                idx++;
            } else {
                k -= values[idx];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

