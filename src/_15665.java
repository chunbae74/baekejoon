import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * N개의 수 중 M개를 고른 수열
 * 같은 수를 여러 번 골라도 됨
 * 중복되는 수열은 X 
 */
public class _15665 {
	static int N, M;
	static int[] num;
	static int[] arr;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		dfs(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
	public static void dfs(int depth) {
		if (depth == M) {
			for (int n: arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int prev = -1;
		for (int i = 0; i < N; i++) {
			// 중복되는 순열 방지
			if (prev == num[i]) continue;
			prev = num[i];
			arr[depth] = num[i];
			dfs(depth + 1);
		}
	}

}
