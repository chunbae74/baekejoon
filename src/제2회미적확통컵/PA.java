package 제2회미적확통컵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		double cal = factorial(N) / (factorial(A) * factorial(B) * factorial(C));
		
		String s = Double.toString(cal);

		System.out.println(s.substring(0, s.length() - 2));
	}
	
	/*
	 * nPr
	 */
	public static int P(int n, int r) {
		int result = 1;
		for (int i = 0; i < r; i++) {
			result *= (n - i);
		}
		return result;
		
	}

	public static double factorial(int n) {
		if (n <= 1) return 1;
		double result = 1.0;
		for (int i = 2; i <= n; i++) result *= i;
		return result;
	}
}
