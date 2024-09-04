import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2876 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][6];
		int[][] dp = new int[N][6];
		
		int max = 1;
		int grade = 5;
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			if (n == 0) {
				grade = Math.min(grade, Math.min(n1, n2));
			}
			
			map[n][n1] = map[n][n2] = dp[n][n1] = dp[n][n2] = 1;
		}
		
		for (int n = 1; n < N; n++) {
			for (int i = 0; i <= 5; i++) {
				if (map[n][i] == 0) continue;
				
				if (map[n - 1][i] > 0) {
					dp[n][i] = dp[n - 1][i] + 1;
					
					if (dp[n][i] > max) {
						max = dp[n][i];
						grade = i;
					} else if (dp[n][i] == max) {
						grade = Math.min(grade, i);
					}
				}
			}
		}
		
		System.out.println(max + " " + grade);
	}

}
