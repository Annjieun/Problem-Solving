package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5215 {
	static int N, L;
	static int[] scores;
	static int[] calories;
	static int maxScore;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());  //재료의 수 : 5
			L = Integer.parseInt(st.nextToken());  //제한 칼로리 : 1000
			
			scores = new int[N];
			calories = new int[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(st.nextToken());
				calories[i] = Integer.parseInt(st.nextToken());
			}
			maxScore = 0;
			solve(0, 0, 0);
			
			System.out.printf("#%d %d\n", tc, maxScore);
		}

	}
	
	public static void solve(int idx, int score, int cal) {
		if(cal > L) {
			return;
		}
		if(cal <= L) {
			maxScore = Math.max(maxScore, score);
		}
		if(idx == N) {
			return;
		}
			
		solve(idx + 1, score + scores[idx], cal + calories[idx]);
		solve(idx + 1, score, cal);
	}

}
