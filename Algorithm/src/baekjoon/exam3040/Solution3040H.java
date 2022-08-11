package baekjoon.exam3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3040. 백설 공주와 일곱 난쟁이
 * 송현주
 */
public class Solution3040H {

    static int[] dwarf;
    static int[] realDwarf;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();

        dwarf = new int[9];
        realDwarf = new int[7];
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine().trim());
        }

        comb(0, 0, 0);
        System.out.print(answer.toString().trim());
    }

    private static void comb(int cnt, int start, int sumOfHeight) {
        if (cnt == 7) {
            if (sumOfHeight == 100) {
                for(int i=0; i<7; i++){
                    answer.append(realDwarf[i] + "\n");
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            realDwarf[cnt] = dwarf[i];
            comb(cnt + 1, i + 1, sumOfHeight + dwarf[i]);
        }
    }
}
