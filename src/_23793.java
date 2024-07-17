import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_23793 {
	int index;
	int cost;
	
	Node_23793(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _23793 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int INF = Integer.MAX_VALUE >> 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dist = new int[N];
		ArrayList<Node_23793>[] graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_23793(B, C));
		}
		
		st = new StringTokenizer(br.readLine());
		int START = Integer.parseInt(st.nextToken());
		int MID = Integer.parseInt(st.nextToken());
		int END = Integer.parseInt(st.nextToken());
		PriorityQueue<Node_23793> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[START] = 0;
		pq.offer(new Node_23793(START, dist[START]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_23793 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_23793(nextNode, dist[nextNode]));
				}
			}
		}
		
		if (dist[Y] == INF || dist2[Z] == INF) {
			sb.append(-1).append(" ");
		}
		
		if (dist)
	}

}
