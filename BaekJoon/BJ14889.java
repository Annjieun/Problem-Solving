package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889 {
	static int N;
	static int[][] status;
	static boolean[] visited;
	static int minDiff = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		status = new int[N][N];
		visited = new boolean[N];
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				status[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
		System.out.println(minDiff);
	}
	
	/**
	 * N / 2������ ���� ������.
	 */
	public static void dfs(int num, int count) {
		if (count == N / 2) {
			getScore();
			return;
		}
		
		for (int i = num; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}
	
	/**
	 * �� ���� �ɷ�ġ�� ���ϰ�, �� ���� �ɷ�ġ ������ �ּڰ��� ���Ѵ�.
	 */
	public static void getScore() {
		int start = 0;
		int link = 0;
		
		for (int i = 0; i < N - 1 ; i++) {
			for (int j = i + 1; j < N; i++) {
				// �� ����� ��ŸƮ���� ���
				if (visited[i] == true && visited[j] == true) {
					start += status[i][j];
					start += status[j][i];
				}
				// �� ����� ��ũ���� ���
				if (visited[i] == false && visited[j] == false) {
					link += status[i][j];
					link += status[j][i];
				}
			}
		}
		
		// �� ���� ���� ����(����)
		int diff = Math.abs(start - link);
		
		if (diff == 0) {
			System.out.println(diff);
			System.exit(0);;
		}
		
		minDiff = Math.min(diff, minDiff);
	}

}

