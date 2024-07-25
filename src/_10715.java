import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_10715 {
	int index;
	int cost;
	
	Node_10715(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _10715 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		ArrayList<Node_10715>[] graph = new ArrayList[N];
		int[] dist = new int[N];
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int D = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_10715(B, D));
			graph[B].add(new Node_10715(A, D));
		}
		
		PriorityQueue<Node_10715> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[0] = 0;
		pq.offer(new Node_10715(0, dist[0]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_10715 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_10715(nextNode, dist[nextNode]));
				}
			}
		}
		
		
	}

}
