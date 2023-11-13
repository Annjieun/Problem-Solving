package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Identity;
import java.util.StringTokenizer;

public class SWEA1220 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc ++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[T][T];
			int count = 0;
			
			for (int i = 0; i < T; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < T; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//1Àº N±Ø(»¡°­), 2´Â S±Ø(ÆÄ¶û)
			for (int i = 0; i < T; i ++) {
				for (int j = 0; j < T; j++) {
					if (map[i][j] == 1) {  //N±ØÀÌ¶ó¸é
						for (int k = i + 1; k < T; k++) {
							if (map[k][j] == 1) {
								break;
							}
							else if (map[k][j] == 2) {
								count++;
								break;
							}
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}

	}

}
