package baekjoon.gold.exam1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1461. 도서관
 * 이다은
 */
public class Solution1461D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] books = new int[N];
        st = new StringTokenizer(br.readLine());

        int leftCnt = 0;
        int rightCnt = 0;
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
            if (books[i] < 0) {
                leftCnt++;
            } else rightCnt++;
        }
        Arrays.sort(books);

        int answer = 0;
        int first = Math.abs(books[0]);
        int last = Math.abs(books[books.length-1]);
        int left = 0;
        int right = books.length-1;
        if (first > last) {
            answer += first;
            left += M;
            leftCnt -= M;
        } else {
            answer += last;
            right -= M;
            rightCnt -= M;
        }
        for (int i = left; i < left + leftCnt; i+=M) {
            answer += 2*Math.abs(books[i]);
        }

        for (int i = right; i > right - rightCnt; i-=M) {
            answer += 2*Math.abs(books[i]);
        }

        System.out.println(answer);

    }
}
