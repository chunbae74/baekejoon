import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11721 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] c = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			if ('a' <= c[i] && c[i] <= 'z') sb.append(c[i]);
			else sb.append(c[i]);
			if (i % 10 == 9) sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	

}
