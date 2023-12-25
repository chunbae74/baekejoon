import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1463 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		while (true) {
			if (N == 1) break;
			if (N % 3 == 0) N /= 3;
			else if (N % 2 == 0) N /= 2;
			else N--;
			
			count++;
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
