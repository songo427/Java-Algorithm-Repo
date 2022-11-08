package baekjoon.gold.exam11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 2141. 강의실 배정
 * 송현주
 */
public class Solution11000H {

    // 수업
    static class Lecture implements Comparable<Lecture> {
        int start, end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Lecture{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }

    public static Lecture[] lectures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 수업 목록 저장
        lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 정렬
        Arrays.sort(lectures);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(lectures[0].end);

        // 두번째 강의부터 비교
        for (int i = 1; i < N; i++) {
            if (lectures[i].start >= queue.peek()) {
                queue.poll();
            }
            queue.offer(lectures[i].end);
        }

        System.out.println(queue.size());
    }
}
