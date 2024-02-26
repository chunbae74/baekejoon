import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N: 수빈이의 위치
 * K: 동생의 위치
 */
public class _12851 {
	static int N, K;
	static int[] arr = new int[100_000 + 1];
	static boolean[] visited = new boolean[100_000 + 1];

	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs();
		
		bw.write(arr[K] + "\n" + count);
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
			
			for (int i = 0; i < 3; i++) {
				switch (i) {
				case 0:
					next = cor * 2;
					break;
					
				case 1:
					next = cor + 1;
					break;
					
				case 2:
					next = cor - 1;
				}
				
				if (next < 0 || next > 100_000) continue;
				
				if (next == K) {
					if (arr[cor] + 1 == arr[K]) count ++;
				}
				
				// if (visited[next]) continue;
				
				if (arr[next] == 0) arr[next] = arr[cor] + 1;
				else arr[next] = Math.min(arr[next], arr[cor] + 1);

				queue.offer(next);
				visited[next] = true;
			}
		}
	}

}
