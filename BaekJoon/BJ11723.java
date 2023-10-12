package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11723 {
    static int M;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        M = Integer.parseInt(br.readLine());
        arr = new int[M + 1];

        String oper;
        int x;
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            oper = st.nextToken();
            x = Integer.parseInt(st.nextToken());
            System.out.println(operator(oper, x));
        }
    }

    public static int operator(String oper, int x) {

        return 1;
    }
}
