import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2441 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for (int i = n; i>0; i--) {
			for (int k = 1; k <= n-i; k++) bw.write(" ");
			for (int j = 1; j <= i; j++) bw.write("*");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
