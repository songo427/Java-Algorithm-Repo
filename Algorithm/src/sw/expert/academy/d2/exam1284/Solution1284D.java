package sw.expert.academy.d2.exam1284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1284. 수도 요금 경쟁
 * 이다은
 */
public class Solution1284D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int answer = Math.min(W*P, W > R ? Q + (W-R)*S : Q);

            System.out.println("#" + i + " " + answer);
        }
    }
}
