import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 이항계수 = N개의 물건 중 K개를 순서 없이 고르는 경우의 수와 같음
 *
 */
public class _11050 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		bw.write(comb(N, M) + "");
		bw.flush();
		bw.close();
	}

	// nCr = nPr / r!
	public static long comb(int n, int r) {
		if (n - r >= 0) r = Math.min(r, n-r);
		long numerator = 1;
		long denominator = 1;
		for(int i = 0; i < r; i ++) {
			numerator *= n-i;
		}
		for(int i = 2 ; i <= r; i++) {
			denominator *= i;
		}
		
		return numerator / denominator;
	}
}
