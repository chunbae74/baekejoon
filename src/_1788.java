import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1788 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int A = 1_000_000;
		int N = Integer.parseInt(br.readLine()) + A;
		Integer[] dp = new Integer[A << 1 + 1];
		dp[A] = 0;
		dp[A + 1] = 1;
		
		if (N >= A) {
			for (int i = A + 2; i <= N; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		} else {
			for (int i = A + 1; i - 2 >= N; i--) {
				dp[i - 2] = dp[i] - dp[i - 1];
			}
		}
		
		int ans = dp[N];
		if (ans > 0) {
			System.out.println(1);
		} else if (ans == 0) {
			System.out.println(0);
		} else {
			System.out.println(-1);
		}
		
		System.out.println(Math.abs(dp[N]) % 1_000_000_000);
	}

}
