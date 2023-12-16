import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _27433 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		bw.write(fact(N) + "");
		bw.flush();
		bw.close();
	}
	
	public static long fact(int N) {
		if (N <= 1) return 1;
		else return N * fact(N - 1);
	}
}
