import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14248 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] dist = new int[N];
		boolean[] visited = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		
		int START = Integer.parseInt(br.readLine()) - 1;
		
		// bfs
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(START);
		int count = 0;
		while (!queue.isEmpty()) {
			int num = queue.poll();
			
			if (visited[num]) continue;
			
			count ++;
			visited[num] = true;
			int left = num - dist[num];
			int right = num + dist[num];
			
			if (0 <= left && left < N) queue.offer(left);
			if (0 <= right && right < N) queue.offer(right);
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
