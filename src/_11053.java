import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11053 {
	static int[] arr;
	static Integer[][] dp;
	static int maxLen;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new Integer[N][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = new Integer[] { arr[0], 1 };
		maxLen = 1;
		
		fiboFor(N - 1);
		
		System.out.println(Arrays.deepToString(dp));
		bw.write(maxLen + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void fiboFor(int n) {
		for (int i = 1; i < n; i++) {
			if (arr[i] > dp[i - 1][0]) {
				int len = dp[i - 1][1] + 1;
				dp[i] = new Integer[] { arr[i], len };
				maxLen = Math.max(len, maxLen);
			}
			else {
				dp[i] = new Integer[] { arr[i], 1 };
			}
		}
	}

}
