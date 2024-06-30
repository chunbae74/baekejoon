import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_17835 {
	int index;
	long cost;
	
	Node_17835 (int index, long cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _17835 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final long INF = Long.MAX_VALUE >> 2;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 도시의 수
		int N = Integer.parseInt(st.nextToken());
		// 도로의 수
		int M = Integer.parseInt(st.nextToken());
		// 면접장의 수
		int K = Integer.parseInt(st.nextToken());
		
		long[] dist = new long[N];
		ArrayList<Node_17835>[] graph = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			// 단방향 도로
			// 면접장 -> node로 다익스트라를 진행할 것이기에
			// 도로 방향을 반대로 저장해야 함.
			graph[B].add(new Node_17835(A, C));
		}
		
		PriorityQueue<Node_17835> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.cost, e2.cost));
		st = new StringTokenizer(br.readLine());
		for (int k = 0; k < K; k++) {
			int start = Integer.parseInt(st.nextToken()) - 1;
			dist[start] = 0;
			pq.offer(new Node_17835(start, dist[start]));
		}
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			long nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_17835 next: graph[nowNode]) {
				int nextNode = next.index;
				long nextCost = next.cost;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_17835(nextNode, dist[nextNode]));
				}
			}
		}
		
		long max = Long.MIN_VALUE;
		int idx = -1;
		for (int i = 0; i < N; i++) {
			if (dist[i] == 0) continue;
			if (max < dist[i]) {
				max = dist[i];
				idx = i + 1;
			}
		}
		
		System.out.println(idx + "\n" + max);
	}

}