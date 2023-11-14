package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SWEA1221 {
	static String[] arr;
	static int[] number;
	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		map.put("ZRO", 0);
		map.put("ONE", 1);
		map.put("TWO", 2);
		map.put("THR", 3);
		map.put("FOR", 4);
		map.put("FIV", 5);
		map.put("SIX", 6);
		map.put("SVN", 7);
		map.put("EGT", 8);
		map.put("NIN", 9);
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			String tcString = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			
			arr = new String[N];
			number = new int[N];
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
				number[i] = map.getOrDefault(arr[i], 0);
			}
			
			Arrays.sort(number);
			for (int i = 0; i < number.length; i++) {
				for (Map.Entry<String, Integer> entry : map.entrySet()) {
					if (entry.getValue().equals(number[i])) {
						sb.append(entry.getKey()).append(" ");
					}
				}
			}
			System.out.printf("#%d\n", tc);
			System.out.println(sb.toString().trim());
		}
	}
}
