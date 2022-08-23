package programmers.targetNum;

/**
 * L2. 타겟넘버
 * 송현주
 */
public class SolutionH {

    static int N;
    static int[] operators;
    static int[] numbers;
    static int target;

    static int answer;
    public static void main(String[] args) {

        // test
        int[] input = {1,1,1,1,1};
        int t = 3;
        System.out.println(solution(input, t));
    }

    public static int solution(int[] input, int t) {
        N = input.length;
        numbers = input;
        target = t;
        operators = new int[N];
        perm(0, 0);
        return answer;
    }

    public static void perm(int cnt, int start) {
        if (cnt == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum = operators[i] == 0 ? sum - numbers[i] : sum + numbers[i];
            }
            if(sum == target){
                answer ++;
            }
            return;
        }

        for (int i = start; i < 2; i++) {
            operators[cnt] = i;
            perm(cnt + 1, start);
        }
    }
}
