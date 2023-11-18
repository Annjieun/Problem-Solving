package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Identity;
import java.util.StringTokenizer;

public class SWEA1959 {
	static int N, M;
	static int[] A;
	static int[] B;
	static int max;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			A = new int[N];
			B = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			solve();
			System.out.printf("#%d %d\n", tc, max);
		}

	}
	
	public static void solve() {	
		if (M > N) {
			for (int i = 0; i <= M - N; i++) {
				int idx = i;
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += B[idx] * A[j];
					idx++;
				}
				if (sum > max) {
					max = sum;
				}
			}
		} else if (M < N){
			for (int i = 0; i <= N - M; i++) {
				int idx = i;
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += A[idx] * B[j];
					idx++;
				}
				if (sum > max) {
					max = sum;
				}
			}	
		
		}
	}

}
