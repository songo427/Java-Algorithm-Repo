package baekjoon.silver.exam1446;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution1446S {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int D = scanner.nextInt();

    List<Shortcut> shortcuts = new ArrayList<>();

    for(int i=0; i<N; i++){
      int start = scanner.nextInt();
      int end = scanner.nextInt();
      int distance = scanner.nextInt();

      Shortcut shortcut = new Shortcut(start, end, distance);
      shortcuts.add(shortcut);
    }

    int[] dp = IntStream.range(0, D+1).toArray();

    for(int i=0; i<=D; i++){
      if(i!=0) dp[i] = Math.min(dp[i], dp[i-1]+1);

      for(Shortcut shortcut : shortcuts){
        if(shortcut.start == i && shortcut.end <= D &&
            dp[i] + shortcut.distance < dp[shortcut.end]){

          dp[shortcut.end] = dp[i] + shortcut.distance;
        }
      }
    }

    System.out.println(dp[dp.length-1]);
  }

  static class Shortcut{
    int start;
    int end;
    int distance;

    public Shortcut(int start, int end, int distance) {
      this.start = start;
      this.end = end;
      this.distance = distance;
    }
  }
}
