package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1289 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			String memory = br.readLine();
			int cnt = 0;
			char before = '0';
			for(int i = 0; i < memory.length(); i++) {
				if(before != memory.charAt(i)) {
					before = memory.charAt(i);
					cnt++;
				}
			}
			System.out.printf("#%d %d\n", tc + 1, cnt);
		}

	}

}
