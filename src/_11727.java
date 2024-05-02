import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _11727 {
	static Long[] dp;
	static int a = 10_007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		dp = new Long[n + 1];
		
		dp[0] = 0L;
		dp[1] = 1L;
		if (n > 1) {
			dp[2] = 3L;
		}
		
		recur(n);
		
		System.out.println(Arrays.toString(dp));
		
		bw.write(dp[n] % a + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static long recur(int n) {
		if (dp[n] == null) {
			// dp[n] = Math.max();
		}
		
		return dp[n];
	}
}
