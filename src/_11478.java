import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class _11478 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S = br.readLine();
		int m = 1;
		HashSet<String> hs = new HashSet<>();
		while(m <= S.length()) {
			for (int i = 0; i < S.length() - m + 1; i++) 
				hs.add(S.substring(i, i+m));
			m++;
		}
		bw.write(hs.size()+"");
		bw.flush();
		bw.close();
	}
}
