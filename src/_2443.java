import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2443 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for (int i = N; i > 0; i--) {
			for (int k = 0; k < N - i; k++) bw.write(" ");
			for (int j = 0; j < i * 2 - 1; j++) bw.write("*");
			bw.write("\n");
		}
		bw.close();
	}

}
