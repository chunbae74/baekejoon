import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1978 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num, count = 0;
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if (isSosu(num)) count++;
		}
		bw.write(count + "");
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
