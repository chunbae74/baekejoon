import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_1238 {
	int index;
	int cost;
	
	Node_1238(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _1238 {
	static int N;
	static int[] dist;
	static ArrayList<Node_1238>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		dist = new int[N + 1];
		graph = new ArrayList[N + 1];
		int[] totalCost = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[s].add(new Node_1238(e, c));
		}
		
		for (int i = 1; i <= N; i++) {
			totalCost[i] += dijkstra(i, X);
		}
		
		dijkstra(X, -1);
		
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			totalCost[i] += dist[i];
			max = Math.max(max, totalCost[i]);
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static int dijkstra(int start, int end) {
		PriorityQueue<Node_1238> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[start] = 0;
		pq.offer(new Node_1238(start, dist[start]));
		
		while (!pq.isEmpty()) {
			int nowV = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowV] < nowCost) continue;
			
			if (nowV == end) {
				break;
			}
			
			for (Node_1238 nextNode: graph[nowV]) {
				int nextV = nextNode.index;
				int nextCost = nextNode.cost;
				if (dist[nextV] > dist[nowV] + nextCost) {
					dist[nextV] = dist[nowV] + nextCost;
					pq.offer(new Node_1238(nextV, dist[nextV]));
				}
			}
		}
		
		return (end == -1) ? -1 : dist[end];
	}

}
