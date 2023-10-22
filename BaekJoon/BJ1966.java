package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1966 {
	static int N;
	static int M;
	static Queue<Integer> queue;
	static Queue<Integer> indexQueue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			queue = new LinkedList<>();
			indexQueue = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++ ) {
				queue.offer(Integer.parseInt(st.nextToken()));
				indexQueue.offer(i);
			}
			getResult();
		}

	}
	
	public static void getResult() {
		int count = 0;
		
		while(!queue.isEmpty()) {
			int max = Collections.max(queue);
			int current = queue.poll();
			int currentIndex = indexQueue.poll();
			
			if(current == max) {
				count++;
				if(currentIndex == M) {
					System.out.println(count);
					break;
				}
				
			} else {
				queue.offer(current);
				indexQueue.offer(currentIndex);
			}
		}
	}
	
}
