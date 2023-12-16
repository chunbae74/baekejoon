import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int[][] board = new int[N][N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				sum += num;
				arr[i][j] = sum;
				board[i][j] = num;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			if (x1 == 1 && y1 == 1) sb.append(arr[x2 - 1][y2 - 1]).append("\n");
			else {
				x1 --;
				y1 -= 2;
				x2 --;
				y2 --;
				int result = 0;
				if (y1 < 0) {
					x1 --;
					y1 = N - 1;
					result = arr[x2][y2] - arr[x1][y1];
				}
				else {
					for (int j = x1; j <= x2; j++) {
						result += arr[j][y2] - arr[j][y1];					
					}
				}
				sb.append(result).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
