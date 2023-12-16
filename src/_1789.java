import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1789 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long sum = 0;
		int count = 0;
		long N = Long.parseLong(br.readLine());
		for (int i = 1; ; i++) {
			if (sum + i == N) {
				count ++;
				break;
			}
			else if (sum + i > N) break;
			else {
				sum += i;
				count ++;
			}
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
