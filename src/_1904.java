import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 테케 : https://www.acmicpc.net/board/view/133784
 * 해설 : https://www.acmicpc.net/board/view/120526
 */
/*
 * Top-Downㅣ76876738
 * Bottom-Upㅣ76876497
 */
public class _1904 {
	static final int mod = 15746;
	static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
	
		dp = new Integer[N + 1];
		
		dp[1] = 1;
		if (N > 1) dp[2] = 2;
		recur(N);
		
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int recur(int N) {
		if (dp[N] == null) {
			dp[N] = (recur(N - 1) + recur(N - 2)) % mod;
		}
		
		return dp[N];
	}

}
