package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5014 {
	static int F, S, G;
	static int[] dir = new int[2];
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		dir[0] = Integer.parseInt(st.nextToken());
		dir[1] = -Integer.parseInt(st.nextToken());
		
		count = new int[F + 1];
		solve();
	}
	
	public static void solve() {
		boolean[] visited = new boolean[F + 1];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(S);
		visited[S] = true;
		count[S] = 0;
		
		while (queue.size() != 0) {
			int now = queue.poll();
			if (now == G) {
				System.out.println(count[now]);
				return;
			}
			
			for (int i = 0; i < 2; i++) {
				int next = now + dir[i];
				if (next > F || next < 1) {
					continue;
				}
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					count[next] = count[now] + 1;
				}
			}
		}
		System.out.println("use the stairs");
	}

}