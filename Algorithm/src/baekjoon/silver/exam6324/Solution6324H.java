package baekjoon.silver.exam6324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 6324. URLs
 * 송현주
 * */
public class Solution6324H {
    static StringBuilder originUrl, answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        answer = new StringBuilder();

        for (int testCase = 1; testCase <= T; testCase++) {
            answer.append("URL #").append(testCase).append(" \n");
            originUrl = new StringBuilder(br.readLine().trim());

            String[] urlSet = originUrl.toString().split("://");
            answer.append("Protocol = ").append(urlSet[0]).append("\n");

            if(!urlSet[1].contains(":") && !urlSet[1].contains("/")){
                answer.append("Host     = ").append(urlSet[1]).append("\n");
                answer.append("Port     = <default>").append("\n");
                answer.append("Path     = <default>").append("\n");
            }

            // port가 있다면,
            if(urlSet[1].contains(":")) {
                String[] host = urlSet[1].split(":");
                answer.append("Host     = ").append(host[0]).append("\n");
                findPath(host[1]);
            }else {
                if(urlSet[1].contains("/")){
                    int idx = urlSet[1].indexOf("/");
                    answer.append("Host     = ").append(urlSet[1], 0, idx).append("\n");
                    answer.append("Port     = <default>").append("\n");
                    answer.append("Path     = ").append(urlSet[1].substring(idx+1)).append("\n");
                }
            }

            answer.append("\n");

        }
        System.out.println(answer.toString().trim());

    }

    private static void findPath(String url){
        if(url.contains("/")){
            System.out.println(url);
            int idx = url.indexOf("/");
            answer.append("Port     = ").append(url, 0, idx).append("\n");
            answer.append("Path     = ").append(url.substring(idx+1)).append("\n");
        }else {
            System.out.println(url);
            answer.append("Port     = ").append(url).append("\n");
            answer.append("Path     = <default>").append("\n");
        }
    }
}

