import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2568 {
	static int[] arr;
	static Integer[] dp;
	static int[] index;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int N = 500_000 + 1;
		arr = new int[N];
		dp = new Integer[N];
		index = new int[N];
		
		int M = Integer.parseInt(br.readLine());
		
		// arr 초기화
		for (int i = 1; i < N; i++) {
			arr[i] = -1;
			index[i] = -1;
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A] = B;
			
			if (min > A) {
				dp[1] = B;
				index[1] = 1;
				min = A;
			}
		}
		
		int LIS = 1;
		for (int i = 1; i < N; i++) {
			int nowNum = arr[i];
			if (nowNum == -1) continue;
			
			if (dp[LIS] < nowNum) {
				dp[++LIS] = nowNum;
				index[i] = LIS;
			} else {
				int idx = binarySearch(nowNum, 1, LIS);
				dp[idx] = nowNum;
				index[i] = idx;
			}
		}
		
		sb.append(M - LIS).append("\n");
		
		for (int i = N - 1; i > 0; i--) {
			if (arr[i] == -1) continue;

			if (LIS == index[i]) {
				LIS --;
			} else {
				stack.add(i);
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append("\n");
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
