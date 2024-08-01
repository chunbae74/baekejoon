import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13700 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 마포구 건물의 개수
		int N = Integer.parseInt(st.nextToken());
		// 시작지점 (금은방)
		int Start = Integer.parseInt(st.nextToken());
		// 도착지점 (집)
		int End = Integer.parseInt(st.nextToken());
		// 앞으로 달릴 때 이동거리
		int Forward = Integer.parseInt(st.nextToken());
		// 뒤로 달릴 때 이동거리
		int Backward = Integer.parseInt(st.nextToken());
		// 경찰서 수
		int numOfPS = Integer.parseInt(st.nextToken());

		int[] dp = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		if (numOfPS > 0) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < numOfPS; k++) {
				int num = Integer.parseInt(st.nextToken());
				visited[num] = true;
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(Start);
		visited[Start] = true;
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();

			int moveForward = nowNode + Forward;
			if (0 < moveForward && moveForward <= N) {
				if (!visited[moveForward]) {
					visited[moveForward] = true;
					dp[moveForward] = dp[nowNode] + 1;
					queue.offer(moveForward);
				}
			}

			int moveBackward = nowNode - Backward;
			if (0 < moveBackward && moveBackward <= N) {
				if (!visited[moveBackward]) {
					visited[moveBackward] = true;
					dp[moveBackward] = dp[nowNode] + 1;
					queue.offer(moveBackward);
				}
			}
		}

		System.out.println(visited[End] ? dp[End] : "BUG FOUND");
	}
}
