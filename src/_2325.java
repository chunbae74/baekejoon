import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_2325 {
	int index;
	int cost;
	
	Node_2325(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}


public class _2325 {
	static final int INF = Integer.MAX_VALUE >> 1;
	static int N, M;
	
	static ArrayList<Node_2325>[] graph;
	static int[] backTracking;
	static int[] dist;
	static boolean[][] isForbidden;
	
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		backTracking = new int[N];
		dist = new int[N];
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_2325(B, C));
			graph[B].add(new Node_2325(A, C));
		}
		
		// 다익스트라 실행
		max = dijkstra(-1, -1);
		
		updateLoadStack(0, N - 1);
		
		System.out.println(max);
	}
	
	/**
	 * @param a < b
	 */
	public static int dijkstra(int a, int b) {
		PriorityQueue<Node_2325> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		for (int i = 0; i < N; i++) {
			dist[i] = INF;
		}
		dist[0] = 0;
		pq.offer(new Node_2325(0, dist[0]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			if (nowNode == N - 1) break;
			
			for (Node_2325 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				// 길 하나 금지
				if (a == Math.min(nowNode, nextNode) && b == Math.max(nowNode, nextNode)) continue;
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					backTracking[nextNode] = nowNode;
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_2325(nextNode, dist[nextNode]));
				}
			}
		}
		
		return dist[N - 1];
	}

	public static void updateLoadStack(int start, int nowNode) {
		if (start == nowNode) return;
		
		int preNode = backTracking[nowNode];
		int d = dijkstra(Math.min(preNode, nowNode), Math.max(preNode, nowNode));
		max = Math.max(max, d);
		updateLoadStack(start, preNode);
	}
}
