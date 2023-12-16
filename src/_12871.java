import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _12871 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String word1 = br.readLine();
		String word2 = br.readLine();
		StringBuilder s1 = new StringBuilder(word1);
		StringBuilder s2 = new StringBuilder(word2);
		
		int lcm = word1.length() * word2.length() / gcd(word1.length(), word2.length());
		for(int i = 0; i < lcm / word1.length() - 1; i++) {
			s1.append(word1);
		}

		for(int i = 0; i < lcm / word2.length() - 1; i++) {
			s2.append(word2);
		}
		bw.write(s1.toString().equals(s2.toString())?"1":"0");
		bw.flush();
		bw.close();
	}
	
	// (a, b) = (b, c) ... (c, 0)
	public static int gcd(int n1, int n2) {
		if (n2 == 0) return n1;
		else return gcd(n2, n1 % n2);
	}

}
