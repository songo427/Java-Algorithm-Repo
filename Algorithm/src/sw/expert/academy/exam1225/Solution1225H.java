package sw.expert.academy.exam1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [S/W 문제해결 기본] 7일차 - 암호생성기
 * 송현주
 */

public class Solution1225H {
    static Queue<Integer> queue;
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {

            int N = Integer.parseInt(bf.readLine()); // tc 번호
            queue = new ArrayDeque<>();
            answer = new StringBuilder("#" + N + " ");

            String line = bf.readLine();
            StringTokenizer nums = new StringTokenizer(line, " ");

            // 입력부
            for (int i = 1; i <= 8; i++) {
                queue.offer(Integer.parseInt(nums.nextToken()));
            }

            // 암호화
            boolean isEncrypted = false;
            while (!isEncrypted) {
                for (int i = 1; i <= 5; i++) {
                    int curNum = queue.poll();
                    if (curNum - i <= 0) {
                        queue.offer(0);
                        isEncrypted = true;
                        break;
                    }
                    queue.offer(curNum - i);
                }
            }
            printAnswer();
        }
    }

    // 출력부
    public static void printAnswer(){
        while (!queue.isEmpty()) {
            answer.append(queue.poll() + " ");
        }
        System.out.println(answer);
    }
}
