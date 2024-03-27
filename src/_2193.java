import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 왜 피보나치로 풀리는지에 대한 해설: https://www.acmicpc.net/board/view/130246
 */
public class _2193 {
	static Long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		dp = new Long[N + 1];
		
		dp[0] = 0L;
		dp[1] = 1L;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
