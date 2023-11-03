package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA3499 {
	static List<String> deck = new ArrayList<>();
	static List<String> result = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			deck.clear();
			result.clear();
			for(int i = 0; i < N; i++) {
				deck.add(st.nextToken());
			}
			
			System.out.printf("#%d ", tc);
			result = solve(N);
			for (String card : result) {
				System.out.print(card + " ");
			}
			System.out.println();
		}

	}
	
	public static List<String> solve(int n) {
		List<String> left = new ArrayList<>();
		List<String> right = new ArrayList<>();
		
		if(n % 2 != 0) {
			n++;
		}
		
		for (int i = 0; i < n / 2; i++) {
			left.add(deck.get(i));
		}
		
		for (int i = n / 2; i < deck.size(); i++) {
			right.add(deck.get(i));
		}
		
		int size = Math.min(left.size(), right.size());
		
		for (int i = 0; i < size; i++) {
			result.add(left.get(i));
			result.add(right.get(i));
		}
		
		if(left.size() > right.size()) {
			result.add(left.get(left.size() - 1));
		}
	
		return result;
	}

}
