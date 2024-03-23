import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 그냥 퇴사 안하면 안되냐 백준아;;;;
 * 해설: https://velog.io/@yoonuk/%EB%B0%B1%EC%A4%80-14501-%ED%87%B4%EC%82%AC-Java%EC%9E%90%EB%B0%94
 * 24.03.23 해설 확인
 */
public class _14501 {
	// 상담시간, 금액
	static Integer[] dp;
	static int[][] arr;
	
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		System.out.println(23456789 % 20000303);
		N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1];
		arr = new int[N + 1][2];
		
		int max = 1;
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			if (i + (arr[i][0] - 1) <= N) {
				max = Math.max(max, i);
			}
		}
		
		System.out.println(Arrays.toString(dp));
		bw.write(dp[max] + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int recur(int n) {
		if (dp[n] == null) {
			int T = arr[n][0];
			int C = arr[n][1];
			
			// 회의 종료시간이 퇴사일 이후라면
			if ((n + T - 1) > N) {
				return 0; 
			}
			else {
				for (int idx = n - 1; idx > 0; idx--) {
					int time = arr[idx][0];
					if (idx + (time - 1) <= n) {
						dp[n] = recur(idx) + C;
					}
				}
			}
		}
		
		return dp[n];
	}

}
