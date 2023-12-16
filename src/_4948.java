import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _4948 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] isNotSosu = new boolean[123_456*2+1];
		isNotSosu[0] = isNotSosu[1] = true;
		for (int i = 2; i<isNotSosu.length; i++) {
			if (!isNotSosu[i]) {
				for (int j = i*2; j < isNotSosu.length; j+=i) isNotSosu[j] = true;
			}
		}
		int n, count;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			count = 0;
			for (int i = n+1; i<=2*n; i++) {
				if (!isNotSosu[i]) count++;
			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
	}

}
