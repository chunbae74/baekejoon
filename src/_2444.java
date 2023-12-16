import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2444 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int order = Integer.parseInt(br.readLine());
		for (int i = 1; i<= order; i++) {
			for (int j = 1; j <= (order - i); j++) bw.write(" ");
			for (int j = 1; j <= (i * 2 - 1); j++) bw.write("*");
			bw.write("\n");
		}
		for (int i = (order-1); i > 0; i--) {
			for (int j = 1; j <= (order - i); j++) bw.write(" ");
			for (int j = 1; j <= (i * 2 - 1); j++) bw.write("*");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
