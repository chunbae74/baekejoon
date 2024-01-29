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
 * 컴퓨터의 수는 100이하인 양의 정수이며, 각 컴퓨터에는 1번부터 차례대로 번호가 매겨진다.
 */
public class _2606 {
	static ArrayList<Integer>[] graph;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 정점의 개수
		int N = Integer.parseInt(br.readLine());
		// 간선의 개수
		int M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N + 1];
		
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			
			graph[vertex1].add(vertex2);
			graph[vertex2].add(vertex1);
		}
		
		isVisited = new boolean[N + 1];
		
		int result = bfs(1);
		
		bw.write(result + "");
		bw.flush();
		bw.close();
		
	}
	
	
	public static int bfs(int vertex) {
		Queue<Integer> queue = new LinkedList<>();
		
		// 바이러스에 감염된 컴퓨터 수
		int count = 0;

		// 첫 번째 컴퓨터를 큐에 추가 후 방문처리
		queue.add(vertex);
		isVisited[vertex] = true;
		
		while (!queue.isEmpty()) {
			int v = queue.poll();
			count ++;
			
			for (int n: graph[v]) {
				// 아직 방문하지 않았다면 큐에 추가 후 방문처리
				if (!isVisited[n]) {
					queue.offer(n);
					isVisited[n] = true;
				}
			}
		}
		
		// 1번 컴퓨터는 제외
		return count - 1;
	}

}
