import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _16395 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Integer[][] dp = new Integer[N][];
		
		dp[0] = new Integer[] { 1 };
		if (N > 1) dp[1] = new Integer[] { 1, 1 };
		for (int i = 2; i < N; i++) {
			dp[i] = new Integer[i + 1];
			for (int j = 0; j < (i + 1); j++) {
				if (j == 0 || j == i) dp[i][j] = 1;
				else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		
		bw.write(dp[N - 1][K - 1] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
