import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _4134 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long n = Long.parseLong(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			long num = Long.parseLong(br.readLine());
			for(long j = num; ; j++) {
				if (isSosu(j)) {
					sb.append(j).append("\n");
					break;
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static boolean isSosu(long n) {
		if (n < 2) return false;
		boolean isSosu = true;
		for(long i = 2; i*i <= n; i++) {
			if (n % i == 0) {
				isSosu = false;
				break;
			}
		}
		return isSosu;
	}

}
