package sw.expert.academy.d2.exam1940;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1940. 가랏! RC카!
 * 이다은
 */
public class Solution1940D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(reader.readLine());
            int d = 0;
            int v = 0;

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
                int cmd = Integer.parseInt(st.nextToken());

                if (cmd == 1) {
                    v += Integer.parseInt(st.nextToken());
                } else if (cmd == 2){
                    v -= Integer.parseInt(st.nextToken());
                    if (v < 0) {
                        v = 0;
                    }
                }

                d += v;
            }

            System.out.println("#" + i + " " + d);

        }

    }
}
