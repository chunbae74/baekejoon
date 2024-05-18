import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _31822 {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			char[] cArr = br.readLine().toCharArray();
			boolean isPossible = true;
			Loop2: for (int j = 0; j < 5; j++) {
				if (cArr[j] != s.charAt(j)) {
					isPossible = false;
					break Loop2;
				}
			}
			
			if (isPossible) count++;
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
