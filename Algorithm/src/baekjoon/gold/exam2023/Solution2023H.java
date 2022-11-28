package baekjoon.gold.exam2023;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 2023. 신기한 소수
 * 송현주
 */
public class Solution2023H {
    static int N;
    static ArrayList<String> answer;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();

        dfs("", 0);
        for(String num : answer) {
            System.out.println(num);
        }
    }

    private static void dfs(String cur, int cnt) {

        // N자리 수라면 종료
        if (cnt == N) {
            answer.add(cur);
            return;
        }

        // 현재 수에 수를 추가해 검사
        for (int num = 1; num <= 9; num++) {
            if (!isPrimeNum(cur + num)) continue;
            dfs(cur + num, cnt + 1);
        }
    }

    // 소수 판별
    private static boolean isPrimeNum(String cur) {
        // 현재 수 타입 변경
        int currentNum = Integer.parseInt(cur);
        if (currentNum < 2) return false;

        // 현재 수 / 2 만큼 검사
        for (int i = 2; i <= currentNum / 2; i++) {
            if (currentNum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
