import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 83064861ㅣButtom-up
 * 83065430ㅣTop-down
 */
public class _15988 {
	static final int mod = 1_000_000_009;
	static final int max = 1_000_000;
	static Long[] dp = new Long[max + 1];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		dp[1] = 1L;
		dp[2] = 2L;
		dp[3] = 4L;
		
		// Top-down
		recur(max);
		
		/*
		 * Buttom-up
		for (int i = 4; i <= max; i++) {
			dp[i] = ((dp[i - 1] % mod) + (dp[i - 2] % mod) + (dp[i - 3] % mod)) % mod;
		}
		*/
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static long recur(int n) {
		if (dp[n] == null) {
			dp[n] = (recur(n - 1) + recur(n - 2) + recur(n - 3)) % mod;
		}
		
		return dp[n];
	}
}
