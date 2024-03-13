import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1003 {
	static Integer[] zero;
	static Integer[] one;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			zero = new Integer[N + 2];
			one = new Integer[N + 2];

			fibZero(N);
			fibOne(N);

			sb.append(zero[N]).append(" ").append(one[N]);
			sb.append("\n");
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	public static int fibZero(int N) {
		zero[0] = 1;
		zero[1] = 0;
		
		if (zero[N] == null) {
			zero[N] = fibZero(N - 1) + fibZero(N - 2);
		}
		
		return zero[N];
	}
	
	public static int fibOne(int N) {
		one[0] = 0;
		one[1] = 1;

		if (one[N] == null) {
			one[N] = fibOne(N - 1) + fibOne(N - 2);
		}
		
		return one[N];
	}

}
