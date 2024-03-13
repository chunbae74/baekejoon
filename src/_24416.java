import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _24416 {
	static int count1 = 0;
	static int count2 = 0;
	
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n + 1];
		
		fib(n);
		fibonacci(n);
		
		bw.write(count1 + " " + count2);
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int fib(int n) {
		if (n == 1 || n == 2) {
			count1 ++;
			return 1;
		}
		else  return fib(n - 1) + fib(n - 2);
	}
	
	public static int fibonacci(int n) {
		arr[0] = arr[1] = 1;
		for (int i = 3; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			count2 ++;
			arr[i - 2] = arr[i -1];
			arr[i - 1] = arr[i];
		}
		
		return arr[n];
	}

}
