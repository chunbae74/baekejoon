import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _13241 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long gcd = gcd(A, B);
		bw.write((A*B)/gcd + "");
		bw.flush();
		bw.close();
	}
	
	/*
	 * (a, b) = (b, r) ... (b, 0)
	 */
	public static long gcd(long a, long b) {
		if (b == 0) return a;
		else return gcd(b, a%b);
	}
}
