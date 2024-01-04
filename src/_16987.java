import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 
 */
public class _16987 {
	static int[][] arr = { {8, 5}, {1, 100}, {3, 5}};
	static int count = 0;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dfs(0);
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int leftIdx) {
		// 한 개만 남게된다면
		if (num == 1) {
			if (count > max) max = count;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			
		}
	}

}
