/**
 * N B; N : B진법 수
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2745 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String N = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		long num = 0;
		for (int i = 0; i < N.length(); i++) {
			char c = N.charAt(i);
			if ('A' <= c && c <= 'Z') num += ((c-'A')+10) * Math.pow(B, N.length() - 1 - i);
			else num += (c-'0') * Math.pow(B, N.length() - 1 - i);
		}
		bw.write(num + "");
		bw.flush();
		bw.close();
	}

}
