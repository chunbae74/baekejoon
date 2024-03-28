import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 75892866ㅣTop-Down
 * 75893298ㅣBottom-Up
 * 테스트케이스 모음: https://joey09.tistory.com/108
 */
public class _11055 {
	static int[] arr;
	static Integer[] dp;
	
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new Integer[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		max = arr[1];
		
		for (int i = 2; i <= N; i++) {
			dp[i] = arr[i];
			for (int j = 1; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
