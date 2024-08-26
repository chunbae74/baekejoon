import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 해설: https://st-lab.tistory.com/128
 * 24.03.20
 */
public class _1149 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		int N = Integer.parseInt(br.readLine());
		
		// 빨, 초, 파
		int[][] dp = new int[N][3];
		int[][] cost = new int[N][3];
		
		for (int n= 0; n < N; n++) {
			Arrays.fill(dp[n], INF);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i++) {
				cost[n][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		
		dp[0] = cost[0];
		for (int n = 1; n < N; n++) {
			dp[n][0] = cost[n][0] + Math.min(dp[n - 1][1], dp[n - 1][2]);
			dp[n][1] = cost[n][1] + Math.min(dp[n - 1][0], dp[n - 1][2]);
			dp[n][2] = cost[n][2] + Math.min(dp[n - 1][0], dp[n - 1][1]);
		}
		
		System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
		
		
	}
}
