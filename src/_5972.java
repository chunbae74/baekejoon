import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_5972 {
	int index;
	int cost;
	
	Node_5972(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _5972 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int INF = Integer.MAX_VALUE;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		final int START = 1;
		final int END = N;
		
		ArrayList<Node_5972>[] graph = new ArrayList[N + 1];
		int[] dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_5972(B, C));
			graph[B].add(new Node_5972(A, C));
		}
		
		PriorityQueue<Node_5972> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[START] = 0;
		pq.add(new Node_5972(START, dist[START]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_5972 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_5972(nextNode, dist[nextNode]));
				}
			}
		}
		
		bw.write(dist[END] + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
