package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Identity;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1234 {
	static int N;
	static List<Integer> numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			numbers = new ArrayList<>();
			sb = new StringBuilder();
			
			String str = st.nextToken();
			for (int i = 0; i < N; i++) {
				numbers.add(str.charAt(i) - '0');
			}
			solve();
			for (int i = 0; i < numbers.size(); i++) {
				sb.append(numbers.get(i));
			}
			
			System.out.printf("#%d %s\n", tc, sb.toString());
		}

	}
	
	public static void solve() {
        int i = 0;
        while (i < numbers.size() - 1) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.remove(i);
                numbers.remove(i);
                if (i > 0) {
                	i--;
                }
            } else {
            	i++;
            }
        }
	}
}
