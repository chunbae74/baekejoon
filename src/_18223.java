import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_18223 {
	int index;
	int cost;
	
	Node_18223(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _18223 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int INF = Integer.MAX_VALUE >> 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int TARGET = Integer.parseInt(st.nextToken());
		ArrayList<Node_18223>[] graph = new ArrayList[V + 1];
		int[] dist = new int[V + 1];
		
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_18223(B, C));
			graph[B].add(new Node_18223(A, C));
		}
		
		PriorityQueue<Node_18223> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[1] = 0;
		pq.offer(new Node_18223(1, dist[1]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_18223 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_18223(nextNode, dist[nextNode]));
				}
			}
		}
		
		int[] dist2 = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			dist2[i] = INF;
		}
		
		pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist2[TARGET] = 0;
		pq.offer(new Node_18223(TARGET, dist2[TARGET]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist2[nowNode] < nowCost) continue;
			
			for (Node_18223 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (dist2[nextNode] > dist2[nowNode] + nextCost) {
					dist2[nextNode] = dist2[nowNode] + nextCost;
					pq.offer(new Node_18223(nextNode, dist2[nextNode]));
				}
			}
		}
		
		bw.write((dist[V] == (dist2[1] + dist2[V])) ? "SAVE HIM" : "GOOD BYE");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
