package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1992 {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		partition(0, 0, N);
		System.out.println(sb);
	}
	
	public static void partition(int row, int col, int size) {
		if (isSameColor(row, col, size)) {
			sb.append(arr[row][col]);
			return;
		}
		
		// 새로 분할할 때마다 ()를 추가해야한다.
		sb.append('(');
		
		int partitionSize = size / 2;
		partition(row, col, partitionSize);
		partition(row, col + partitionSize, partitionSize);
		partition(row + partitionSize, col, partitionSize);
		partition(row + partitionSize, col + partitionSize, partitionSize);
		
		sb.append(')');
	}
	
	public static boolean isSameColor(int row, int col, int size) {
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
