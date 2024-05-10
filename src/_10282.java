import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_10282 {
	int index;
	int cost;
	
	Node_10282(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

/*
 * a가 b를 의존한다 -> b가 감염되면 일정 시간 뒤 a도 감염된다
 * a b s; a가 b를 의존한다는 뜻.
 */
public class _10282 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		// 테스트케이스 개수
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Node_10282> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int START = Integer.parseInt(st.nextToken());
			
			ArrayList<Node_10282>[] graph = new ArrayList[n + 1];
			int[] dist = new int[n + 1];
			
			for (int i = 0; i <= n; i++) {
				dist[i] = Integer.MAX_VALUE;
				graph[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				graph[b].add(new Node_10282(a, s));
			}
			
			dist[START] = 0;
			pq.offer(new Node_10282(START, dist[START]));
			while (!pq.isEmpty()) {
				int nowV = pq.peek().index;
				int nowCost = pq.peek().cost;
				pq.poll();
				
				if (dist[nowV] < nowCost) continue;
				
				for (Node_10282 nextNode: graph[nowV]) {
					int nextV = nextNode.index;
					int nextCost = nextNode.cost;
					if (dist[nextV] > dist[nowV] + nextCost) {
						dist[nextV] = dist[nowV] + nextCost;
						pq.offer(new Node_10282(nextV, dist[nextV]));
					}
				}
			}
			
			int max = 0;
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (dist[i] == Integer.MAX_VALUE) continue;
				count ++;
				max = Math.max(max, dist[i]);
			}
			
			sb.append(count).append(" ").append(max);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
