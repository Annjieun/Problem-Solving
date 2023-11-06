import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {

    public static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            if(binarySearch(Integer.parseInt(st.nextToken()))) {
                sb.append(1).append('\n');
            }
            else {
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);
    }

    /**
     * @param n - 찾으려는 값
     * @return n이 존재 - true, n이 존재 X - false
     */
    public static boolean binarySearch(int n) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(n > arr[mid]) start = mid + 1;
            else if(n < arr[mid]) end = mid - 1;
            else if(n == arr[mid]) return true;
        }

        return false;
    }
}