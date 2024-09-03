import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19947 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		br.close();

		double[] dp = new double[Y + 1];
		dp[0] = H;
		for (int i = 0; i < Y; i++) {
			dp[i + 1] = (int)Math.max(dp[i + 1], dp[i] * 1.05);
			
			if (i + 3 <= Y) {
				dp[i + 3] = (int)Math.max(dp[i] * 1.2, dp[i + 3]);
			}
			if (i + 5 <= Y) {
				dp[i + 5] = (int)Math.max(dp[i] * 1.35, dp[i + 5]);
			}
		}
		
		System.out.println((int)dp[Y]);
	}

}
