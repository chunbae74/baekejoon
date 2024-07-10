import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_22865 {
	int index;
	int cost;
	
	Node_22865(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _22865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE;
		
		int N = Integer.parseInt(br.readLine());
		int[] dist = new int[N];
		ArrayList<Node_22865>[] graph = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			dist[i] = INF;
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()) - 1;
		int B = Integer.parseInt(st.nextToken()) - 1;
		int C = Integer.parseInt(st.nextToken()) - 1;
		int M = Integer.parseInt(br.readLine());
		
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken()) - 1;
			int E = Integer.parseInt(st.nextToken()) - 1;
			int L = Integer.parseInt(st.nextToken());
			graph[D].add(new Node_22865(E, L));
			graph[E].add(new Node_22865(D, L));
		}
		
		PriorityQueue<Node_22865> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[A] = dist[B] = dist[C] = 0;
		pq.offer(new Node_22865(A, dist[A]));
		pq.offer(new Node_22865(B, dist[B]));
		pq.offer(new Node_22865(C, dist[C]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_22865 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_22865(nextNode, dist[nextNode]));
				}
			}
		}
		
		int ans = -1;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			if (dist[i] > max) {
				ans = i + 1;
				max = dist[i];
			}
		}
		
		System.out.println(ans);
	}

}
