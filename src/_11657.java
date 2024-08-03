import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node_11657 {
	int start;
	int end;
	long cost;

	Node_11657(int start, int end, long cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
}

public class _11657 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final long INF = Long.MAX_VALUE >> 1;

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] dist = new long[N];
		ArrayList<Node_11657> graph = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			dist[i] = INF;
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());
			graph.add(new Node_11657(A, B, C));
		}

		dist[0] = 0;
		for (int round = 0; round < N; round++) {
			for (int m = 0; m < M; m++) {
				int nowNode = graph.get(m).start;
				int nextNode = graph.get(m).end;
				long nextCost = graph.get(m).cost;

				if (dist[nowNode] == INF) continue;
				
				if (dist[nextNode] > dist[nowNode] + nextCost) {
					dist[nextNode] = dist[nowNode] + nextCost;

					// v번째 라운드에서도 값이 갱신된다면 음수 순환이 존재
					if (round == N - 1) {
						System.out.println(-1);
							System.exit(0);
					}
				}
			}
		}

		for (int n = 1; n < N; n++) {
			System.out.println(dist[n] == INF ? -1 : dist[n]);
		}
	}

}
