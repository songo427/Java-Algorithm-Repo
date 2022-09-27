package baekjoon.gold.exam1581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1581. 락스타 락동호
 * 송현주
 */

public class Solution1581H {
    static int[] songs;

    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        songs = new int[4];
        for (int i = 0; i < 4; i++) {
            songs[i] = Integer.parseInt(st.nextToken());
        }

        int answer = calcMaxSongCnt();
        System.out.print(answer);

    }

    // 최대 곡의 수 구하기
    private static int calcMaxSongCnt() {
        // FF와 FS가 0이고, SF가 0이 아니라면 SS+1, SF가 0이면 SS 리턴
        if (songs[0] == 0 && songs[1] == 0) {
            return songs[2] > 0 ? songs[3] + 1 : songs[3];
        } else {
            // FF는 0이 아니고, FS는 0이라면 FF 리턴
            if (songs[1] == 0) return songs[0];

            // FS > SF 비교
            return songs[1] > songs[2]
                   ? songs[0] + songs[3] + songs[2] + songs[2] + 1
                   : songs[0] + songs[3] + songs[1] + songs[1];
        }
    }
}
