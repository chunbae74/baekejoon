import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * 반례모음: https://www.acmicpc.net/board/view/139143
 * 해설: https://st-lab.tistory.com/135
 */
public class _2156 {
	static Integer[] dp;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		dp = new Integer[n + 1];
		arr = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = arr[0];
		dp[1] = arr[1];
		if (n > 1) {
			dp[2] = arr[1] + arr[2];
		}
		
		// recur(n);
		
		for (int idx = 3; idx <= n; idx++) {
			dp[idx] = Math.max(dp[idx - 2], dp[idx - 3] + arr[idx - 1]) + arr[idx];
			// n번째 잔을 반드시 마셔야 하는 상황 vs n-1번쨰 잔을 반드시 마셔야 하는 상황
			dp[idx] = Math.max(dp[idx], dp[idx - 1]);
		}
		
		bw.write(dp[n] + "");
		bw.flush();
		bw.close();
		br.close();
		
	}

	public static int recur(int n) {
		if (dp[n] == null) {
			dp[n] = Math.max(recur(n - 2), recur(n - 3) + arr[n - 1]) + arr[n];
			// n번째 잔을 반드시 마셔야 하는 상황 vs n-1번쨰 잔을 반드시 마셔야 하는 상황
			dp[n] = Math.max(dp[n], recur(n - 1));
		}
		
		return dp[n];
	}
}
