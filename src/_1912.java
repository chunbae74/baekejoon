import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 탐색 과정에서 max변수를 두고 최댓값을 갱신해 주면
 * 탐색 과정에서 한 번에 처리할 수 있으니
 * fibo함수 종료 후 배열 정렬하는 것 보다 효율적임.
 * 
 * 참고: https://st-lab.tistory.com/140
 */
public class _1912 {
	static int[] arr;
	static Integer[] dp;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		max = arr[0];
		
		fiboFor(n);
		// fibo(n - 1);
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int fibo(int n) {
		if (dp[n] == null) {
			dp[n] = Math.max(fibo(n - 1), 0) + arr[n];
			max = Math.max(max, dp[n]);
		}
		return dp[n];
	}
	
	public static void fiboFor(int n) {
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], 0) + arr[i];
			max = Math.max(max, dp[i]);
		}
	}
}
