import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2739 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int howMany = Integer.parseInt(br.readLine());
		for (int i = 1; i<10; i++) {
			bw.write(howMany + " * " + i + " = " + (howMany * i));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
