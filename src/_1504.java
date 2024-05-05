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
	static boolean[] visited;
	static int[] result;
	static ArrayList<Node_1504>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		result = new int[2];
		
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[s].add(new Node_1504(e, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// Case1) "1 -> v1" -> v2 -> N
		PriorityQueue<Node_1504> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[1] = 0;
		pq.offer(new Node_1504(1, dist[1]));
		while (!pq.isEmpty()) {
			int nowV = pq.peek().index;
			int nowC = pq.peek().cost;
			pq.poll();
			
			if (dist[nowV] < nowC) continue;
			
			if (nowV == v1) {
				result[0] += dist[nowV];
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
		
		// Case1) 1 -> "v1 -> v2" -> N
		pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[v1] = 0;
		pq.offer(new Node_1504(v1, dist[v1]));
		while (!pq.isEmpty()) {
			int nowV = pq.peek().index;
			int nowC = pq.peek().cost;
			pq.poll();
			
			if (dist[nowV] < nowC) continue;
			
			if (nowV == v2) {
				result[0] += dist[nowV];
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
		
		// Case1) 1 -> v1 -> "v2 -> N"
		pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[v2] = 0;
		pq.offer(new Node_1504(v2, dist[v2]));
		while (!pq.isEmpty()) {
			int nowV = pq.peek().index;
			int nowC = pq.peek().cost;
			pq.poll();
			
			if (dist[nowV] < nowC) continue;
			
			if (nowV == N) {
				result[0] += dist[nowV];
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
		
		// Case2) "1 -> v2" -> v1 -> N
		pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));dist[1] = 0;
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[1] = 0;
		pq.offer(new Node_1504(1, dist[1]));
		while (!pq.isEmpty()) {
			int nowV = pq.peek().index;
			int nowC = pq.peek().cost;
			pq.poll();
			
			if (dist[nowV] < nowC) continue;
			
			if (nowV == v2) {
				result[1] += dist[nowV];
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
		
		// Case2) 1 -> "v2 -> v1" -> N
		pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[v2] = 0;
		pq.offer(new Node_1504(v2, dist[v2]));
		while (!pq.isEmpty()) {
			int nowV = pq.peek().index;
			int nowC = pq.peek().cost;
			pq.poll();
			
			if (dist[nowV] < nowC) continue;
			
			if (nowV == v1) {
				result[1] += dist[nowV];
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
		
		// Case2) 1 -> v2 -> "v1 -> N"
		pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[v1] = 0;
		pq.offer(new Node_1504(v1, dist[v1]));
		while (!pq.isEmpty()) {
			int nowV = pq.peek().index;
			int nowC = pq.peek().cost;
			pq.poll();
			
			if (dist[nowV] < nowC) continue;
			
			if (nowV == N) {
				result[1] += dist[nowV];
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

		if (result[0] == 0 && result[1] == 0) {
			bw.write("-1");
		} else {
			int n1 = Math.min(result[0], result[1]);
			int n2 = Math.max(result[0], result[1]);
			if (n1 == 0) bw.write(n2 + "");
			else bw.write(n1 + "");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dijkstra(int start, int end) {
		PriorityQueue<Node_1504> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		for (int i = 0; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[start] = 0;
		pq.offer(new Node_1504(start, dist[start]));
		while (!pq.isEmpty()) {
			int nowV = pq.poll().index;
			
			if (visited[nowV]) continue;
			
			if (nowV == N) {
				break;
			}
			
			visited[nowV] = true;
			for (Node_1504 nextNode: graph[nowV]) {
				int nextV = nextNode.index;
				if (dist[nextV] > dist[nowV] + nextNode.cost) {
					dist[nextV] = dist[nowV] + nextNode.cost;
					pq.offer(new Node_1504(nextV, dist[nextV]));
				}
			}
		}
	}
}
