import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N: 수빈이의 위치
 * K: 동생의 위치
 * 순간이동: 2*X; 0초
 * 걷기: X - 1, X + 1; 1초
 */
public class _13549 {
	static int N, K;
	static int[] arr = new int[200_000 + 1];
	static boolean[] visited = new boolean[200_000 + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		
		// System.out.println(Arrays.toString(arr));
		bw.write(arr[K] + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		visited[N] = true;
		
		while (!queue.isEmpty()) {
			int cor = queue.poll();
			int next = 0;
			if (cor != 0) {				
				for (int j = cor; j <= 200_000; j *= 2) {
					if (visited[j]) continue;
					arr[j] = arr[cor];
					queue.offer(j);
					visited[j] = true;
					
					if (j == K) return;
				}
			}		
			for (int i = 0; i < 2; i++) {
				switch (i) {					
				case 0:
					next = cor + 1;
					break;
					
				case 1:
					next = cor - 1;
				}
				

				if (next < 0 || next > 200_000) continue;
				if (visited[next]) continue;
				
				arr[next] = arr[cor] + 1;

				if (next != 0) {				
					for (int j = next; j <= 200_000; j *= 2) {
						if (visited[j]) continue;
						arr[j] = arr[next];
						queue.offer(j);
						visited[j] = true;
						
						if (j == K) return;
					}
				}

				queue.offer(next);
				visited[next] = true;
				
				if (next == K) return;
			}
		}
	}

}
