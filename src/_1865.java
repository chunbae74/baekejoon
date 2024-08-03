import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node_1865 {
	int start;
	int end;
	int cost;

	Node_1865(int start, int end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

/*
 * 시작점 관련 참고ㅣ https://www.acmicpc.net/board/view/72995
 */
public class _1865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final long INF = Long.MAX_VALUE >> 1;

		int T = Integer.parseInt(br.readLine());
		Loop1: for (int t = 0; t < T; t++) {
			ArrayList<Node_1865> graph = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			long[] dist = new long[N + 1];

			/*
			 * 도로 방향이 없고, 비용이 0 이상이다.
			 */
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()) - 1;
				int B = Integer.parseInt(st.nextToken()) - 1;
				int C = Integer.parseInt(st.nextToken());
				graph.add(new Node_1865(A, B, C));
				graph.add(new Node_1865(B, A, C));
			}

			/*
			 * 웜홀 방향이 있고, 비용이 0 이하이다.
			 */
			for (int w = 0; w < W; w++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken()) - 1;
				int B = Integer.parseInt(st.nextToken()) - 1;
				int C = -1 * Integer.parseInt(st.nextToken());
				graph.add(new Node_1865(A, B, C));
			}

			for (int round = 0; round < N; round++) {
				for (int m = 0; m < graph.size(); m++) {
					int nowNode = graph.get(m).start;
					int nextNode = graph.get(m).end;
					long nextCost = graph.get(m).cost;

					if (dist[nowNode] == INF)
						continue;
					if (dist[nextNode] > dist[nowNode] + nextCost) {
						dist[nextNode] = dist[nowNode] + nextCost;

						if (round == N - 1) {
							System.out.println("YES");
							continue Loop1;
						}
					}
				}
			}
			System.out.println("NO");
		}
	}

}
