import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_13911 {
	int index;
	long cost;
	
	Node_13911(int index, long cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _13911 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final long INF = Long.MAX_VALUE >> 2;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점의 개수
		int V = Integer.parseInt(st.nextToken());
		// 도로의 개수
		int E = Integer.parseInt(st.nextToken());
		
		long[] distFromMcd = new long[V];
		long[] distFromStar = new long[V];
		boolean[] isMcd = new boolean[V];
		boolean[] isStar = new boolean[V];
		
		ArrayList<Node_13911>[] graph = new ArrayList[V];
		
		for (int i = 0; i < V; i++) {
			distFromMcd[i] = distFromStar[i] = INF;
			graph[i] = new ArrayList<>();
		}
		
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			
			graph[A].add(new Node_13911(B, C));
			graph[B].add(new Node_13911(A, C));
		}
		
		st = new StringTokenizer(br.readLine());
		// M: 맥도날드의 수
		// x: 맥세권일 조건
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		// 맥도날드 위치 저장
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int num = Integer.parseInt(st.nextToken()) - 1;
			isMcd[num] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		// S: 스타벅스의 수
		// y: 스세권일 조건
		int S = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		// 스타벅스 위치 저장
		st = new StringTokenizer(br.readLine());
		for (int s = 0; s < S; s++) {
			int num = Integer.parseInt(st.nextToken()) - 1;
			isStar[num] = true;
		}

		
		// 멕세권 구하기
		PriorityQueue<Node_13911> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.cost, e2.cost));
		for (int i = 0; i < V; i++) {
			if (!isMcd[i]) continue;
			distFromMcd[i] = 0;
			pq.offer(new Node_13911(i, distFromMcd[i]));
		}
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			long nowCost = pq.peek().cost;
			pq.poll();
			
			if (distFromMcd[nowNode] < nowCost) continue;
			
			for (Node_13911 next: graph[nowNode]) {
				int nextNode = next.index;
				long nextCost = next.cost;
				
				if (distFromMcd[nextNode] > distFromMcd[nowNode] + nextCost) {
					distFromMcd[nextNode] = distFromMcd[nowNode] + nextCost;
					pq.offer(new Node_13911(nextNode, distFromMcd[nextNode]));
				}
			}
		}
		
		// 스세권 구하기
		for (int i = 0; i < V; i++) {
			if (!isStar[i]) continue;
			distFromStar[i] = 0;
			pq.offer(new Node_13911(i, distFromStar[i]));
		}
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			long nowCost = pq.peek().cost;
			pq.poll();
			
			if (distFromStar[nowNode] < nowCost) continue;
			
			for (Node_13911 next: graph[nowNode]) {
				int nextNode = next.index;
				long nextCost = next.cost;
				
				if (distFromStar[nextNode] > distFromStar[nowNode] + nextCost) {
					distFromStar[nextNode] = distFromStar[nowNode] + nextCost;
					pq.offer(new Node_13911(nextNode, distFromStar[nextNode]));
				}
			}
		}
		
		long min = INF;
		for (int i = 0; i < V; i++) {
			if (isMcd[i] || isStar[i]) continue;
			if (distFromMcd[i] > x || distFromStar[i] > y) continue;
			long cal = distFromMcd[i] + distFromStar[i];
			if (min > cal) {
				min = cal;
			}
		}
		
		System.out.println(min == INF ? "-1" : min);
	}
}