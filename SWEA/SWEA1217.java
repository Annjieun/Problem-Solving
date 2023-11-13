package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int multiValue = 1;
			for (int i = 0; i < M; i++) {
				multiValue = solve(multiValue, N);
			}
			System.out.printf("#%d %d\n", T, multiValue);
		}

	}
	
	public static int solve(int num1, int num2) {
		return num1 * num2;
	}

}
