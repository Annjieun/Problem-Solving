package Programmers;


public class BaseStationInstall {

	public static void main(String[] args){
		Solution solution = new Solution();
		System.out.println(solution.solution(16, new int[]{9}, 2));
	}
	
	public static class Solution {
		public int solution(int n, int[] stations, int w) {
	        int answer = 0;
	        int leftStart = 1;
	        
	        //처음으로 전파된 후, 기지국 왼쪽에 전파되지 않은 아파트를 탐색
	        for (int station : stations) {
	        	if (leftStart < station - w) {
	        		answer += install(leftStart, station - w - 1, w);
	        	}
	        	leftStart = station + w + 1;
	        }
	        
	        //오른쪽에 전파되지 않은 아파트가 있다면
	        if (stations[stations.length - 1] + w < n) {
	        	answer += install(stations[stations.length - 1] + w + 1, n, w);
	        }
	        
	        return answer;
			
		}
		
		public int install(int start, int end, int w) {
			int noSpreadCount = end - start + 1;
			int installCount = noSpreadCount / (w * 2 + 1);
			if (noSpreadCount % (w * 2 + 1) != 0) {
				installCount++;
			}
			return installCount; 
		}
	}

}
