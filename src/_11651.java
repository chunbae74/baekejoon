import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11651 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][2];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(board, (e1, e2) -> {
			if (e1[1] == e2[1]) return e1[0] - e2[0];
			else return e1[1] - e2[1];
		});
		
		for(int i = 0; i < N; i++) bw.write(board[i][0] + " " + board[i][1] + "\n");
		bw.flush();
		bw.close();
	}

}
