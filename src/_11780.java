import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _11780 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		final long INF = 10_000_000_000L;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		long[][] dist = new long[N][N];
		int[][] preIdx = new int[N][N];
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				else dist[i][j] = INF;
				
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			dist[a][b] = c;
			preIdx[a][b] = a;
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						preIdx[i][j] = k;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(preIdx[i][j]+ 1 + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 시작도시와 도착도시가 같은 경우는 없으므로.
				if (i == j) sb.append("0\n");
				else {
					int end = j;
					Stack<Integer> stack = new Stack<>();
					stack.add(end + 1);
					while (true) {
						if (end == i) break;
						stack.add(preIdx[i][end] + 1);
						end = preIdx[i][end];
					}
					sb.append(stack.size()).append(" ");
					while (!stack.isEmpty()) {
						sb.append(stack.pop()).append(" ");
					}
					sb.append("\n");
				}
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
