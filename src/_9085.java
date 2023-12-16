import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _9085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int N, num, sum;
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			sum = 0;
			for (int j = 0; j < N; j++) {
				num = Integer.parseInt(st.nextToken());
				sum += num;
			}
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
	}

}
