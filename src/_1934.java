import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 수학적으로 두 수 m, n이 있을 때
 * m * n = 최대공약수 * 최소공배수 가 성립한다.
 *  
 * 유클리드 호제법
 * (a, b) = (b,r) .
 * (1071, 1029) = (1029, 42) = (42, 21), (21, 0) = 21.
 *
 * gcd: Greatest Common Divisor, 최대공약수
 */
public class _1934 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int gcd = gcd(Math.max(n1, n2), Math.min(n1, n2)); 
			bw.write((n1 * n2) / gcd + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a%b);
	}
}
