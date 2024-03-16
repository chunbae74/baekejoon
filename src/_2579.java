import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 참고: https://st-lab.tistory.com/132
 */
public class _2579 {
	static int[] stairs;
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		stairs = new int[N + 1];
		dp = new Integer[N + 1];
		
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = stairs[0];
		dp[1] = stairs[1];
		
		if (N >= 2) {
			dp[2] = stairs[1] + stairs[2];
		}
		
		fibo(N);
		
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		br.close();
	}

	
	public static int fibo(int N) {
		if (dp[N] == null) {
			dp[N] = Math.max(fibo(N - 2), fibo(N - 3) + stairs[N - 1]) + stairs[N];
		}
		
		return dp[N];
	}
}
