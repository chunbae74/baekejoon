import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14503 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(st.nextToken());
		// 0 : 북
		// 1 : 동
		// 2 : 남
		// 3 : 서
		int d = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int ii = 0; ii < N; ii++) {
				board[i][ii] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 0;
		
		Loop: while (true) {
			// 현재칸이 청소가 안되어있는 경우
			if (board[r][j] != 0) {
				board[r][j] = 1;
				count ++;
			}
			
			boolean isFound = false;
			// (0, 0) 
			if (r == 0 && j == 0) {
				if (board[r][j + 1] == 0 && board[r + 1][j] == 0) {
					break Loop;
				} else if (board[r + 1][j] == 1) {
					d = 2;
					r ++;
					continue Loop;
				} else if (board[r + 1][j] == 0 && board[r][j + 1] == 1) {
					d = 1;
					j ++;
					continue Loop;
				}
			}
			// (0, 0) 
			if (r == 0 && j == 0) {
				if (board[r][j + 1] == 0 && board[r + 1][j] == 0) {
					break Loop;
				} else if (board[r + 1][j] == 1) {
					d = 2;
					r ++;
					continue Loop;
				} else if (board[r + 1][j] == 0 && board[r][j + 1] == 1) {
					d = 1;
					j ++;
					continue Loop;
				}
			}
			
			// (0, M - 1) 
			else if (r == 0 && j == M - 1) {
				if (board[r][j - 1] == 0 && board[r + 1][j] == 0) {
					break Loop;
				} else if (board[r + 1][j] == 1) {
					d = 2;
					r ++;
					continue Loop;
				} else if (board[r + 1][j] == 0 && board[r][j + 1] == 1) {
					d = 1;
					j ++;
					continue Loop;
				}
			}
			// (0, 0) 
			if (r == 0 && j == 0) {
				if (board[r][j + 1] == 0 && board[r + 1][j] == 0) {
					break Loop;
				} else if (board[r + 1][j] == 1) {
					d = 2;
					r ++;
					continue Loop;
				} else if (board[r + 1][j] == 0 && board[r][j + 1] == 1) {
					d = 1;
					j ++;
					continue Loop;
				}
			}
		}
	}

}
