import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int mod = Integer.parseInt(st.nextToken());
		
		A %= mod;
		long sum = A;
		for (int i = 1 ;i < B; i++) {
			sum = ((sum % mod) * (A % mod)) % mod;
		}
		
		System.out.println(sum);
	}

}
