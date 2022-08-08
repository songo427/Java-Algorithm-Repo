package sw.expert.academy.exam1966;

import java.io.*;
import java.util.*;

/**
 * 1966. 숫자를 정렬하자
 * 이다은
 */
public class Solution1966D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(reader.readLine());
            int[] numbers = new int[N];
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(numbers);

            System.out.print("#" + i + " ");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
