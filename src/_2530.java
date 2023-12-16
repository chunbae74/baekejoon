import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2530 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(br.readLine());
		m += D/60;
		s += D%60;
		if (s >= 60) {
			m+= s/60;
			s = s%60;
		}
		if (m >= 60) {
			h+= m/60;
			m = m%60;
		}
		if (h >= 24) {
			h = h%24;
		}
		bw.write(h + " " + m + " " + s);
		bw.flush();
		bw.close();
	}

}
