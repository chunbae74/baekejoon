import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 참고 : https://st-lab.tistory.com/133
 */
public class _1463 {
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N + 1];
		dp[0] = dp[1] = 0;
		
		int count = recur(N);
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

	
	public static int recur(int N) {
		if (dp[N] == null) {
			if (N % 6 == 0) {
				dp[N] = Math.min(recur(N / 3), Math.min(recur(N / 2), recur(N - 1))) + 1;
			}
			else if (N % 3 == 0) {
				dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
			}
			else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
			}
			else {
				dp[N] = recur(N - 1) + 1;
			}
		} 
		
		return dp[N];
			
	}
}
