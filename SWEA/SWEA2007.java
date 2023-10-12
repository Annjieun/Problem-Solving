package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2007 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			for(int i = 1; i < s.length() / 2; i++) {
				if(s.substring(0, i).equals(s.substring(i, i * 2))) {
					System.out.printf("#%d %d\n", tc, i);
					break;
				}
			}
		}

	}

}
