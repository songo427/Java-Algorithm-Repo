package sw.expert.academy.exam1983;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1983. 조교의 성적 매기기 D2
 * 송현주
 */
public class Solution1983H {
    public static void main(String args[]) throws Exception {
        String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D-"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            String line = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            HashMap<Integer, Double> scores = new HashMap<>();
            int N = Integer.parseInt(tokenizer.nextToken());
            int K = Integer.parseInt(tokenizer.nextToken());
            int sep = N / 10;

            for (int i = 0; i < N; i++) {
                line = br.readLine();
                tokenizer = new StringTokenizer(line);
                int mScore = Integer.parseInt(tokenizer.nextToken());
                int fScore = Integer.parseInt(tokenizer.nextToken());
                int hScore = Integer.parseInt(tokenizer.nextToken());
                scores.put(i + 1, mScore * 0.35 + fScore * 0.45 + hScore * 0.2);
            }


            List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(scores.entrySet());
            entryList.sort((a, b) -> (int) (scores.get(b.getKey()) - scores.get(a.getKey())));

            // 학점 부여
            int idx = 1;
            for (Map.Entry<Integer, Double> entry : entryList) {
                if (K == entry.getKey()) {
                    System.out.println("이녀석: " + entry.getKey() + " " + idx + " " + sep);
                    if (idx % sep != 0) {
                        System.out.println(grades[idx / sep - 1]);
                    } else {
                        System.out.println(grades[idx / sep]);
                    }
                    break;
                }
                idx++;
            }
        }
    }
}