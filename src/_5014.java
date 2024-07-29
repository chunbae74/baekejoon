import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 반례ㅣ
 * https://www.acmicpc.net/board/view/104055
 */
public class _5014 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int START = Integer.parseInt(st.nextToken()) - 1;
		int END = Integer.parseInt(st.nextToken()) - 1;
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] dp = new int[F];
		boolean[] visited = new boolean[F];
		
		dp[START] = 0;
		visited[START] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(START);
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			
			if (nowNode == END) break;
			
			int nextUpNode = nowNode + U;
			if (nextUpNode < F && !visited[nextUpNode]) {
				visited[nextUpNode] = true;
				dp[nextUpNode] = dp[nowNode] + 1;
				queue.offer(nextUpNode);
			}
			
			int nextDownNode = nowNode - D;
			if (nextDownNode >= 0 && !visited[nextDownNode]) {
				visited[nextDownNode] = true;
				dp[nextDownNode] = dp[nowNode] + 1;
				queue.offer(nextDownNode);
			}
		}
		
		System.out.println(visited[END] ? dp[END] : "use the stairs");
	}

}
