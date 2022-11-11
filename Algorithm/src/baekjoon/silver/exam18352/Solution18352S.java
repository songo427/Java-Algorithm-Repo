package baekjoon.silver.exam18352;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution18352S {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt(); //도시개수
    int M = scanner.nextInt(); //도로개수
    int K = scanner.nextInt(); //거리
    int X = scanner.nextInt(); //출발도시

    Map<Integer, List<Integer>> cities = new HashMap<>();
    int[] distance = new int[N+1]; //X 도시에서 index 도시 까지의 최단거리
    boolean[] visited = new boolean[N+1];
    Arrays.fill(visited, false);
    visited[X] = true;

    for(int i=0; i<M; i++){
      int city = scanner.nextInt();
      int neighbor = scanner.nextInt();
      List<Integer> neighbors = cities.getOrDefault(city, new ArrayList<>());
      neighbors.add(neighbor);

      cities.put(city, neighbors);
    }

    Queue<Integer> routes = new LinkedList<>();
    routes.offer(X);

    while(!routes.isEmpty()){
      int currentCity = routes.poll();

      for(int neighbor : cities.getOrDefault(currentCity, new ArrayList<>())){
        if(!visited[neighbor]){
          distance[neighbor] = distance[currentCity] + 1;
          visited[neighbor] = true;

          routes.add(neighbor);
        }
      }
    }

    boolean exists = false;
    for(int i=1; i<=N; i++){
      if(distance[i]==K){
        System.out.println(i);
        exists = true;
      }
    }
    if(!exists) System.out.println(-1);
  }
}
