package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA1926 {

    public static int getClapNum(int num) {
        int clapNum = 0;
        
        while (num > 0) {
            int digit = num % 10;
            if(digit == 3 || digit == 6 || digit == 9) {
            	clapNum++;
            }
            num /= 10;
        }

        return clapNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
        	int clapNum = getClapNum(i);
            if(clapNum == 0) {
                sb.append(i);
            }
            else {
            	for(int j = 0; j < clapNum; j++) {
            		sb.append("-");
            	}
            }
            sb.append(" ");
        }
        
        System.out.print(sb.toString().trim());
    }
}
