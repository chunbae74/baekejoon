import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int n = 0; n < N; n++) {
			long num = Integer.parseInt(br.readLine());
			boolean isSosu = true;
			for (long i = 1; i * i <= num; i++) {
				if (num % i == 0) {
					isSosu = false;
					break;
				}
			}
			
			sb.append(isSosu ? "YES" : "NO").append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
