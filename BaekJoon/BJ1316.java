package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1316 {
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		count = N;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			solve(str);
		}
		
		System.out.println(count);

	}
	
	public static void solve(String str) {
		boolean[] visited = new boolean[26];
		
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) != str.charAt(i + 1)) {
				if (visited[str.charAt(i + 1) - 97] == true) {
					count--;
					return;
				}
			}
			visited[str.charAt(i) - 97] = true;
		}

	}

}
