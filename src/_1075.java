import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1075 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		int i = F;
		while (true) {
			i += F;

			if (N / 100 <= i / 100) {
				break;
			}
		}
		
		i %= 100;
		String s = Integer.toString(i);
		if (s.length() < 2) s = "0".concat(s);
		
		bw.write(s);
		bw.flush();
		bw.close();
		br.close();
	}

}
