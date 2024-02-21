import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * i = y; j = x
 * 플로이드-워셜로 다시풀기
 */
public class _11403 {
	static ArrayList<Integer>[] graph;
	static StringBuilder sb = new StringBuilder();
	 
	// 정점의 개수
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N];
		
		for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) {
					graph[i].add(j);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(bfs(i, j)).append(" ");				
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static int bfs(int start, int end) {
		boolean[] visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		for (int n: graph[start]) {
			queue.offer(n);
			visited[n] = true;
		}
		
		boolean found = false;
		while (!queue.isEmpty()) {
			int v = queue.poll();

			if (v == end) {
				found = true;
				break;
			}
			
			for (int n: graph[v]) {
				if (!visited[n]) {
					queue.offer(n);
					visited[n] = true;
				}
			}
		}
		
		return found ? 1 : 0;
	}

}
