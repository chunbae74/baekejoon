import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _5543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n1 = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			n1 = Math.min(n1, Integer.parseInt(br.readLine()));
		}
		
		int n2 = Integer.MAX_VALUE;
		for (int i = 0; i < 2; i++) {
			n2 = Math.min(n2, Integer.parseInt(br.readLine()));
		}
		
		int sum = n1 + n2 - 50;
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
