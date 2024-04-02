import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2352 {
	static int[] arr;
	static Integer[] dp;

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
		
		int LIS = 0;
		for (int idx = 0; idx < n; idx++) {
			int nowNum = arr[idx];
			int index = binarySearch(nowNum, 0, LIS);
		
			if (index == -1) {
				dp[LIS++] = nowNum;
			} else {
				dp[index] = nowNum;
			}
		}
		
		bw.write(LIS + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int binarySearch(int num, int start, int end) {
		int res = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (dp[mid] == null) {
				return - 1;
			}
			
			if (num <= dp[mid]) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		return res;
	}

}
