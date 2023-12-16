import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11650 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] board = new int[N][2];
		int x, y;
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			board[i][0] = x;
			board[i][1] = y;
		}
		Arrays.sort(board, (e1, e2) -> {
			if (e1[0] > e2[0]) return 1;
			else if (e1[0] == e2[0]) {
				if (e1[1] > e2[1]) return 1;
				else return -1;
			} else return -1;
		});
		for(int i = 0; i<N; i++) bw.write(board[i][0] + " " + board[i][1] + "\n");
		bw.flush();
		bw.close();
		/**
		 * 시간초과 뜨는 코드
		int[][] board = new int[N][2];
		int x, y;
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			board[i][0] = x;
			board[i][1] = y;
		}
		 
		for(int i = 0; i < N - 1; i++) {
			for(int j = i + 1; j < N; j++) {
				if (board[i][0] > board[j][0]) { // x값이 더 크면 교환
					int[] copy = board[i];
					board[i] = board[j];
					board[j] = copy;
				} else if (board[i][0] == board[j][0]) { // x값이 같으면
					if (board[i][1] > board[j][1]) { // y값이 더 크면 교환
						int[] copy = board[i];
						board[i] = board[j];
						board[j] = copy;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) bw.write(board[i][0] + " " + board[i][1] + "\n");
		bw.flush();
		bw.close();
		*/
	}

}
