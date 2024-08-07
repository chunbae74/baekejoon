import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_2307 {
	int index;
	int cost;
	
	Node_2307(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _2307 {
	static final int INF = Integer.MAX_VALUE >> 1;
	static int N, M;
	
	static ArrayList<Node_2307>[] graph;
	static ArrayList<Integer>[] backTracking;
	
	static int min = 0;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N];
		backTracking = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
			backTracking[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_2307(B, C));
			graph[B].add(new Node_2307(A, C));
		}
		
		min = max = dijkstra(-1, -1);
		
		updateBackTracking(0, N - 1);
		
		if (max == INF) {
			System.out.println(-1);
		} else {
			System.out.println(max - min);
		}
	}
	
	/**
	 * @param a, b: a-b사이의 도로 검문
	 * 		  a < b
	 * @return dist[N - 1]
	 */
	public static int dijkstra(int a, int b) {
		int[] dist = new int[N];
		for (int i = 0; i < N; i++) {
			dist[i] = INF;
		}
		
		PriorityQueue<Node_2307> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[0] = 0;
		pq.offer(new Node_2307(0, dist[0]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			if (nowNode == N - 1) break;
			
			for (Node_2307 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				// 검문중인 도로. 통행 불가능
				if (a == Math.min(nowNode, nextNode) && b == Math.max(nowNode, nextNode)) continue;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					// backTracking초기화 후 nowNode 추가
					backTracking[nextNode] = new ArrayList<>();
					backTracking[nextNode].add(nowNode);
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_2307(nextNode, dist[nextNode]));
				} else if (dist[nextNode] == dist[nowNode] + nextCost) {
					backTracking[nextNode].add(nowNode);
				}
			}
		}
		
		return dist[N - 1];
	}

	
	public static void updateBackTracking(int start, int nowNode) {
		if (start == nowNode) return;
		
		for (int preNode: backTracking[nowNode]) {
			int d = dijkstra(Math.min(preNode, nowNode), Math.max(preNode, nowNode));
			max = Math.max(d, max);
			updateBackTracking(start, preNode);
		}
	}
}
