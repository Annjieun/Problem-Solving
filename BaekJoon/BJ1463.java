package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463 {

    static int[] dp;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[0] = dp[1] = 0;

        for(int i = 2; i <= N; i++) {
            //현재의 수에서 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;
            //현재의 수가 2로 나누어 떨어지는 경우
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            //현재의 수가 3으로 나누어 떨어지는 경우
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);

    }

}