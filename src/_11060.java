import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 99% 반례: 1 0
public class _11060 {
	static int N;
	static int[] givenArr;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		givenArr = new int[N];
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			givenArr[i] = Integer.parseInt(st.nextToken());
			arr[i] = -1;
		}
		
		bfs(0);
		
		bw.write(arr[N - 1] + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs(int start) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { start, givenArr[start] });
		arr[start] = 0;
		
		while (!queue.isEmpty()) {
			int nowIdx = queue.peek()[0];
			int max = queue.peek()[1];
			queue.poll();
			
			for (int i = max; i > 0; i--) {
				int nextIdx = nowIdx + i;
				if (nextIdx >= N || arr[nextIdx] != -1) continue;
				
				arr[nextIdx] = arr[nowIdx] + 1;
				queue.offer(new int[] { nextIdx, givenArr[nextIdx] });
			}
		}
	}
}
