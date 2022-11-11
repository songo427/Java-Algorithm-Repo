package baekjoon.gold.exam2141;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution2141S {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    double totalPeople = 0;
    Map<Integer, Integer> towns = new TreeMap<>();

    for(int i=0; i<N; i++){
      int townNum = scanner.nextInt();
      int townPeople = scanner.nextInt();

      towns.put(townNum, townPeople);
      totalPeople += townPeople;
    }

    double peopleSum = 0;

    for(int townNum : towns.keySet()){
      peopleSum += towns.get(townNum);

      if(peopleSum >= totalPeople/2){
        System.out.println(townNum);
        break;
      }
    }
  }
}
