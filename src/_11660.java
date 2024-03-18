import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 반례: https://www.acmicpc.net/board/view/120420
 */
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
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				int num = Integer.parseInt(st.nextToken());
				sum += num;
				arr[y][x] = sum;
				board[y][x] = num;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			// 0,0에서 시작
			if (x1 == 0 && y1 == 0) {
				sb.append(arr[y2][x2]).append("\n");
			}
			// 중간지점에서 시작
			else {
				// 시작과 끝이 같음
				if (x1 == x2 && y1 == y2) {
					sb.append(arr[y1][x1]).append("\n");
				}
				// 시작과 끝이 다름
				else {
					int cal = arr[y2][x2] - arr[y1][x1 - 1];
					for (int y = y1; y <= y2; y++) {
						for (int x = 0; x < N; x++) {
							if (x < x1 || x > x2) cal -= board[y][x];
						}
					}
					sb.append(cal).append("\n");
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
