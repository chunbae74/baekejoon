import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 수의 범위..int형 배열 -> long형 배열로 수정
public class _2748 {
	static long[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new long[n + 1];
		
		/*
		 * top-down 방식(재귀)
		fibo(n);
		bw.write(arr[n] + "");
		*/
		
		//bottom up방식 
		long sum = 1;
		long a = 0;
		long b = 1;
		
		for (int i = 1; i < n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static long fibo(int n) {
		if (n == 0 || n == 1) {
			arr[n] = n;
			return arr[n];
		}
		
		if (arr[n] != 0) return arr[n];
		else {
			arr[n] = fibo(n - 1) + fibo(n - 2);
			return arr[n];
		}
	}
	

}
