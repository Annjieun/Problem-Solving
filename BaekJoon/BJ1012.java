package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1012 {
	static int M, N, K;
	static int[][] map;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited;
	static int count;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[M][N];
			visited = new boolean[M][N];
			count = 0;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						solve(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}

	}
	
	public static void solve(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int now_x = queue.peek()[0];
			int now_y = queue.peek()[1];
			queue.poll();
			
			for (int i = 0; i < 4; i++) {
					int nx = now_x + dx[i];
					int ny = now_y + dy[i];
					if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]) {
						if (map[nx][ny] == 1) {
							visited[nx][ny] = true;
							queue.add(new int[] {nx, ny});
						}
					}	
			}
		}
	}
}
