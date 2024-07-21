import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_13308 {
	int index;
	int cost;
	
	Node_13308(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

/*
 * 참고ㅣ
 * https://cmj092222.tistory.com/575
 */
public class _13308 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final long INF = Long.MAX_VALUE >> 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cost = new int[N];
		long[][] dist = new long[N][2_501];
		ArrayList<Node_13308>[] graph = new ArrayList[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
			for (int j = 0; j < 2_501; j++) {
				dist[i][j] = INF;
			}
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_13308(B, C));
			graph[B].add(new Node_13308(A, C));
		}
		
		// [node, dist[node][minOilCost], minOilCost]
		PriorityQueue<long[]> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1[1], e2[1]));
		dist[0][cost[0]] = 0;
		pq.offer(new long[] { 0, dist[0][cost[0]], cost[0] });
		while (!pq.isEmpty()) {
			int nowNode = (int)pq.peek()[0];
			long nowCost = pq.peek()[1];
			int nowMinOilCost = (int)pq.peek()[2];
			pq.poll();
			
			if (dist[nowNode][nowMinOilCost] < nowCost) continue;

			if (nowNode == N - 1) {
				System.out.println(dist[N - 1][nowMinOilCost]);
				break;
			}
			
			for (Node_13308 next: graph[nowNode]) {
				int nextNode = next.index;
				long nextCost = nowCost + (nowMinOilCost * next.cost);
				int nextMinOilCost = Math.min(cost[nextNode], nowMinOilCost);
				
				if (dist[nextNode][nextMinOilCost] > nextCost) {
					dist[nextNode][nextMinOilCost] = nextCost;
					pq.offer(new long[] { nextNode, dist[nextNode][nextMinOilCost], nextMinOilCost });
				}
			}
		}
		
	}

}
