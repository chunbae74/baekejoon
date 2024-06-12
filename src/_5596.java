import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5596 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum1 = 0;
		for (int i = 0; i < 4; i++) {
			sum1 += Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int sum2 = 0;
		for (int i = 0; i < 4; i++) {
			sum2 += Integer.parseInt(st.nextToken());
		}
		
		bw.write(Math.max(sum1, sum2) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
