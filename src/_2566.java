import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2566 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] board = new int[9][9];
		int max = -1, num, x = 0, y = 0;
		StringTokenizer st;
		for (int i = 0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				num = Integer.parseInt(st.nextToken());
				if (num > max) {
					max = num;
					x = (i+1);
					y = (j+1);
				}
				board[i][j] = num;
			}
		}
		bw.write(max + "\n" + x + " " + y);
		bw.flush();
		bw.close();
	}

}
