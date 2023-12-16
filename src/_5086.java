import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n1, n2;
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			if (n1 == 0 && n2 == 0) break;
			if (n1 > n2) {
				if (n1%n2 == 0) bw.write("multiple");
				else bw.write("neither");
			} else if (n1 < n2) {
				if (n2%n1 == 0) bw.write("factor");
				else bw.write("neither");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
