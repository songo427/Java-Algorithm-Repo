package programmers.targetNum;


/**
 * L2. 타겟넘버
 * 송현주
 */
public class SolutionH_DFS {

    static int answer;

    public static void main(String[] args) {

        // test
        int[] input = {1,1,1,1,1};
        int t = 3;
        System.out.println(solution(input, t));
    }

    public static int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }


    private static void dfs(int[] numbers, int target, int index, int sum) {

        if (index == numbers.length) {
            if(target == sum){
                answer++;
            }
            return;
        }

        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}

