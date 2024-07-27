import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_16681 {
	int index;
	long cost;
	
	Node_16681(int index, long cost) {
		this.index = index;
		this.cost = cost;
	}
}

/*
 * 성취감은 높게, 소모한 체력은 낮게
 * 높이(1<=h<=1_000_000)는 높게, 이동거리는 적게 
 */
public class _16681 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final long INF = Long.MAX_VALUE >> 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[] height = new int[N];
		long[] distFromHome = new long[N];
		long[] distFromSchool = new long[N];
		ArrayList<Node_16681>[] graph = new ArrayList[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			distFromHome[i] = distFromSchool[i] = INF;
			graph[i] = new ArrayList<>();
		}
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_16681(B, C));
			graph[B].add(new Node_16681(A, C));
		}
		
		PriorityQueue<Node_16681> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.cost, e2.cost));
		distFromHome[0] = 0;
		pq.offer(new Node_16681(0, distFromHome[0]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			long nowCost = pq.peek().cost;
			pq.poll();
			
			if (distFromHome[nowNode] < nowCost) continue;
			
			for (Node_16681 next: graph[nowNode]) {
				int nextNode = next.index;
				long nextCost = next.cost;
				
				// 목표에 도달할 때 까지는 항상 높이가 증가하는 방향으로만 이동해야 한다.
				if (height[nowNode] >= height[nextNode]) continue;
				
				if (distFromHome[nextNode] > distFromHome[nowNode] + nextCost) {
					distFromHome[nextNode] = distFromHome[nowNode] + nextCost;
					pq.offer(new Node_16681(nextNode, distFromHome[nextNode]));
				}
			}
		}
		
		pq.clear();
		distFromSchool[N - 1] = 0;
		pq.offer(new Node_16681(N - 1, distFromSchool[N - 1]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			long nowCost = pq.peek().cost;
			pq.poll();
			
			if (distFromSchool[nowNode] < nowCost) continue;
			
			for (Node_16681 next: graph[nowNode]) {
				int nextNode = next.index;
				long nextCost = next.cost;
				// 목표에 도달할 때 까지는 항상 높이가 감소하는 방향으로만 이동해야 한다.
				if (height[nowNode] >= height[nextNode]) continue;
				
				if (distFromSchool[nextNode] > distFromSchool[nowNode] + nextCost) {
					distFromSchool[nextNode] = distFromSchool[nowNode] + nextCost;
					pq.offer(new Node_16681(nextNode, distFromSchool[nextNode]));
				}
			}
		}
		
		
		long max = -1 * Long.MAX_VALUE;
		boolean isPossible = false;
		for (int i = 1; i < N - 1; i++) {
			if (distFromHome[i] == INF || distFromSchool[i] == INF) continue;
			long totalDistance = distFromHome[i] + distFromSchool[i];
			int h = height[i];
			long cal = (h * E) - (totalDistance * D);
			
			if (max < cal) {
				max = cal;
				isPossible = true;
			}
		}
		
		System.out.println(isPossible ? max : "Impossible");
	}

}
