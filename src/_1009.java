import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int num = 1;
			for (int j = 0; j < b; j++) {
				num = (num * a) % 10;
			}
			if (num == 0) num = 10;
			sb.append(num).append("\n");				
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
