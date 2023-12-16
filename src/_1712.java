import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// A + B * count <= C * count
// A < (C - B) * count
// A / (C - B) < count
public class _1712 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		if (B == C) bw.write("-1");
		else {
			long count = (long)Math.ceil(A / (C - B)) + 1;
			if (count < 0) bw.write("-1");
			else bw.write(count + "");
		}
		bw.flush();
		bw.close();
	}

}
