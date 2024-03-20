import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

/*
 * 참고: https://lotuslee.tistory.com/43
 */
/*
 * 1 <= n <= 10
 */
public class _9095 {
	static Integer[] dp = new Integer[11];
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		// recur(10);
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());

			sb.append(dp[N]).append("\n");
		}
		
		bw.write(sb.toString() + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	public static int recur(int n) {
		if (dp[n] == null) {
			dp[n] = recur(n - 1) + recur(n - 2) + recur(n - 3);
		}
		
		return dp[n];
	}

}
