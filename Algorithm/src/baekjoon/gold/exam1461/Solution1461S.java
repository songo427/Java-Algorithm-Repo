package baekjoon.gold.exam1461;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1461S {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int result = 0;

    int N = scanner.nextInt();
    int M = scanner.nextInt();

    int[] books = new int[N];
    int zeroPointer = 0;

    for(int i=0; i<books.length; i++){
      books[i] = scanner.nextInt();
      if(books[i] < 0) zeroPointer++;
    }

    Arrays.sort(books);

    //음수 책
    for(int i=0; i<zeroPointer; i+=M){
      result += Math.abs(books[i]) * 2;
    }

    //양수 책
    for(int i=books.length-1; i>=zeroPointer; i-=M){
      result += Math.abs(books[i]) * 2;
    }

    int lastBook = Math.max(Math.abs(books[0]), Math.abs(books[books.length-1]));
    result -= lastBook;

    System.out.println(result);
  }
}
