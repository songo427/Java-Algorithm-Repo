package baekjoon.exam2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2961. 도영이가 만든 맛있는 음식
 * 송현주
 */
public class Solution2961H {
    static int N, minTaste;
    static int[][] comb;
    static int[][] ingredients;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 재료의 개수
        minTaste = Integer.MAX_VALUE;
        comb = new int[N][2];
        ingredients = new int[N][2];
        isSelected = new boolean[N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line);
            ingredients[i][0] = Integer.parseInt(tokenizer.nextToken());
            ingredients[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        cook(0);
        System.out.println(minTaste);
    }

    private static void cook(int index) {

        if (index == N) {
            int sTaste = 1, bTaste = 0;
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    sTaste *= ingredients[i][0];
                    bTaste += ingredients[i][1];
                }
            }

            if (bTaste != 0 && Math.abs(sTaste - bTaste) <= minTaste) {
                minTaste = Math.abs(sTaste - bTaste);
            }
            return;
        }

        isSelected[index] = true;
        cook(index + 1);

        isSelected[index] = false;
        cook(index + 1);
    }
}
