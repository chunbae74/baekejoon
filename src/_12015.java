import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * LIS 알고리즘 설명: https://sskl660.tistory.com/89
 */
public class _12015 {
	static long[] arr;
	static Long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new long[N];
		dp = new Long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		int LIS = 0;
		for (int i = 0; i < N; i++) {
			long nowNum = arr[i];
			int index = binarySearch(nowNum, 0, LIS, LIS + 1);
			
			if (index == -1) {
				dp[LIS++] = nowNum;
			}
			else {
				dp[index] = nowNum;
			}
		}
		
		bw.write(LIS + "");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static int binarySearch(long num, int start, int end, int size) {
		int res = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (dp[mid] == null) {
				return -1;
			}
			// 만약 현재 숫자가 dp[mid]숫자보다 작다면
			if (num <= dp[mid]) {
				// 해당 위치의 원소를 기억해둔다
				res = mid;
				end = mid - 1;
			// 만약 현재 숫자가 dp[mid]숫자보다 크다면
			} else if (num > dp[mid]) {
				start = mid + 1;
			}
		}
		
		// dp테이블에서 삽입될 위치를 찾지 못한 경우(즉, 모든 수들보다 큰 경우)
		if (start == size) {
			return -1;
		}
		else {
			return res;
		}
	}

}
