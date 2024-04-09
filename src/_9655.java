import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * dp[N] = 홀수 : 상근
 * dp[N] = 짝수 : 창영
 */
/*
 * Top-Downㅣ76674304
 * Bottom-Upㅣ76674629
 */
public class _9655 {
	static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1];
		
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			if (i < 4) {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
			}
		}
		
		bw.write((dp[N] % 2 == 0) ? "CY" : "SK");
		bw.flush();
		bw.close();
		br.close();
	}
}
