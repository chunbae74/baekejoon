import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5344 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n1, n2;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			sb.append(gcd(Math.max(n1, n2), Math.min(n1, n2))).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	// (a, b) = (b, c) ... (r, 0)
	public static int gcd(int n1, int n2) {
		if (n2 == 0) return n1;
		else return gcd(n2, n1 % n2);
	}
}
