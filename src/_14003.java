import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _14003 {
	static int[] arr;
	static Integer[] dp;
	static int[] index;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new Integer[N];
		index = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int LIS = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (i == 0) {
				dp[i] = arr[i];
				index[i] = 1;
				LIS ++;
			}
			else {
				if (dp[LIS - 1] < arr[i]) {
					dp[LIS++] = arr[i];
					index[i] = LIS;
				} else {
					int idx = binarySearch(arr[i], 0, LIS);
					dp[idx] = arr[i];
					index[i] = idx + 1;
				}
			}
		}
		
		sb.append(LIS).append("\n");
		
		Stack<Integer> stack = new Stack<>();
		for (int i = N - 1; i >= 0; i--) {
			if (index[i] == LIS) {
				stack.add(arr[i]);
				LIS --;
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
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
