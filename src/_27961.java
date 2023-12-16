import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _27961 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long N = Long.parseLong(br.readLine());
		if (N <= 2) bw.write(N + "");
		else {
			int count = 2;
			long catNum = 2;
			for (; catNum * 2 <= N; count++, catNum *= 2);
			if (catNum < N) count ++;
			bw.write(count + "");
		}
		bw.flush();
		bw.close();
	}

}
