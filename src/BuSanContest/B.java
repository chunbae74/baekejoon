package BuSanContest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		int[][] board = new int[row][column];
		for(int i = 0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < column; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		boolean isDown = false;
		for(int i = 0; i < row; i++) {
			Loop1: while(!isClear(board[i])) { // 한 줄이 모두 0이 될때까지
				count ++;
				Loop2: for(int j = 0; j < column; j++) {
					if (j == 0) { // 첫 번째 인자인 경우
						if (board[i][j] < 1) { // 첫 번쨰 인자가 0인 경우
							isDown = false;
							continue Loop2;
						} else { // 첫번째 인자가 0이 아닌 경우
							isDown = true;
							board[i][j] --;
							continue Loop2;
						}
					} else {
						if (isDown) { // 붓이 내려가 있는 상태라면
							if (board[i][j] < 1) { // 0이라면
								isDown = false; // 붓 올리고
								continue Loop1;
							} else {
								board[i][j] --;
								continue Loop2;
							}
						} else { // 붓이 올라가 있는 상태라면
							if (board[i][j] < 1) { // 0이라면
								continue Loop2;
							} else {
								isDown = true; // 붓 내리고
								board[i][j] --;
								continue Loop2;
							}
						}
					}
				}
			}
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
	
	public static boolean isClear(int[] arr) {
		boolean isClear = true;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				isClear = false;
				break;
			}
		}
		return isClear;
	}

}
