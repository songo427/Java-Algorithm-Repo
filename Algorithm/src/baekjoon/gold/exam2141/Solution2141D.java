package baekjoon.gold.exam2141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2141. 우체국
 * 이다은
 */
public class Solution2141D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Town[] town = new Town[N];
        double pop = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            town[i] = new Town(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pop += town[i].pop;
        }

        Arrays.sort(town);

        double cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt += town[i].pop;
            if (cnt >= pop/2) {
                System.out.println(town[i].loc);
                break;
            }
        }
    }

    static class Town implements Comparable<Town> {
        int loc;
        int pop;

        public Town(int loc, int pop) {
            this.loc = loc;
            this.pop = pop;
        }

        @Override
        public int compareTo(Town o) {
            return this.loc - o.loc;
        }

    }
}
