import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[2][N];
			int[][] dp = new int[2][N];
			
			for (int y = 0; y < 2; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][0] = map[0][0];
			dp[1][0] = map[1][0];
			
			for (int x = 1; x < N; x++) {
				for (int y = 0; y < 2; y++) {
					int preY = (y == 0 ? 1 : 0);
					dp[y][x] = Math.max(dp[preY][x - 1] + map[y][x], dp[y][x - 1]);
				}
			}
			
			sb.append(Math.max(dp[0][N - 1], dp[1][N - 1]));
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
