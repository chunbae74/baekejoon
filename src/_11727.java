import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11727 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int mod = 10_007;

		int n = Integer.parseInt(br.readLine());
		br.close();
		
		int[] dp = new int[n + 1];
		
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				dp[i] = ((dp[i - 1] << 1 % mod) + 1) % mod;
			} else {
				dp[i] = ((dp[i - 1] << 1 % mod) - 1) % mod;
			}
		}
		
		System.out.println(dp[n]);
	}
	
}
