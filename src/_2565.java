import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2565 {
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[501];
		dp = new Integer[501];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A] = B;
		}
		
		int LIS = 0;
		for (int i = 1; i < 501; i++) {
			if (arr[i] == 0) continue;
			int num = arr[i];
			
			// 맨 첫번째 값
			if (dp[0] == null) {
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
		
		bw.write((N - LIS) + "");
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
