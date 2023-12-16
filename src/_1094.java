import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1094 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int X = Integer.parseInt(br.readLine());
		int mask = 1 << 6;
		int count = 0;
		do {
			if ((mask & X) != 0) count ++;
			mask = mask >>> 1;
		} while(mask != 0);
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
