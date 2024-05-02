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
		ArrayList<Node_1753>[] al = new ArrayList[V + 1];
		// 최단거리를 저장할 배열
		int[] dp = new int[V + 1];
		// 방문여부
		boolean[] visited = new boolean[V + 1];
		
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
			int nowNode = pQ.peek().nextNode;
			pQ.poll();

			// 이미 방문했으면 건너뛰기
			if (visited[nowNode]) {
				continue;
			}

			// 지금 노드 방문처리 해주기
			visited[nowNode] = true;
			
			// 인접 노드들 update
			for (Node_1753 nextV: al[nowNode]) {
				int nextNode = nextV.nextNode;
				// nowNode에서 nextNode까지 가는 데 필요한 비용
				int nextCost = nextV.cost;
				
				// 기존에 저장된 출발지->nextNode 비용보다
				// 출발지->nowNode + nowNode->nextNode 비용이 더 적다면
				if (dp[nextNode] > dp[nowNode] + nextCost) {
					dp[nextNode] = dp[nowNode] + nextCost;
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
