package sw.expert.academy.exam1228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1228. [S/W 문제해결 기본] 8일차 - 암호문1
 * 송현주
 */

public class Solution1228H {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer;

        for (int testCase = 1; testCase <= 10; testCase++) {

            answer = new StringBuilder("#" + testCase + " ");
            int originalLength = Integer.parseInt(br.readLine());
            List<String> original = new ArrayList<>();
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < originalLength; i++) {
                original.add(input.nextToken());
            }

            int commandLength = Integer.parseInt(br.readLine());
            Queue<String[]> commands = new ArrayDeque<>();
            input = new StringTokenizer(br.readLine(), "I");
            for (int i = 0; i < commandLength; i++) {
                String[] commandLine = input.nextToken().split(" ");
                commands.add(commandLine);
            }

            for (int i = 0; i < commandLength; i++) {
                String[] curCommand = commands.poll();
                int start = Integer.parseInt(curCommand[1]);
                int loop = Integer.parseInt(curCommand[2]);
                int idx = 0;
                for (int j = 3; j < loop + 3; j++) {
                    original.add(start + idx, curCommand[j]);
                    idx++;
                }
            }

            for (int i = 0; i < 10; i++) {
                answer.append(original.get(i) + " ");
            }
            System.out.println(answer);
        }
    }
}

