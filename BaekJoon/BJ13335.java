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
		int weight = 0;  //�ٸ� ���� �ö� Ʈ���� ���� ��
		Queue<Integer> bridge = new LinkedList<Integer>();
		for(int i = 0; i < W; i++) {
			bridge.add(0);
		}
		
		while(!bridge.isEmpty()) {
			time++;
			weight -= bridge.poll();  //1�ʰ� ���� ������ �ϳ��� Ʈ���� �ٸ��� ���.
			if(!truck.isEmpty()) {  //�ٸ��� �ǳ��� ���� Ʈ���� �����ִٸ�
				if(weight + truck.peek() <= L) {  //���� �ٸ� �� �ö� Ʈ���� ���� + ���� �ö��� ���� �� ���� Ʈ���� ���԰� L�� ���� �ʴ´ٸ�
					weight += truck.peek();  //���� Ʈ���� �ٸ� ���� �ø�.
					bridge.offer(truck.poll());
				} else {  //L�� �Ѵ´ٸ� �ٸ� ���� �ƹ��͵� �ø��� ����.
					bridge.offer(0);
				}
			}
		}
		System.out.println(time);
	}

}
