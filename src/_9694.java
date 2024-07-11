import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_9694 {
	int index;
	int cost;
	
	Node_9694(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _9694 {
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node_9694>[] graph;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			graph = new ArrayList[M];
			
			for (int m = 0; m < M; m++) {
				graph[m] = new ArrayList<>();
			}
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				graph[A].add(new Node_9694(B, C));
				graph[B].add(new Node_9694(A, C));
			}
			
			dikjstra(t, M);
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dikjstra(int t, int M) {
		// [idx, dist[idx], count, order...]
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
		int[] dist = new int[M];
		for (int i = 0; i < M; i++) {
			dist[i] = INF;
		}
		
		dist[0] = 0;
		pq.offer(new int[] { 0, dist[0], 1, 0 });
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int nowNode = now[0];
			int nowCost = now[1];
			int count = now[2];
			
			if (dist[nowNode] < nowCost) continue;
			
			if (nowNode == M - 1) {
				sb.append("Case #").append(t).append(": ");
				for (int i = 3; i < now.length; i++) {
					sb.append(now[i]).append(" ");
				}
				sb.append("\n");
				break;
			}
			
			for (Node_9694 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					int[] n = new int[count + 1 + 3];
					n[0] = nextNode;
					n[1] = dist[nextNode];
					n[2] = count + 1;
					for (int i = 3; i < n.length - 1; i++) {
						n[i] = now[i];
					}
					n[n.length - 1] = nextNode;
					pq.offer(n);
				}
			}
		}
		
		if (dist[M - 1] == INF) {
			sb.append("Case #").append(t).append(": -1\n");
		}
		
	}

}
