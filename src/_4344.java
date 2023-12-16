import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _4344 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int C = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int N;
		for (int i = 0; i<C; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			double sum = 0.0;
			int[] scoreArr = new int[N];
			for (int j = 0; j<N; j++) {
				int score = Integer.parseInt(st.nextToken());
				scoreArr[j] = score;
				sum += score;
			}
			sum /= N;
			int count = 0;
			for (int score: scoreArr) {
				if (score > sum) count ++;
			}
			bw.write(String.format("%.3f", count/(double)N * 100) + "%\n");
		}
		bw.flush();
		bw.close();
	}

}
