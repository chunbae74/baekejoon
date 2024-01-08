import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _1003 {
	static int count0, count1;
	static Integer[] dp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			count0 = count1 = 0;
			int n = Integer.parseInt(br.readLine());
			dp = new Integer[Math.max(n + 1, 2)];
			dp[0] = 0;
			dp[1] = 1;
			
			recur(n);
			sb.append(count0).append(" ").append(count1);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
	public static int recur(int N) {
		if (dp[N] == null) {
			dp[N] = recur(N - 1) + recur(N - 2);
		}
		else {
			if (N == 0) count0 ++;
			else if (N == 1) count1 ++;
		}
		
		return dp[N];
	}

}
