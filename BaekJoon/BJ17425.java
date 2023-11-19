package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17425 {
	static int N;
	static int[] honey;
	static int[] toRightSum, toLeftSum;
	static int total;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		honey = new int[N];
		toRightSum = new int[N];
		toLeftSum = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int temp = 0;
		for (int i = 0; i < N; i++) {
			honey[i] = Integer.parseInt(st.nextToken());
			temp += honey[i];
			toRightSum[i] = temp;
		}
		
		temp = 0;
		for (int i = N - 1; i >= 0; i--) {
			temp += honey[i];
			toLeftSum[i] = temp;
		}
		
		total = toRightSum[N - 1];
		max = 0;
		
		leftEndBeehive();
		rightEndBeehive();
		middleBeehive();
		
		System.out.println(max);
		
		
	}
	
	//������ ���� ���� ���� ���(��1�� �ݵ�� ������ ���� ����)
	public static void leftEndBeehive() {
		int bee1 = 0;
		int bee2 = 0;
		
		//��2�� ��ġ ���� ���� Ž��
		for (int i = N - 2; i >= 1; i--) {
			bee1 = total - honey[N - 1] - honey[i];
			bee2 = total - toLeftSum[i];
			max = Math.max(max, bee1 + bee2);
		}
	}
	
	//������ ������ ���� ���� ���(��1�� �ݵ�� ���� ���� ����)
	public static void rightEndBeehive() {
		int bee1 = 0;
		int bee2 = 0;
		
		//��2�� ��ġ ���� ���� Ž��
		for (int i = 1; i < N - 1; i++) {
			bee1 = total - honey[0] - honey[i];
			bee2 = total - toRightSum[i];
			max = Math.max(max, bee1 + bee2);
		}
	}
	
	//������ ����� ���� ���(��1�� ��2�� �ݵ�� �糡�� ����)
		public static void middleBeehive() {
			int bee1 = 0;
			int bee2 = 0;
			
			//���� ��ġ ���� ���� Ž��
			for (int i = 1; i < N - 1; i++) {
				bee1 = toRightSum[i] - honey[0];
				bee2 = toLeftSum[i] - honey[N - 1];
				max = Math.max(max, bee1 + bee2);
			}
		}

}
