package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ13023 {
	static int N, M;
	static ArrayList<ArrayList<Integer>> freind;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		freind = new ArrayList<ArrayList<Integer>>(N);
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			freind.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			freind.get(a).add(b);
			freind.get(b).add(a);
		}
		
		//각 친구마다 깊이가 4인 것을 확인한다.
		for (int i = 0; i < N; i++) {
			dfs(i, 0);
		}
		
		System.out.println(0);
	}
	
	public static void dfs(int idx, int depth) {
		visited[idx] = true;
		if (depth == 4) {
			System.out.println(1);
            System.exit(0);
		}
		
		for (int i : freind.get(idx)) {
			if (!visited[i]) {
				dfs(i, depth + 1);
			}
		}
		visited[idx] = false;
	}

}
