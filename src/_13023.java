import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * N : 사람의 수
 * M : 친구 관계의 수
 */
public class _13023 {
	static int N, M;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[A].add(B);
			arr[B].add(A);
		}
		
		for (int i = 0; i < N; i++) {
			dfs(i, 1);
		}
		
		// 프로그램이 이전에 종료되지 않았다 = count >= 5인 경우가 없었다
		bw.write("0");
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int nowF, int count) {
		if (count >= 5) {
			System.out.println("1");
			// 프로그램 종료
			System.exit(0);
		}
		
		visited[nowF] = true;
		
		for (int nextF: arr[nowF]) {
			if (visited[nextF]) continue;
			
			dfs(nextF, count + 1);
		}
		
		visited[nowF] = false;
	}
}
