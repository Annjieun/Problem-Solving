package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1182 {
	static int N, S;
	static int[] arr;
	static int count;
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		count = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solve(0, 0);
		if (S == 0) {  //S가 0이면 공집합도 될 수 있으므로 1개를 뺴준다.
			System.out.println(count - 1);
		}
		else {
			System.out.println(count);
		}

	}
	
	public static void solve(int index, int sum) {
		if (index == N) {
			if (sum == S) {
				count++;
			}
			return;
		}
			
		solve(index + 1, sum + arr[index]); //현재 인덱스의 값 더하기
		solve(index + 1, sum);  //현재 인덱스의 값 넘어가기
	}

}
