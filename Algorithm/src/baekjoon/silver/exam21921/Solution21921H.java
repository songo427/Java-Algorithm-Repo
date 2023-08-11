import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution21921H {
    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int answer = 0;
        int cnt = 0;

        String[] line = br.readLine().split(" ");

        int[] numbers = new int[N];
        for(int num = 0; num < line.length; num ++){
            numbers[num] = Integer.parseInt(line[num]);
        }

        int left = 0;
        int right = X;
        int sum = 0;

        for(int i=left; i <right; i++) {
            sum += numbers[i];
        }

        while(true) {
            if(answer < sum) {
                answer = sum;
                cnt = 1;
            }else if(answer == sum) {
                cnt ++;
            }

            if(right == N) break;

            sum -= numbers[left];
            left ++;
            sum += numbers[right++];
        }

        if(answer == 0) {
            sb.append("SAD");
        }else {
            sb.append(answer).append("\n").append(cnt);
        }
        System.out.println(sb);
    }
}
