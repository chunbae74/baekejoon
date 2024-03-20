import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1932 {
	static Integer[][] dp;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][];
		dp = new Integer[N + 1][];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = new int[i + 1];
			dp[i] = new Integer[i + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][0] = 0;
		dp[1][1] = arr[1][1];
		for (int i = 1; i <= N; i++) {
			recur(N, i);
		}
		
		int max = dp[N][1];
		for (int i = 2; i <= N; i++) {
			max = Math.max(max, dp[N][i]);
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int recur(int N, int idx) {
		if (dp[N][idx] == null) {
			// 부모가 한 개밖에 없음
			if (idx == 1) {
				dp[N][idx] = recur(N - 1, idx) + arr[N][idx];
			}
			else if (idx == N) {
				dp[N][idx] = recur(N - 1, idx - 1) + arr[N][idx];
			}
			// 부모가 두 개 존재
			else {
				dp[N][idx] = Math.max(recur(N - 1, idx - 1), recur(N - 1, idx)) + arr[N][idx];
			}
		}
			
		return dp[N][idx];
	}
}
