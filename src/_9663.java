import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9663 {
	static int N;
	static int count = 0;
	static int[] arr = new int[15];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		N = Integer.parseInt(br.readLine());
				
		nQueen(0);
		
		System.out.println(count);
	}
	
	public static void nQueen(int depth) {
		// 끝
		if (depth == N) {
			return;
		} 
		
		for (int i = 0; i < N; i++) {
			
			arr[depth] = i;
			nQueen(depth + 1);
		}
	}
	
	public static boolean isRight(int idx) {
		
	}

}
