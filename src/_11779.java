import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_11779 {
	int index;
	int cost;
	
	Node_11779(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class _11779 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Node_11779>[] graph = new ArrayList[N + 1];
		ArrayList<Integer>[] record = new ArrayList[N + 1];
		int[] dist = new int[N + 1];
	
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			record[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[s].add(new Node_11779(e, c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int START = Integer.parseInt(st.nextToken());
		int END = Integer.parseInt(st.nextToken());
		
		dist[START] = 0;
		record[START].add(START);
		PriorityQueue<Node_11779> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		pq.offer(new Node_11779(START, dist[START]));
		
		while (!pq.isEmpty()) {
			int nowV = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (dist[nowV] < nowCost) continue;
			
			if (nowV == END) break;
			
			for (Node_11779 nextNode: graph[nowV]) {
				int nextV = nextNode.index;
				int nextCost = nextNode.cost;
				if (dist[nextV] > dist[nowV] + nextCost) {
					dist[nextV] = dist[nowV] + nextCost;
					pq.offer(new Node_11779(nextV, dist[nextV]));
					
					record[nextV] = new ArrayList<>();
					for (int num: record[nowV]) {
						record[nextV].add(num);
					}
					record[nextV].add(nextV);
				}
			}
		}
		
		sb.append(dist[END]).append("\n");
		sb.append(record[END].size()).append("\n");
		for (int num: record[END]) {
			sb.append(num).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
