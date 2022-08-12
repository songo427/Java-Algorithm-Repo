package baekjoon.silver.exam11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 11286. 절댓값 힙
 * 송현주
 */
public class Solution11286H {
    static PriorityQueue<Num> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int current = Integer.parseInt(br.readLine().trim());
            if (current == 0) {
                if (queue.isEmpty()) {
                    answer.append(0 + "\n");
                } else {
                    answer.append(queue.poll().origin).append("\n");
                }
            } else {
                queue.add(new Num(current, Math.abs(current)));
            }
        }
        System.out.println(answer.toString().trim());

    }

}

class Num implements Comparable<Num> {
    int origin;
    int abs;

    public Num(int origin, int abs) {
        this.origin = origin;
        this.abs = abs;
    }

    @Override
    public int compareTo(Num o) {
        if (this.abs == o.abs) {
            return this.origin - o.origin;
        }
        return this.abs - o.abs;
    }
}
