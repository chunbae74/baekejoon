/**
 * 첫째 줄 M, 둘째 줄 N
 * M <= N
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2581 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int min = N, sum = 0;
		for (int i = M; i <= N; i++) {
			if (isSosu(i)) {
				sum += i;
				if (min > i) min = i;
			}
		}
		if (sum == 0) bw.write("-1");
		else bw.write(sum + "\n" + min);
		bw.flush();
		bw.close();
	}
	
	public static boolean isSosu(int n) {
		boolean isSosu = true;
		if (n == 1) return false;
		for (int i = 2; i<n; i++) {
			if (n%i == 0) {
				isSosu = false;
				break;
			}
		}
		return isSosu;
	}

}
