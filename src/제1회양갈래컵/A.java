package 제1회양갈래컵;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int W = Integer.parseInt(br.readLine());
		
		int x = (int)Math.sqrt(W / 2.0);
		
		bw.write((8 * x) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
