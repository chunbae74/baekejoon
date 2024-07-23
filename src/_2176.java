import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_2176 {
	int index;
	int cost;
	
	Node_2176(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

/*
 * S에서 T로 가까워지며 이동한다
 * (u, v)를 u -> v로 이동할 때의 비용이라고 한다면
 * S -> X일 때 (S, T) > (X, T)
 */
public class _2176 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int INF = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N][N];;
		int[] dist = new int[N];
		
		for (int n = 0; n < N; n++) {
			dist[n] = INF;
			for (int j = 0; j < N; j++) {
				if (n == j) continue;
				graph[n][j] = INF;
			}
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A][B] = graph[B][A] = C;
		}
		
		PriorityQueue<Node_2176> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[1] = 0;
		pq.offer(new Node_2176(1, dist[1]));

		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			if (nowNode == 0) break;
			
			for (int nextNode = 0; nextNode < N; nextNode++) {
				if (nowNode == nextNode) continue;
				int nextCost = graph[nowNode][nextNode];
				if (nextCost == INF) continue;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_2176(nextNode, dist[nextNode]));
				}
			}
		}
		
		int[] dp = new int[N];
		dp[1] = 1;
		for (int nowNode = 0; nowNode < N; nowNode++) {
			for (int nextNode = 0; nextNode < N; nextNode++) {
				if (nowNode == nextNode) continue;
				if (graph[nowNode][nextNode] == INF) continue;
				if (dist[nowNode] > dist[nextNode]) {
					dp[nextNode] += dp[nowNode];
				}
			}
		}
		
		System.out.println(dp[1]);
	}

}
