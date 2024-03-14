import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9461 {
	static long[] arr = new long[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		fibo();
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(arr[N]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void fibo() {
		arr[1] = arr[2] = arr[3] = 1;
		arr[4] = 2;
		
		for (int i = 5; i <= 100; i++) {
			arr[i] = arr[i - 1] + arr[i - 5];
		}
	}
	

}
