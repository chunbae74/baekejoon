import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10990 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < N - i; j++) {
				bw.write(" ");
			}
			bw.write("*");
			for (int k = 0; k < 2 * (i - 1) - 1; k ++) {
				bw.write(" ");
			}
			if (i != 1) bw.write("*");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
