import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _17419 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (input.charAt(i) == '1') count++;
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
	
}
