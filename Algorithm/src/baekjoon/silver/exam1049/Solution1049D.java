package baekjoon.silver.exam1049;

import java.io.*;
import java.util.*;

public class Solution1049D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int pack_num = N/6;
        int piece_num = N%6;
        int pack = Integer.MAX_VALUE;
        int piece = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            piece = Math.min(piece, Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        answer += Math.min(pack, piece*6) * pack_num;
        answer += Math.min(pack, piece * piece_num);

        System.out.println(answer);
    }
}
