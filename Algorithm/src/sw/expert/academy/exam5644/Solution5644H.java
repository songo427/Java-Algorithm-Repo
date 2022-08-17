package sw.expert.academy.exam5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 5644. [모의 SW 역량테스트] 무선 충전
 * 송현주
 */
public class Solution5644H {
    static int M, A, answer;

    // 상 우 좌 하
    static int[] dx = {0, -1, 0, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            answer = 0;
            String input = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input);
            M = Integer.parseInt(tokenizer.nextToken());
            A = Integer.parseInt(tokenizer.nextToken());

            int[] rootA = new int[M + 1];
            int[] rootB = new int[M + 1];
            BC[] bcList = new BC[A];

            // userA
            input = br.readLine();
            tokenizer = new StringTokenizer(input);
            for (int i = 0; i < M; i++) {
                rootA[i] = Integer.parseInt(tokenizer.nextToken());
            }

            // userB
            input = br.readLine();
            tokenizer = new StringTokenizer(input);
            for (int i = 0; i < M; i++) {
                rootB[i] = Integer.parseInt(tokenizer.nextToken());
            }

            // BCList 생성
            for (int i = 0; i < A; i++) {
                input = br.readLine();
                tokenizer = new StringTokenizer(input);
                bcList[i] = new BC(Integer.parseInt(tokenizer.nextToken()),
                        Integer.parseInt(tokenizer.nextToken()),
                        Integer.parseInt(tokenizer.nextToken()),
                        Integer.parseInt(tokenizer.nextToken()));
            }


            int time = 0;
            int[] userA = {1, 1};
            int[] userB = {10, 10};

            while (time != M + 1) {

                ArrayList<BC> aList = new ArrayList<>();
                ArrayList<BC> bList = new ArrayList<>();

                // BC 수만큼 반복해서 탐색
                for (int i = 0; i < A; i++) {
                    int a = Math.abs(bcList[i].x - userA[0]) + Math.abs(bcList[i].y - userA[1]);
                    int b = Math.abs(bcList[i].x - userB[0]) + Math.abs(bcList[i].y - userB[1]);

                    if (a <= bcList[i].coverage) {
                        aList.add(bcList[i]);
                    }

                    if (b <= bcList[i].coverage) {
                        bList.add(bcList[i]);
                    }
                }

                // userA 또는 userB 한 명만 범위 내에 있는 경우
                if (bList.isEmpty()) {
                    int maxPerformance = 0;
                    for (int i = 0; i < aList.size(); i++) {
                        if (aList.get(i).performance > maxPerformance) {
                            maxPerformance = aList.get(i).performance;
                        }
                    }
                    answer += maxPerformance;
                } else if (aList.isEmpty()) {
                    int maxPerformance = 0;
                    for (int i = 0; i < bList.size(); i++) {
                        if (bList.get(i).performance > maxPerformance) {
                            maxPerformance = bList.get(i).performance;
                        }
                    }
                    answer += maxPerformance;
                }

                // 둘 다 범위 내에 있는 경우
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < aList.size(); i++) {
                    for (int j = 0; j < bList.size(); j++) {
                        if (aList.get(i).equals(bList.get(j))) {
                            tmp.add(aList.get(i).performance);
                        } else {
                            tmp.add(aList.get(i).performance + bList.get(j).performance);
                        }
                    }
                }

                if (!tmp.isEmpty()) {
                    Collections.sort(tmp);
                    answer += tmp.get(tmp.size() - 1);
                }

                // userA와 userB를 움직임
                moveUser(rootA[time], userA[0], userA[1], userA);
                moveUser(rootB[time], userB[0], userB[1], userB);

                time++;
            }
            System.out.println("#" + testCase + " " + answer);
        }
    }

    private static void moveUser(int dir, int x, int y, int[] location) {

        // 지도 밖을 나가는 경우는 없음
        int nx = dx[dir] + x;
        int ny = dy[dir] + y;

        location[0] = nx;
        location[1] = ny;
    }
}

class BC {
    int x, y;
    int coverage, performance;

    public BC(int y, int x, int coverage, int performance) {
        this.x = x;
        this.y = y;
        this.coverage = coverage;
        this.performance = performance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BC bc = (BC) o;
        return x == bc.x && y == bc.y && coverage == bc.coverage && performance == bc.performance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, coverage, performance);
    }

    @Override
    public String toString() {
        return "BC{" +
                "x=" + x +
                ", y=" + y +
                ", coverage=" + coverage +
                ", performance=" + performance +
                '}';
    }
}