import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_17396 {
	int index;
	long cost;
	
	Node_17396(int index, long cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _17396 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final long INF = 100000L * 300000 + 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Node_17396>[] graph = new ArrayList[N];
		long[] dist = new long[N];
		// 적의 시야가 보이는지 여부
		boolean[] isPossible = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
			int num = Integer.parseInt(st.nextToken());
			// 적의 시야가 보이지 않는 곳은 갈 수 있다.
			if (num == 0) isPossible[i] = true;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_17396(B, C));
			graph[B].add(new Node_17396(A, C));
		}
		
		PriorityQueue<Node_17396> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.cost, e2.cost));
		dist[0] = 0;
		pq.offer(new Node_17396(0, dist[0]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			long nowCost = pq.peek().cost;
			pq.poll();
			
			// 적의 시야가 보이는 곳은 갈 수 없다.
			if (!isPossible[nowNode]) continue;
			if (dist[nowNode] < nowCost) continue;
			// 도착
			if (nowNode == N - 1) break;
			
			for (Node_17396 next: graph[nowNode]) {
				int nextNode = next.index;
				long nextCost = next.cost;
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_17396(nextNode, dist[nextNode]));
				}
			}
		}
		bw.write((dist[N - 1] == INF) ? "-1" : (dist[N - 1] + ""));
		bw.flush();
		bw.close();
		br.close();
	}

}
