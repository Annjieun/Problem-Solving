import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2580 {

    static int[][] map = new int[9][9];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
    }

    //(0, 0)부터 (9, 9)까지 탐색
    public static void sudoku(int row, int col) {
        
        //열이 9이면 다음 행으로 이동하여 탐색
        if(col == 9) {
            sudoku(row + 1, col);
            return;
        }

        //모든 칸에 대해 sudoku를 수행하였다면 출력 후 종료
        if(row == 9) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        //해당 칸이 빈칸이면 1부터 9중 어떤 값이 들어갈 수 있는지 check
        if(map[row][col] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(check(row, col, i)) {
                    map[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            //빈 칸이 1 ~ 9까지 유망성 검사를 통과하지 못하면 다시 초기화
            map[row][col] = 0;
            return;
        }
    }
        
    /**
     * value가 빈 칸에 들어갈 수 있는 지 확인
     * @return 들어갈 수 있다면 true, 그렇지 않으면 false
     */
    public static boolean check(int row, int col, int value) {

        //같은 행에 겹치는 값이 존재하는 지 확인
        for(int i = 0; i < 9; i++) {
            if(map[row][i] == value) {
                return false;
            }
        }

        //같은 열에 겹치는 값이 존재하는 지 확인
        for(int i = 0; i < 9; i++) {
            if(map[i][col] == value) {
                return false;
            }
        }

        //3*3 칸에 겹치는 값이 존재하는 지 확인
        int dr = (row / 3) * 3;
        int dc = (col / 3) * 3;

        for(int i = dr; i < dr + 3; i++) {
            for(int j = dc; i < dc + 3; j++) {
                if(map[i][j] == value) {
                    return false;
                }
            }
        }

        //겹치는 값이 없을 경우
        return true;
    }

}