package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();  //������ �ܾ� ó����
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		boolean flag = false;  //���� ������ ���� ���� �Ǻ���
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				flag = true;
				
			} else if (str.charAt(i) == '>'){
				sb.append('>');
				flag = false;
				continue;
			}
			
			if (flag) {
				sb.append(str.charAt(i));
			} else if (!flag) {
				if (str.charAt(i) == ' ') {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(' ');
				} else {
					stack.push(str.charAt(i));
				}
			}
			
			//���ÿ� �����ִ� �ܾ �ִٸ�
			if (i == str.length() - 1) {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
			}
			
		}
		System.out.println(sb.toString());
	}

}
