import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1788 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int max = 1_000_000;
		final int mod = 1_000_000_000;
		
		int N = Integer.parseInt(br.readLine());
		br.close();
		Long[] dp = new Long[max + 1];
		dp[0] = 0L;
		dp[1] = 1L;
		for (int i = 2; i <= max; i++) {
			dp[i] = ((dp[i - 1] % mod) + (dp[i - 2] % mod)) % mod;
			
		}
		
		if (N == 0) {
			System.out.println(0);
		} else if (N > 0) {
			System.out.println(1);
		} else {
			N = N * -1;
			if (N % 2 == 0) {
				System.out.println(-1);
			}
			else {
				System.out.println(1);
			}
		}
		
		System.out.println(dp[N]);
	}

}
