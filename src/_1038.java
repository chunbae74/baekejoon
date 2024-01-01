import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * N : N번째 감소하는 수
 * M : 자릿수
 */
public class _1038 {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		// 1022 : 9876543210
		if (N > 1022) {
			bw.write("-1");
			bw.flush();
			bw.close();
			return;
		}
		
		for (M = 1; ; M++) {
			int cal = (int)C(10, M);
			if (N - cal < 0) break;
			N -= cal;
		}
		
		arr = new int[M];
		
		dfs(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	

	/*
	 * startNum <= i < endNum
	 */
	public static void dfs(int depth) {
		if (N < 0) return;

		if (depth == M) {
			if (N == 0) {
				for (int n: arr) {
					sb.append(n);
				}
			}
			
			N--;
			
			return;
		}
		

		// 첫번째 자리 수
		if (depth == 0) {
			for (int i = M - 1; i < 10; i++) {
				arr[depth] = i;
				dfs(depth + 1);
			}
		}
		else {
			for (int i = 0; i < arr[depth - 1]; i++) {
				arr[depth] = i;
				dfs(depth + 1);
			}			
		}
	}
	
	
	/*
	 * nPr
	 */
	public static double P(int n, int r) {
		double result = 1;
		for (double i = 0; i < r; i++) {
			result *= (n - i);
		}
		return result;
		
	}
	
	
	/*
	 * nCr
	 */
	public static double C(int n, int r) {
		return P(n, r) / factorial(r);
	}
	
	public static double factorial(int n) {
		if (n <= 1) return 1;
		double result = 1.0;
		for (int i = 2; i <= n; i++) result *= i;
		return result;
	}
}
