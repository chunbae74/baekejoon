import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int ROW = 5;
		char[][] board = new char[ROW][];
		int maxLen = 0;
		for (int i = 0; i < ROW; i++) {
			String s = br.readLine();
			if (maxLen < s.length()) maxLen = s.length();
			board[i] = new char[s.length()];
			for (int j = 0; j < s.length(); j++) board[i][j] = s.charAt(j);
		}
		for (int j = 0; j < maxLen; j++) {
			for (int i = 0; i < ROW; i++) {
				if (j > board[i].length - 1) continue;
				/*
				 * char 배열의 초기 값이 '\0'인것을 이용할 수도 있다.
				 * 문제에 단어는 최대 15개의 글자들로 이루어진다 했으므로
				 * char[][] board new char[ROW][15]; 로 선언한후, 
				 * if (board[i][j] == '\0') continue; 로 처리할 수도 있음.
				 */
				else bw.write(board[i][j]);
			}
		}
		bw.flush();
		bw.close();
	}

}
