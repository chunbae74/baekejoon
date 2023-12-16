import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _25501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			char[] c = br.readLine().toCharArray();
			int count = 0;
			int l = 0;
			int r = c.length - 1;
			boolean isPalidrome = true;
			while (true) {
				count ++;
				if (l >= r) break;
				else if (c[l] != c[r]) {
					isPalidrome = false;
					break;
				}
				else {
					l ++;
					r --;
				}
			}
			sb.append(isPalidrome?1:0).append(" ");
			sb.append(count);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
