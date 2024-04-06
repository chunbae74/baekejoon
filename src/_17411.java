import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _17411 {
	static long[] arr;
	static Long[] dp;
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long mod = (long)Math.pow(10, 9) + 7;
		int N = Integer.parseInt(br.readLine());
		arr = new long[N];
		dp = new Long[N];
		count = new int[N + 1];
		
		int LIS = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long num = Integer.parseInt(st.nextToken());
			
			if (i == 0) {
				dp[LIS++] = num;
				count[LIS] = (int)((count[LIS] + 1) % mod);
				continue;
			}
			
			if (dp[LIS - 1] < num) {
				dp[LIS++] = num;
				count[LIS] = (int)((count[LIS] + 1) % mod);
			} else {
				int index = binarySearch(num, 0, LIS);
				dp[index] = num;
				count[LIS] = (int)((count[LIS] + 1) % mod);
			}
		}
		
		bw.write(LIS + " " + count[LIS]);
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int binarySearch(long num, int start, int end) {
		int res = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (dp[mid] < num) {
				start = mid + 1;
			} else {
				res = mid;
				end = mid - 1;
			}
		}
		
		return res;
	}

}
