import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_18352 {
	int index;
	int cost;
	
	Node_18352(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _18352 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		final int INF = 1_000_000 + 1;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int START = Integer.parseInt(st.nextToken());
		
		ArrayList<Node_18352>[] graph = new ArrayList[N + 1];
		int[] dist = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		for (int i =0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_18352(B, 1));
		}
		
		PriorityQueue<Node_18352> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[START] = 0;
		pq.offer(new Node_18352(START, dist[START]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_18352 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_18352(nextNode, dist[nextNode]));
				}
			}
		}
		
		boolean isExist = false;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				isExist = true;
				sb.append(i).append("\n");
			}
		}
		
		bw.write(isExist ? sb.toString() : "-1");
		bw.flush();
		bw.close();
		br.close();
	}

}
