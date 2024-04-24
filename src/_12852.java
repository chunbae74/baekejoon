import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _12852 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		boolean isDebug = false;
		int N = Integer.parseInt(br.readLine());
		Integer[] dp = new Integer[N + 1];
		int[] idxArr = new int[N + 1];
		
		dp[0] = dp[1] = 0;
		idxArr[1] = 0;
		
		if (N > 1) {
			dp[2] = 1;
			idxArr[2] = 1;
		}
		if (N > 2) {
			dp[3] = 1;
			idxArr[3] = 1;
		}
		
		for (int i = 4; i <= N; i++) {
			if ((i % 6) == 0) {
				int res = Math.min(dp[i / 2], Math.min(dp[i / 3], dp[i - 1]));
				dp[i] = res + 1;
				if (res == dp[i / 2]) {
					idxArr[i] = i / 2;
				} else if (res == dp[i / 3]) {
					idxArr[i] = i / 3;
				} else if (res == dp[i - 1]) {
					idxArr[i] = i - 1;
				}
			}
			else if ((i % 3) == 0) {
				int res = Math.min(dp[i / 3], dp[i - 1]);
				dp[i] = res + 1;
				if (res == dp[i / 3]) {
					idxArr[i] = i / 3;
				} else {
					idxArr[i] = i - 1;
				}
			}
			else if ((i % 2) == 0) {
				int res = Math.min(dp[i / 2], dp[i - 1]);
				dp[i] = res + 1;
				if (res == dp[i / 2]) {
					idxArr[i] = i / 2;
				} else {
					idxArr[i] = i - 1;
				}
			}
			else {
				dp[i] = dp[i - 1] + 1;
				idxArr[i] = i - 1;
			}
		}
		
		if (isDebug) {
			System.out.println(Arrays.toString(dp));
			System.out.println(Arrays.toString(idxArr));
		}
		
		sb.append(dp[N]).append("\n");
		
		sb.append(N).append(" ");
		int targetIdx = idxArr[N];
		while (targetIdx > 0) {
			sb.append(targetIdx).append(" ");
			targetIdx = idxArr[targetIdx];
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
