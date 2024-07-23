import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_11952 {
	int index;
	long cost;
	
	Node_11952(int index, long cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _11952 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node_11952> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.cost, e2.cost));
		
		final long INF = Long.MAX_VALUE >> 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 좀비에게 점령당한 도시의 수
		int K = Integer.parseInt(st.nextToken());
		// 위험한 도시의 범위
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		// 안전한 도시의 숙박비
		int p = Integer.parseInt(st.nextToken());
		// 위험한 도시의 숙박비
		int q = Integer.parseInt(st.nextToken());
		
		ArrayList<Node_11952>[] graph = new ArrayList[N];
		long[] distFromZombie = new long[N];
		long[] dist = new long[N];
		
		for (int n = 0; n < N; n++) {
			graph[n] = new ArrayList<>();
			distFromZombie[n] = dist[n] = INF;
		}
		
		for (int k = 0; k < K; k++) {
			int num = Integer.parseInt(br.readLine()) - 1;
			distFromZombie[num] = 0L;
			pq.offer(new Node_11952(num, distFromZombie[num]));
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			graph[A].add(new Node_11952(B, 1));
			graph[B].add(new Node_11952(A, 1));
		}
		
		/*
		 * 좀비에게 점령당한 도시와의 거리 구하기
		 */
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			long nowCost = pq.peek().cost;
			pq.poll();
			
			if (distFromZombie[nowNode] < nowCost) continue;
			
			for (Node_11952 next: graph[nowNode]) {
				int nextNode = next.index;
				long nextCost = next.cost;
				
				if (distFromZombie[nextNode] > distFromZombie[nowNode] + nextCost) {
					distFromZombie[nextNode] = distFromZombie[nowNode] + nextCost;
					pq.offer(new Node_11952(nextNode, distFromZombie[nextNode]));
				}
			}
		}
		
		pq.clear();
		dist[0] = 0;
		pq.offer(new Node_11952(0, dist[0]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			long nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			if (nowNode == N - 1) break;
			
			for(Node_11952 next: graph[nowNode]) {
				int nextNode = next.index;
				long nextCost = next.cost;
				
				// 좀비에게 점령당한 도시는 숙박이 불가능함
				if (distFromZombie[nextNode] == 0) continue;
				
				// 위험한 도시
				if (distFromZombie[nextNode] <= S) {
					nextCost = q;
				}
				// 안전한 도시
				else {
					nextCost = p;
				}
				
				// 맨 마지막 도시에서는 숙박을 안해도 됨
				if (nextNode == N - 1) nextCost = 0;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_11952(nextNode, dist[nextNode]));
				}
			}
		}
		
		System.out.println(dist[N - 1]);
		
	}

}
