import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1010 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append(comb(m, n)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	// nCm = nCn-m = nPm / m!
	public static long comb(int n, int m) {
		if (n-m >= 0) m = Math.min(m, n-m);
		long numerator = 1;
		for(int i = 0; i < m ; i++) {
			numerator *= n-i;
		}
		long denominator = 1;
		for(int i = 2; i <= m; i++) {
			denominator *= i;
		}
		return numerator / denominator;
	}

}
