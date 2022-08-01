package baekjoon.exam1244;

import java.util.Scanner;

/**
 * 1244. 스위치 켜고 끄기
 * 송현주
 */

public class Solution1244H {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numOfSwitch = sc.nextInt();
        int[] switchStates = new int[numOfSwitch];

        for (int i = 0; i < numOfSwitch; i++) {
            switchStates[i] = sc.nextInt();
        }
        int numOfStudents = sc.nextInt();
        int[][] students = new int[numOfStudents][2];

        for (int i = 0; i < numOfStudents; i++) {
            students[i][0] = sc.nextInt(); // 성별
            students[i][1] = sc.nextInt(); // 스위치 번호
        }


        // 스위치 상태 변경
        for (int i = 0; i < numOfStudents; i++) {
            // 남학생이라면,
            if (students[i][0] == 1) {
                for (int k = students[i][1]; k <= numOfSwitch; ) {
                    switchStates[k - 1] = switchStates[k - 1] == 0 ? 1 : 0;
                    k += students[i][1];
                }
            } else { // 여학생이라면,
                switchStates[students[i][1] - 1] = switchStates[students[i][1] - 1] == 0 ? 1 : 0;
                for (int k = 1; students[i][1] - k > 0 && k + students[i][1] <= numOfSwitch; k++) {
                    if (switchStates[students[i][1] - k - 1] == switchStates[students[i][1] + k - 1]) {
                        switchStates[students[i][1] - k - 1] = switchStates[students[i][1] - k - 1] == 0 ? 1 : 0;
                        switchStates[students[i][1] + k - 1] = switchStates[students[i][1] + k - 1] == 0 ? 1 : 0;

                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < numOfSwitch; i++) {
            if (i != 0 && i % 20 == 0) {
                System.out.print("\n" + switchStates[i] + " ");
            } else {
                System.out.print(switchStates[i] + " ");
            }
        }
    }
}
