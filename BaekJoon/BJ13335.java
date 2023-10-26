package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13335 {
	static Queue<Integer> truck;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		truck = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}

		int time = 0;
		int weight = 0;  //다리 위에 올라간 트럭의 무게 합
		Queue<Integer> bridge = new LinkedList<Integer>();
		for(int i = 0; i < W; i++) {
			bridge.add(0);
		}
		
		while(!bridge.isEmpty()) {
			time++;
			weight -= bridge.poll();  //1초가 지날 때마다 하나의 트럭이 다리를 벗어남.
			if(!truck.isEmpty()) {  //다리를 건너지 않은 트럭이 남아있다면
				if(weight + truck.peek() <= L) {  //현재 다리 위 올라간 트럭의 무게 + 아직 올라가지 않은 맨 앞의 트럭의 무게가 L을 넘지 않는다면
					weight += truck.peek();  //다음 트럭을 다리 위로 올림.
					bridge.offer(truck.poll());
				} else {  //L을 넘는다면 다리 위에 아무것도 올리지 않음.
					bridge.offer(0);
				}
			}
		}
		System.out.println(time);
	}

}
