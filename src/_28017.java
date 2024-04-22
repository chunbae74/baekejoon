import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _28017 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Integer[][] dp = new Integer[N][M];
		boolean isDebug = false;
		
		// 첫 번째 회차는 그대로.
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			dp[0][i] = Integer.parseInt(st.nextToken());
		}
		
		// 두 번째 회차부터는 계산 고고
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				for (int k = 0; k < M; k++) {
					// 이전 회차의 무기는 사용하지 않기
					if (k == j) continue;
					
					if (dp[i][j] == null) 
						dp[i][j] = dp[i - 1][k] + num;
					else 
						dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + num);
					
				}
			}
		}
		
		if (isDebug) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(dp[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		// 최소값 찾기
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			min = Math.min(min, dp[N - 1][i]);
		}
		
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
