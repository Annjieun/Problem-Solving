package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1230 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			List<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				String command = st.nextToken();
				if (command.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					int idx = x;
					for (int k = 0; k < y; k++) {
						list.add(idx, Integer.parseInt(st.nextToken()));
						idx++;
					}
				} else if (command.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int k = 0; k < y; k++) {
						list.remove(x);
					}
				} else if (command.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					for (int k = 0; k < y; k++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
				}
				
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			System.out.printf("%s\n", sb.toString().trim());
		}
	}

}
