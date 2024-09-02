import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4883 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String l;
		
		int t = 1;
		while (!(l = br.readLine()).equals("0")) {
			int N = Integer.parseInt(l);
			int[][] map = new int[N][3];
			Integer[][] dp = new Integer[N][3];

			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int i = 0; i < 3; i++) {
					map[n][i] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = map[0][1];
			dp[0][2] = dp[0][1] + map[0][2];
			dp[1][0] = dp[0][1] + map[1][0];
			dp[1][1] = Math.min(dp[1][0], Math.min(dp[0][1], dp[0][2])) + map[1][1];
			dp[1][2] = Math.min(dp[1][1], Math.min(dp[0][1], dp[0][2])) + map[1][2];
			for (int y = 2; y < N; y++) {
				dp[y][0] = Math.min(dp[y - 1][0], dp[y - 1][1]) + map[y][0];
				dp[y][1] = Math.min(dp[y][0], Math.min(dp[y - 1][0], Math.min(dp[y - 1][1], dp[y - 1][2]))) + map[y][1];
				dp[y][2] = Math.min(dp[y][1], Math.min(dp[y - 1][1], dp[y - 1][2])) + map[y][2];
			}

			sb.append(t).append(". ").append(dp[N - 1][1]).append("\n");
			t++;
		}
		
		System.out.println(sb.toString());
	}

}
