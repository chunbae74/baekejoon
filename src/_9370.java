import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_9370 {
	int index;
	int cost;
	
	Node_9370(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _9370 {
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node_9370>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
		    // N: 노드 / M : 도로 / K: 목적지 후보 개수
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N + 1];
			for (int i = 1; i < N + 1; i++) {
				graph[i] = new ArrayList<>();
			}

			// 목적지 후보들
			boolean[] couldBeDestination = new boolean[N + 1];
			
			// S: 예술가들의 출발지 / G -> H 사이 교차로 지나감
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			// g와 h 사이의 거리
			int distBtwGH = 0;
			
			// 노드 간 양방향 도로 저장
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				graph[A].add(new Node_9370(B, C));
				graph[B].add(new Node_9370(A, C));
				
				if ((A == G && B == H) || (A == H && B == G)) {
					distBtwGH = C;
				}
			}
			
			// 다익스트라 슈슈슉
			int[] distFromS = dijkstra(N, S);
			int[] distFromG = dijkstra(N, G);
			int[] distFromH = dijkstra(N, H);
			// s -> spot1 + spot1 -> spot2의 거리
			int distToSpot1 = Math.min(distFromS[G], distFromS[H]) + distBtwGH;
			
			// 목적지 후보들
			for (int k = 0; k < K; k++) {
				int spot = Integer.parseInt(br.readLine());
				couldBeDestination[spot] = true;
			}
			
			for (int i = 1; i < N + 1; i++) {
				if (!couldBeDestination[i]) continue;
				int distFromSpot2 = Math.min(distFromG[i],  distFromH[i]);
				
				if (distToSpot1 + distFromSpot2 == distFromS[i]) {
					sb.append(i).append(" ");
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	public static int[] dijkstra(int N, int start) {
		int[] dist = new int[N + 1];
		// 배열 초기화
		for (int i = 1; i < N + 1; i++) {
			dist[i] = INF;
		}
		
		dist[start] = 0;
		
		PriorityQueue<Node_9370> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		pq.offer(new Node_9370(start, dist[start]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) {
				continue;
			}
			
			for (Node_9370 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_9370(nextNode, dist[nextNode]));
				}
			}
		}
		
		return dist;
	}

}
