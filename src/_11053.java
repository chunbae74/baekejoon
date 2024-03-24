import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 반례모음: https://www.acmicpc.net/board/view/114371
 */
/*
 * 75580088ㅣTop-Down
 * 75580353ㅣBottom-Up
 */
public class _11053 {
	static int[] arr;
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N + 1];
		// N번째 자리에 도달하는 최대 경우의 수 저장
		dp = new Integer[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = 1;
		
		int max = 1;
		for (int n = 2; n <= N; n++) {
			dp[n] = 1;
			for (int i = 1; i < n; i++) {
				if (arr[i] < arr[n]) {
					dp[n] = Math.max(dp[n], dp[i] + 1);
				}
			}
			max = Math.max(max, dp[n]);
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
