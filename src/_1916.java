import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_1916 {
	int index;
	int cost;
	
	Node_1916(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}
/*
 * N: 도시 개수
 * M: 버스 개수
 */
public class _1916 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Node_1916>[] graph = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[s].add(new Node_1916(e, c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int START = Integer.parseInt(st.nextToken());
		int END = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node_1916> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[START] = 0;
		pq.offer(new Node_1916(START, dist[START]));
		
		while (!pq.isEmpty()) {
			int nowV = pq.poll().index;
			
			if (nowV == END) {
				break;
			}
			
			if (visited[nowV]) {
				continue;
			}
			
			visited[nowV] = true;
			
			for (Node_1916 nextNode: graph[nowV]) {
				int nextV = nextNode.index;
				// nowNode -> nextCost로 가는 데 드는 비용
				int nextCost = nextNode.cost;
				
				if (dist[nextV] > dist[nowV] + nextCost) {
					dist[nextV] = dist[nowV] + nextCost;
					pq.offer(new Node_1916(nextV, dist[nextV]));
				}
			}
		}
		
		bw.write(dist[END] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
