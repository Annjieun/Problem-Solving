import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2343 {
    
    public static int[] lectures;
    public static int n, m;

    public static int lowerBound(int start, int end, int target) {
        while(start < end) {
            int mid = (start + end) / 2;
            if(getCount(mid) > target) {
                start = mid + 1;
            } else {
                end = mid;  
            }
        }
        return start;
    }

    public static int getCount(int mid) {
        int cnt = 1;
        int remain = mid;
        for(int i = 0; i < n; i++) {
            if(lectures[i] > remain) {
                remain = mid;
                cnt++;
            }
            remain -= lectures[i];
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        lectures = new int[n];

        int sum = 0;
        int maxLecture = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            sum += lectures[i];
            if(maxLecture < lectures[i]) {
                maxLecture = lectures[i];
            }
        }

        System.out.println(lowerBound(maxLecture, sum, m));
    }
}