import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 참고: https://st-lab.tistory.com/134
 * 24.03.18 블로그 1회독 완료.
 */
/*
 * Top-Downㅣ76691791
 * Bottom-Upㅣ76691960
 * 테케모음: https://www.acmicpc.net/board/view/139133
 */
public class _10844 {
	static Integer[][] dp;
	static int mod = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
			
		dp = new Integer[N + 1][10];

		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int n = 2; n <= N; n++) {
			for (int i = 0; i < 10; i++) {
				if (i == 0) {
					dp[n][i] = dp[n - 1][1];
				} else if (i == 9) {
					dp[n][i] = dp[n - 1][8];
				} else {
					dp[n][i] = dp[n - 1][i - 1] + dp[n - 1][i + 1];
				}
				
				dp[n][i] %= mod;
			}
		}

		int sum = 0;
		for (int i = 1; i < 10; i++) {
			sum = (sum + dp[N][i]) % mod;
		}
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
