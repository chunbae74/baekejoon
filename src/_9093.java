import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _9093 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreElements()) {
				sb.setLength(0);
				sb.append(st.nextToken());
				result.append(sb.reverse().toString()).append(" ");				
			}
			result.append("\n");
		}
		bw.write(result.toString());
		bw.flush();
		bw.close();
	}

}
