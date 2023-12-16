import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _24389 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int bosu = ~N + 1;
		int n = N ^ bosu;
		int mask = 1;
		int count = 0;
		while(mask != 0) {
			if ((mask & n) != 0) count ++;
			mask = mask << 1;
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
