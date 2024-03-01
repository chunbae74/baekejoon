package 제3회초콜릿컵;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			int a = 0;
			int b = 0;
			
			int n = -1;
			for (char c: s.toCharArray()) {
				if (c == '0' || c == '1') {
					n = c - '0';
					continue;
				}
				
				if (n == -1) a++;
				else b++;
			}
			
			if (b > 0) n = 1;
			a %= 2;
			
			if (a == 0) sb.append(n).append("\n");
			else if (a == 1) {
				if (n == 0) sb.append("1\n");
				else sb.append("0\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
