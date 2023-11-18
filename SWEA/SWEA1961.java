package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1961 {
	static int N;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] map_90 = rotation(map);
			int[][] map_180 = rotation(map_90);
			int[][] map_270 = rotation(map_180);
			
			System.out.printf("#%d\n", tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map_90[i][j]);
				}
				System.out.print(" ");
				
				for (int j = 0; j < N; j++) {
					System.out.print(map_180[i][j]);			
				}
				System.out.print(" ");
				
				for (int j = 0; j < N; j++) {
					System.out.print(map_270[i][j]);			
				}
				System.out.println();
			}
		}
	}

	public static int[][] rotation(int[][] map) {
		int[][] result = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = map[N - 1 - j][i];
			}
		}
		
		return result;
	}

}
