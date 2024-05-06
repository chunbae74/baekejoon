import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_1504 {
	int index;
	int cost;
	
	Node_1504(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}
/*
 * N: 정점의 개수
 * E: 간선의 개수
 * v1, v2: 반드시 지나야 하는 정점
 */
/*
 * case1) 1 -> v1 -> v2 -> N
 * case2) 1 -> v2 -> v1 -> N
 */
public class _1504 {
	static int N, E;
	static int[] dist;
	static int[] result;
	static boolean[] isNotPossible = new boolean[2];
	static ArrayList<Node_1504>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		dist = new int[N + 1];
		result = new int[2];
		
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[s].add(new Node_1504(e, c));
			graph[e].add(new Node_1504(s, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// Case1) "1 -> v1" -> v2 -> N
		result[0] += dijkstra(1, v1, 0);
		
		// Case1) 1 -> "v1 -> v2" -> N
		if (!isNotPossible[0]) result[0] += dijkstra(v1, v2, 0);
		
		// Case1) 1 -> v1 -> "v2 -> N"
		if (!isNotPossible[0]) result[0] += dijkstra(v2, N, 0);

		
		// Case2) "1 -> v2" -> v1 -> N
		result[1] += dijkstra(1, v2, 1);
		
		// Case2) 1 -> "v2 -> v1" -> N
		if (!isNotPossible[1]) result[1] += dijkstra(v2, v1, 1);
		
		// Case2) 1 -> v2 -> "v1 -> N"
		if (!isNotPossible[1]) result[1] += dijkstra(v1, N, 1);
		
		// print
		if (isNotPossible[0] && isNotPossible[1]) {
			bw.write("-1");
		} else if (isNotPossible[0]) {
			bw.write(result[1] + "");
		} else if (isNotPossible[1]) {
			bw.write(result[0] + "");
		} else {
			bw.write(Math.min(result[0], result[1]) + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int dijkstra(int start, int end, int type) {
		PriorityQueue<Node_1504> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		pq.offer(new Node_1504(start, dist[start]));
		while (!pq.isEmpty()) {
			int nowV = pq.peek().index;
			int nowC = pq.peek().cost;
			pq.poll();
			
			if (dist[nowV] < nowC) continue;
			
			if (nowV == end) {
				break;
			}
			
			for (Node_1504 nextNode: graph[nowV]) {
				int nextV = nextNode.index;
				if (dist[nextV] > dist[nowV] + nextNode.cost) {
					dist[nextV] = dist[nowV] + nextNode.cost;
					pq.offer(new Node_1504(nextV, dist[nextV]));
				}
			}
		}
		
		if (dist[end] == Integer.MAX_VALUE) {
			isNotPossible[type] = true;
			return -1;
		}
		else return Math.max(0, dist[end]);
	}
}
