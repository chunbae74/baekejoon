import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * m * n = 최대공약수 * 최대공배수
 * (a, b) = (b, r)
 */
public class _2609 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int gcd = gcd(Math.max(n1, n2), Math.min(n1, n2));
		int lcm = n1 * n2 / gcd;
		bw.write(gcd + "\n" + lcm);
		bw.flush();
		bw.close();
	}
	
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a%b);
	}
}
