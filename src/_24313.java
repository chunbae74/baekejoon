/**
 * a1, a0 (0 <= ㅣaiㅣ <= 100)
 * c (1 <= c <= 100)
 * n0 (1 <= n0 <= 100)
 * a1 * n + a0 <= c * n (n >= n0)
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _24313 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a1 = Integer.parseInt(st.nextToken());
		int a0 = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(br.readLine());
		int n0 = Integer.parseInt(br.readLine());
		int f = a1 * n0 + a0;
		int cg = c * n0;
		/**
		 * 반례 :
		 * f(n) = 5n - 2, g(n) = n, c = 3;
		 * 5n - 2 <= 3n
		 * => 2n <= 2
		 * n0 = 1일 땐 성립
		 * but n0 = 2일땐 만족 x
		 * => a1이 c 이하여야 거를 수 있음.
		 */
		bw.write((f <= cg && a1 <= c) ? "1" : "0");
		bw.flush();
		bw.close();
	}

}
