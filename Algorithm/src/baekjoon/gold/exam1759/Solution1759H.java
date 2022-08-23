package baekjoon.gold.exam1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1759. 암호 만들기
 * 송현주
 * */
public class Solution1759H {
    static char[] alphabet;
    static char[] password;
    static int L, C;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();

        // 입력
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        password = new char[L];
        input = br.readLine();

        // 알파벳 저장
        String[] tmp = input.split(" ");
        alphabet = new char[C];
        for (int i = 0; i < C; i++) {
            alphabet[i] = tmp[i].charAt(0);
        }

        // 사전순
        Arrays.sort(alphabet);

        // 조합
        comb(0, 0);

        // 출력
        System.out.print(answer.toString().trim());
    }

    // 조합
    private static void comb(int start, int cnt) {
        if (L == cnt) {

            // 크기가 L인 조합이 완성되면 암호 가능성 체크
            isPassword(password);
            return;
        }

        for (int i = start; i < C; i++) {
            password[cnt] = alphabet[i];
            comb(i + 1, cnt + 1);
        }
    }

    // 암호 가능성 체크
    private static void isPassword(char[] password) {
        String tmp = "";
        int vowels = 0;
        for (int i = 0; i < L; i++) {
            if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u') {
                vowels++;
            }
            tmp += password[i];
        }

        // 가능한 암호라면, answer에 저장
        if (vowels > 0 && L - vowels >= 2) {
            answer.append(tmp + "\n");
        }
    }
}
