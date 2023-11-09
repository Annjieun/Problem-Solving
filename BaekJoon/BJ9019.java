package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9019 {
	static int A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			Queue<Integer> queue = new LinkedList<>();
			String[] answer = new String[10000];
			boolean[] visited = new boolean[10000];
			
			queue.add(A);
			visited[A] = true;
			Arrays.fill(answer, "");  // answer 배열 초기화
			
			while (!queue.isEmpty() && !visited[B]) {
				int now = queue.poll();
				
				int D = (now * 2) % 10000;
				int S = now == 0 ? 9999 : now - 1;
				int L = (now % 1000) * 10 + (now / 1000);
				int R = (now % 10)* 1000 + (now / 10);
				
				if (!visited[D]) {
					queue.add(D);
					visited[D] = true;
					answer[D] = answer[now] + "D";
				}
				
				if (!visited[S]) {
					queue.add(S);
					visited[S] = true;
					answer[S] = answer[now] + "S";
				}
				
				if (!visited[L]) {
					queue.add(L);
					visited[L] = true;
					answer[L] = answer[now] + "L";
				}
				
				if (!visited[R]) {
					queue.add(R);
					visited[R] = true;
					answer[R] = answer[now] + "R";
				}
			}
			System.out.println(answer[B]);
		}

	}

}
