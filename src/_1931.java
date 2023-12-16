import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int count = 0; // 회의 수
		int preEndT = 0;
		int startT, endT;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			startT = Integer.parseInt(st.nextToken());
			endT = Integer.parseInt(st.nextToken());
			if (preEndT <= startT) {
				count ++;
				preEndT = endT;
			}
			else continue;
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
