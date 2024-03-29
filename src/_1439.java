import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		
		char first = s.charAt(0);
		
		int zero = 0;
		int one = 0;
		
		// 첫 번째 문자 종류
		if (first == '0') zero ++;
		else if (first == '1') one ++;
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			
			// 만약 이전거와 다르다면
			if (first != c) {
				if (c == '0') zero ++;
				else if (c == '1') one ++;
				first = c;
			}
		}
		
		bw.write(Math.min(zero, one) + "");
		bw.flush();
		bw.close();
	}
	

}
