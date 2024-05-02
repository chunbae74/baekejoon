import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_1753 {
	int nextNode;
	int cost;
	
	// 생성자
	Node_1753(int nextNode, int cost) {
		this.nextNode = nextNode;
		this.cost = cost;
	}
}

/*
 * V: 정점의 개수
 * E: 간선의 개수
 * K: 시작 정점
 */
public class _1753 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		// 그래프 정보를 저장할 배열
		ArrayList[] al = new ArrayList[V + 1];
		// 최단거리를 저장할 배열
		int[] dp = new int[V + 1];
		
		for (int i = 0; i <= V; i++) {
			al[i] = new ArrayList<Node_1753>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			// u -> v; 비용 w
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			al[u].add(new Node_1753(v, w));
		}
		
		
		// 최단거리 배열 초기화
		for (int i = 0; i <= V; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node_1753> pQ = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		// K에서 K까지 가는 경로의 비용은 0임!
		dp[K] = 0;
		pQ.offer(new Node_1753(K, dp[K]));
		
		while (!pQ.isEmpty()) {
			// nowNode까지는 최단거리가 구해짐. (dp[nowNode]값이 존재함)
			int nowNode = pQ.peek().nextNode;
			int nowCost = pQ.peek().cost;
			pQ.poll();
			
			if (dp[nowNode] < nowCost) {
				continue;
			}
			
			// 인접 노드들 update
			for (int i = 0; i < al[nowNode].size(); i++) {
				Node_1753 nextV = (Node_1753) al[nowNode].get(i);
				int nextNode = nextV.nextNode;
				int nextCost = nextV.cost;
				
				// nowCost: 출발지부터 nowNode까지 오는 데 필요한 비용
				// nextCost: nowNode에서 nextNode까지 가는 데 필요한 비용
				if (dp[nextNode] > nowCost + nextCost) {
					dp[nextNode] = nowCost + nextCost;
					pQ.offer(new Node_1753(nextNode, dp[nextNode]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			sb.append((dp[i] == Integer.MAX_VALUE) ? "INF" : dp[i]).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	

}
