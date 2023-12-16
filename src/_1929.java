import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] isNotSosu = new boolean[N + 1];
		isNotSosu[0] = isNotSosu[1] = true;
		for (int i = 2; i<isNotSosu.length; i++) {
			if (!isNotSosu[i]) {
				for (int j = i*2; j<isNotSosu.length; j+=i) {
					isNotSosu[j] = true;
				}
			}
		}
		for (int i = M; i<=N; i++) {
			if (!isNotSosu[i]) bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
	}
}
