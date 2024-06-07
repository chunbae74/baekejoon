import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_14284 {
	int index;
	int cost;
	
	Node_14284(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _14284 {
	static int N, M;
	static int START, END;
	static final int INF = 5000 * 100000 + 1;
	static ArrayList<Node_14284>[] graph; 
	static int[] dist; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		dist = new int[N + 1];
		String[] input = new String[M];
		
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}
		
		for (int i = 0; i < M; i++) {
			input[i] = br.readLine();
		}
		
		st = new StringTokenizer(br.readLine());
		START = Integer.parseInt(st.nextToken());
		END = Integer.parseInt(st.nextToken());
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(input[i]);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			graph[A].add(new Node_14284(B, C));
			graph[B].add(new Node_14284(A, C));
			dijkstra();
			min = Math.min(min, dist[END]);
		}
		
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	public static void dijkstra() {
//		for (int i = 1; i <= N; i++) {
//			dist[i] = INF;
//		}
		
		PriorityQueue<Node_14284> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		dist[START] = 0;
		pq.offer(new Node_14284(START, dist[START]));
		
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowNode] < nowCost) continue;
			
			for (Node_14284 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;
					pq.offer(new Node_14284(nextNode, dist[nextNode]));
				}
			}
		}
	}
}
