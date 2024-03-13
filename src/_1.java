import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1 {
	static long count0, count1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
//		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < 10; i++) {
//			int N = Integer.parseInt(br.readLine());
			count0 = count1 = 0;

			fibonacci(i);
			
			sb.append(count0).append(" ").append(count1);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int fibonacci(int N) {
		if (N == 0) {
			count0 ++;
			return 0;
		}
		else if (N == 1) {
			count1 ++;
			return 1;
		}
		else {
			return fibonacci(N - 1) + fibonacci(N - 2);
		}
	}

}
