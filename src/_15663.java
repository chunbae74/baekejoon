import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * N : N개의 자연수
 * M : 수열의 길이
 * 출력은 사전순으로
 */
public class _15663 {
	static int N, M;
	static int[] num;
	static int[] arr;
	static boolean[] visited;
	static HashSet<String> hs = new HashSet<>();
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		arr = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
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
			// 중복이 아니라면
			if (!hs.contains(Arrays.toString(arr))) {
				hs.add(Arrays.toString(arr));
				for (int n: arr) {
					sb.append(n).append(" ");
				}
				sb.append("\n");
			}
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = num[i];
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
