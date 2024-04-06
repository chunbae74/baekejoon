import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1818 {
	static Integer[] dp;
	static int[] index;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N];
		index = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int LIS = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (i == 0) {
				dp[LIS++] = num;
				index[i] = LIS;
				continue;
			}
			
			if (dp[LIS - 1] < num) {
				dp[LIS++] = num;
				index[i] = LIS;
			} else {
				int idx = binarySearch(num, 0, LIS);
				dp[idx] = num;
				index[i] = idx + 1;
			}
		}
		
		int result = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (index[i] == LIS) {
				LIS --;
			} else {
				result ++;
			}
		}
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
	public static int binarySearch(int num, int start, int end) {
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
