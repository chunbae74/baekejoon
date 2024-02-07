import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _15829 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = 1234567891;
		int L = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		long num = 0;
		for (int i = 0; i < L; i++) {
			int n = s.charAt(i) - 'a' + 1;
			long cal = 1;
			for (int j = 0; j < i; j++) {
				cal *= 31;
				cal %= M;
			}
			num = ((num % M) + ((n % M) * (cal % M))) % M;			
		}
		
		bw.write(num + "");
		bw.flush();
		bw.close();
	}

}
