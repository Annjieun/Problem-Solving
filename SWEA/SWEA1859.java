package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열의 최댓값에서 파는 게 좋음.

public class SWEA1859 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long profit = 0;
            int max = 0;
            int[] price = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < N; j ++) {
                price[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = N - 1; j >= 0; j--) {
                if(price[j] > max) {
                    max = price[j];
                }
                profit += max - price[j];

            }
            System.out.printf("#%d %d\n", i + 1, profit);

        }

    }
}