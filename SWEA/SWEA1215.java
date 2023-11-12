package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			char[][] arr = new char[8][8];
			int count = 0;
			boolean flag = true;
			
			for(int i = 0; i < 8; i++) {
				String str = br.readLine();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			//가로
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - N + 1; j++) {
					flag = true;
					for (int k = 0; k < N / 2; k++) {
						if (arr[i][j + k] != arr[i][j - k + N - 1]) {
							flag = false;
						}
					}
					if (flag == true) {
						count++;
					}
				}
			}
			
			//세로
			for (int i = 0; i < 8 - N + 1; i++) {
				for (int j = 0; j < 8; j++) {
					flag = true;
					for (int k = 0; k < N / 2; k++) {
						if (arr[i + k][j] != arr[i - k + N - 1][j]) {
							flag = false;
						}
					}
					if (flag == true) {
						count++;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}

	}
	
}
