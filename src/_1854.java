import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_1854 {
	int index;
	int cost;
	
	Node_1854(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _1854 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer>[] dist = new PriorityQueue[N];
		ArrayList<Node_1854>[] graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			dist[i] = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
			graph[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_1854(B, C));
		}
		
		PriorityQueue<Node_1854> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[0].add(0);
		pq.offer(new Node_1854(0, 0));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			for (Node_1854 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = nowCost + next.cost;
				
				if (dist[nextNode].size() < K) {
					dist[nextNode].add(nextCost);
					pq.offer(new Node_1854(nextNode, nextCost));
				} else {
					if (dist[nextNode].peek() > nextCost) {
						dist[nextNode].poll();
						dist[nextNode].add(nextCost);
						pq.offer(new Node_1854(nextNode, nextCost));
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(dist[i].size() < K ? -1 : dist[i].peek());
		}
	}

}
