import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _11005 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int result;
		for (; N%B != N; N /= B) {
			result = (N%B);
			if (result > 9) sb.append((char)(result - 10 + 'A'));
			else sb.append(result + "");
		}
		if (N > 9) sb.append((char)(N - 10 + 'A'));
		else sb.append(N + "");
		System.out.println(sb.reverse().toString());
	}

}
