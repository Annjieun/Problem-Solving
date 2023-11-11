package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {
	static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		for (int i = 1; i <= 10; i++) {
			queue = new LinkedList<>();
			sb = new StringBuilder();
			int tc = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 8; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			solve();
			for (int k = 0; k < 8; k++) {
				sb.append(queue.poll()).append(" ");
			}
			System.out.printf("#%d %s\n", i, sb);
		}

	}
	
	public static void solve() {
		while (true) {
			if (isCycleEnd() == true) {
				break;
			}
		}
	}
	
	public static boolean isCycleEnd() {
		int decreaseUnit = 1;
		for (int i = 0; i < 5; i++) {
			int current = queue.poll();
			
			int newValue = current - decreaseUnit;
			if (newValue <= 0) {
				queue.offer(0);
				return true;
			} else {
				queue.offer(newValue);
			}
			decreaseUnit++;
		}
		return false;
	}

}
