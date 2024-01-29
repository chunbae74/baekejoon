import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 정점번호는 1부터 N까지이다.
 */
/*
 * N : 정점의 개수
 * M : 간선의 개수
 * V : 탐색을 시작할 정점의 번호
 */
public class _1260 {

	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			
			graph[vertex1].add(vertex2);
			graph[vertex2].add(vertex1);
		}
		
		for (int i = 1; i < graph.length; i++) {
			Collections.sort(graph[i]);
		}
		
		isVisited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		isVisited = new boolean[N + 1];
		bfs(V);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	/*
	 * vertex : 탐색을 시작할 정점의 번호
	 * dfs : 깊이 우선 탐색
	 */
	public static void dfs(int vertex) {
		sb.append(vertex).append(" ");
		isVisited[vertex] = true;
		
		// 해당 정점에 연결된 노드 모두 방문
		for (int n: graph[vertex]) {
			// 만약 아직 방문하지 않았다면
			if (!isVisited[n]) {
				dfs(n);
			}
		}
	}
	
	/*
	 * vertex : 탐색을 시작할 정점의 번호
	 * bfs : 너비 우선 탐색
	 */
	public static void bfs(int vertex) {
		// bfs에서 사용할 큐
		// 큐 : 선입선출, FIFO(First-in-First-Out)
		Queue<Integer> queue = new LinkedList<>();
		
		// 큐에 시작 할 노드 번호를 넣어준다.
		queue.add(vertex);
		// 시작노드 방문 처리
		isVisited[vertex] = true;
		
		// 큐가 빌때까지 반복
		while (!queue.isEmpty()) {
			int v = queue.poll();
			sb.append(v).append(" ");
			
			// 큐에서 꺼낸 노드와 연결도니 노드들 체크
			for (int n: graph[v]) {
				// 방문하지 않았으면 방문처리 후 큐에 넣기
				if (!isVisited[n]) {
					queue.add(n);
					isVisited[n] = true;
				}
			}
		}
	}

}
