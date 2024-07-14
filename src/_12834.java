import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_12834 {
	int index;
	int cost;
	
	Node_12834(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _12834 {
	static final int INF = Integer.MAX_VALUE >> 1;
	static int N, V, E;
	static int KIST, CRFOOD;
	static ArrayList<Node_12834>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		int[] starts = new int[N];
		graph = new ArrayList[V];
		
		for (int v = 0; v < V; v++) {
			graph[v] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		KIST = Integer.parseInt(st.nextToken()) - 1;
		CRFOOD = Integer.parseInt(st.nextToken()) - 1;
		
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			starts[n] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_12834(B, C));
			graph[B].add(new Node_12834(A, C));
		}
		
		long sum = 0;
		for (int s: starts) {
			sum += dikjstra(s);
		}
		
		System.out.println(sum);
	}
	
	public static long dikjstra(int start) {
		PriorityQueue<Node_12834> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		int[] dist = new int[V];
		for (int i = 0; i < V; i++) {
			dist[i] = INF;
		}
		
		dist[start] = 0;
		pq.offer(new Node_12834(start, dist[start]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_12834 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_12834(nextNode, dist[nextNode]));
				}
			}
		}
		
		int d1 = (dist[KIST] == INF) ? -1 : dist[KIST];
		int d2 = (dist[CRFOOD] == INF) ? -1 : dist[CRFOOD];
		return d1 + d2;
	}
}
