import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * N : 정점의 개수
 * M : 간선의 개수
 */
public class _11724 {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	// 방문한 정점의 개수
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			
			graph[vertex1].add(vertex2);
			graph[vertex2].add(vertex1);
		}
		
//		int result = bfs(N);
		int result = dfs(N);
		
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
	
	public static int bfs(int N) {
		// 지역변수; 요소의 개수
		int result = 0;
		Queue<Integer> queue = new LinkedList<>();
		
		// 모든 정점을 방문할 때 까지 반복
		while(count < N) {
			int idx = 1;
			// 아직 방문하지 않은 정점 구하기
			Loop2: for (; idx <= N; idx++) {
				// 아직 방문하지 않았다면
				if (!visited[idx]) {
					// 새로운 요소이므로 result + 1;
					result ++;
					break Loop2;
				}
			}
			
			// 큐에 idx정점 넣고 방문표시
			queue.offer(idx);
			visited[idx] = true;
			count ++;
			
			while (!queue.isEmpty()) {
				int v = queue.poll();
				
				for (int n: graph[v]) {
					// 만약 아직 방문하지 않은 정점이라면
					if (!visited[n]) {
						// 큐에 정점 추가 후 방문표시
						count ++;
						queue.offer(n);
						visited[n] = true;
					}
				}
			}
		}
		
		return result;
	}
	
	
	public static int dfs(int N) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		
		while (count < N) {
			int idx = 1;
			for (; idx <= N; idx++) {
				if (!visited[idx]) {
					result ++;
					break;
				}
			}
			
			stack.add(idx);
			visited[idx] = true;
			count ++;
			
			while (!stack.isEmpty()) {
				int v = stack.pop();
				
				for (int n: graph[v]) {
					if (!visited[n]) {
						stack.add(n);
						visited[n] = true;
						count ++;
					}
				}
			}
		}
		
		return result;
	}

}
