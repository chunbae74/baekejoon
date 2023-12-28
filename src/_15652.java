import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * N : 1~N까지
 * M : 자릿수
 */
public class _15652 {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		dfs(1, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int startNum, int depth) {
		if (depth == M) {
			for (int n: arr) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for (int i = startNum; i <= N; i++) {
			arr[depth] = i;
			dfs(i, depth + 1);
		}
	}

}
