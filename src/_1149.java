import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 해설: https://st-lab.tistory.com/128
 * 24.03.20
 */
public class _1149 {
	static Integer[][] dp;
	static int[][] cost;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		cost = new int[N + 1][3];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}
		
		for (int i = 0; i < 3; i++) {
			dp = new Integer[N + 1][2];
			dp[0] = new Integer[] { cost[0][i], i };
			recur(N);			
		}
		
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	public static int recur(int N) {
		if (dp[N] == null) {
			int[] arr = new int[2];
			for (int i = 0; i < 3; i++) {
				int preCost = recur(N - 1);
				if (preCost == cost[N - 1][i]) continue;
				
			}
		}
	}

}
