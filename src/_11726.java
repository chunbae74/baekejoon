import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// dp[n] = dp[n - 1] + dp[n - 2]
public class _11726 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10_007;
		}
		
		bw.write(dp[n]+ "");
		bw.flush();
		bw.close();
	}
	
	public static long fact(int n) {
		if (n <= 1) return 1;
		else {
			long fact = 1;
			for (int i = 2; i <= n; i ++) {
				fact *= i;
			}
			return fact;
		}
	}
}
