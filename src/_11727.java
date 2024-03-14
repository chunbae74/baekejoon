import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11727 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int result = 0;
		if (n < 3) result = n;
		else result = fibo(n);
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int fibo(int n) {
		long a = 1;
		long b = 2;
		long sum = 0;
		for (int i = 3; i <= n; i++) {
			sum = a + b;
			a = b;
			b = sum;	
		}
		
		return (int) (sum % 10_007);
	}

}
