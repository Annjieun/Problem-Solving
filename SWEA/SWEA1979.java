package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1979 {
	static int N, K;
	static int[][] map;
	static int[] dx = {1, -1};
	static int[] dy = {1, -1};
	static boolean[][] visited;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					// 흰 색 : 1, 검은색 : 0
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//행 검사하기
			int count = 0;
			for (int i = 0; i < N; i++) {
				int size = 0;
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						size++;
					} else {
						if (size == K) {
							count++;
						}
						size = 0;
					}
				}
				if (size == K) {
					count++;
				}
			}
			
			//열 검사하기
			for (int j = 0; j < N; j++) {
				int size = 0;
				for (int i = 0; i < N; i++) {
					if (map[i][j] == 1) {
						size++;
					} else {
						if (size == K) {
							count++;
						}
						size = 0;
					}
				}
				if (size == K) {
					count++;
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}

	}
	

}
