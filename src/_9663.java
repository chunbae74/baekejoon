import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663 {
	static int N = 0;
	static int count = 0;
	static int[] arr = new int[15];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		N = Integer.parseInt(br.readLine());
				
		nQueen(0);
		
		System.out.println(count);
	}
	
	public static int nQueen(int n) {
		// 끝
		if (n == N) {
			return 0;
		} else {
			System.out.println(n);
			n += 1;
			return nQueen(n);
		}
	}
	
	public static boolean isRight(int n) {
		
	}

}
