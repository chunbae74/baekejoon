import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _14681 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		if (x > 0) { // 1, 4사분면
			if (y > 0) bw.write("1");
			else bw.write("4");
		} else { // 2, 3사분면
			if (y > 0) bw.write("2");
			else bw.write("3");
		}
		bw.flush();
		bw.close();
	}

}
