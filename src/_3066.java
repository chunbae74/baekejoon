import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3066 {
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			dp = new Integer[N];
			
			int LIS = 0;
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(br.readLine());
				
				if (i == 0) {
					dp[LIS++] = num;
					continue;
				}
				
				if (dp[LIS - 1] < num) {
					dp[LIS++] = num;
				} else {
					int idx = binarySearch(num, 0, LIS);
					dp[idx] = num;
				}
			}
			
			sb.append(LIS).append("\n");
		}
		
		bw.write(sb.toString());
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
