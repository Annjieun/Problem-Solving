package Programmers;

public class Carpet {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] result = solution.solution(3004, 2996);
		System.out.printf("[%d, %d]", result[0], result[1]);
	}
	
	public static class Solution {
	    public int[] solution(int brown, int yellow) {
	        int[] answer = new int[2];
	        
	        int y_row = 0;
	        int y_col = 0;
	        for (int i = 1; i <= yellow; i++) {
	        	if (i * (yellow / i) == yellow) {
	        		y_row = Math.max(i, yellow / i);
			        y_col = Math.min(i, yellow / i);
	        	}
		        if (y_row * 2 + y_col * 2 + 4 == brown) {
		        	break;
		        }
	        }
	        
	        answer[0] = y_row + 2;
        	answer[1] = y_col + 2;
        	
	        return answer;
	    }
	}

}
