import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11653 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int i = 2;
		do {
			if (N%i == 0) { // i가 N의 인수
				bw.write(i + "\n");
				N /= i;
			} else i++;
		} while (N != 1);
		bw.flush();
		bw.close();
	}

}
