import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7562 {
	static boolean isDebug = false;
	static int N;
	static int[] nowCor;
	static int[] targetCor;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			nowCor = new int[2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			nowCor[0] = Integer.parseInt(st.nextToken());
			nowCor[1] = Integer.parseInt(st.nextToken());

			targetCor = new int[2];
			st = new StringTokenizer(br.readLine());
			targetCor[0] = Integer.parseInt(st.nextToken());
			targetCor[1] = Integer.parseInt(st.nextToken());
			
			bfs();
			
			sb.append(map[targetCor[1]][targetCor[0]] + "\n");
		} // 테스트 케이스 끝
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { nowCor[0], nowCor[1] });
		visited[nowCor[1]][nowCor[0]] = true;
		
		while (!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.peek()[1];
			queue.poll();
			
			for (int i = 0; i < 8; i ++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				if (visited[nextY][nextX]) continue;
				
				map[nextY][nextX] = map[y][x] + 1;
				visited[nextY][nextX] = true;
				queue.offer(new int[] { nextX, nextY });
				
				// 도착지점 도달
				if (nextX == targetCor[0] && nextY == targetCor[1]) {
					return;
				}
			}
			
			if (isDebug) {
				System.out.println();
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println("-".repeat(15));
			}
		}
	}

}
