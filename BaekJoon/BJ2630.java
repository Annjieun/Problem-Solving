package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {
	static int N;
	static int[][] arr;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		partition(0, 0, N);
		System.out.println(white);
		System.out.println(blue);	
	}
	
	public static void partition(int row, int col, int size) {
		if (isColorSame(row, col, size)) {
			if (arr[row][col] == 0) {
				white ++;
			}
			if (arr[row][col] == 1) {
				blue ++;
			}
			return;
		}
		
		// 4등분으로 나눈다.
		int partitionSize = size / 2;
		partition(row, col, partitionSize);
		partition(row + partitionSize, col, partitionSize);
		partition(row, col + partitionSize, partitionSize);
		partition(row + partitionSize, col + partitionSize, partitionSize);
	}
	
	
	public static boolean isColorSame(int row, int col, int size) {
		int color = arr[row][col];
		
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (arr[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}

}
