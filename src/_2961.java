import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2961 {
	static int N;
	static int[][] arr;
	static boolean[] ingredient;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		ingredient = new boolean[N];
		
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[i][0] = S;
			arr[i][1] = B;
		}
		
		dfs(false, 0);
		dfs(true, 0);
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(boolean isOn, int depth) {
		ingredient[depth] = isOn;
		
		if (depth == N - 1) {
			int sumOfS = 0;
			int sumOfB = 0;
			for (int i = 0; i < N; i++) {
				if (ingredient[i]) {
					if (sumOfS == 0) sumOfS = arr[i][0];
					else sumOfS *= arr[i][0];
					sumOfB += arr[i][1];
				}
			}
			
			if (sumOfS == 0 && sumOfB == 0) return;
			
			int cal = Math.abs(sumOfS - sumOfB);
			if (result > cal) {
				result = cal; 
			}
			
			return;
		}
		
		dfs(false, depth + 1);
		dfs(true, depth + 1);
	}

}
