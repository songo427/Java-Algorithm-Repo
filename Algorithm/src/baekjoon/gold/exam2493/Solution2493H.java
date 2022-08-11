package baekjoon.gold.exam2493;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * 2493. 탑
 * 송현주 - 미완성
 * */
public class Solution2493H {

    public static void main(String[] args) throws IOException {

        Stack<Integer> topList = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            topList.push(Integer.parseInt(tokenizer.nextToken()));
        }


        for (int i = N - 1; i >= 0; i--) {
            int curTop = topList.pop();
            int idx = topList.size();
            while (true) {
                if (idx <= 0) {
                    answer.append(0 + " ");
                    break;
                }
                if (curTop < topList.get(idx - 1)) {
                    answer.append(idx + " ");
                    break;
                }
                idx--;
            }
        }
        System.out.println(answer.reverse().toString().trim());
    }
}


//public class Main {
//
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int N = Integer.parseInt(br.readLine());
//        int[] num = new int[N];
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0 ; i < N ; i++) {
//            num[i] = Integer.parseInt(st.nextToken());
//        }
//        Stack<Integer> check = new Stack<Integer>();
//        StringBuilder sb = new StringBuilder();
//        for(int i = N-1 ; i >= 0 ;i--) {
//            while(!check.isEmpty() && num[check.peek()] < num[i]) {
//                num[check.pop()] = i+1;
//            }
//            check.push(i);
//        }
//        while(!check.isEmpty()) {
//            num[check.pop()] = 0;
//        }
//        for(int i = 0 ; i < N ; i++) {
//            sb.append(num[i]).append(' ');
//        }
//        System.out.println(sb);
//        br.close();
//    }
//}
