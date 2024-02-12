import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 반례모음 : https://www.acmicpc.net/board/view/128490
 */
public class _10026 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for (int y = 0; y < N; y++) {
			String s = br.readLine();
			for (int x = 0; x < N; x++) {
				map[y][x] = s.charAt(x);
			}
		}
		
		int count = 0;
		visited = new boolean[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (visited[y][x]) continue;
				bfs(x, y, true);
				count ++;
			}
		}
		bw.write(count + " ");
		
		count = 0;
		visited = new boolean[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (visited[y][x]) continue;
				bfs(x, y, false);
				count ++;
			}
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

	
	/*
	 * isOkay: true -> 적록색약 x
	 */
	public static void bfs(int x, int y, boolean isOkay) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[y][x] = true;
		char c = map[y][x];
		
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
				if (visited[nextY][nextX]) continue;
				// 정상인의 경우
				if (isOkay) {
					if (map[nextY][nextX] != c) continue;
				// 적록색약의 경우
				} else {
					if (map[nextY][nextX] == 'R' && c == 'G' || map[nextY][nextX] == 'G' && c == 'R') {
					}
					else if (map[nextY][nextX] != c) continue;
				}
				
				visited[nextY][nextX] = true;
				queue.offer(new int[] { nextX, nextY });
			}
		}
		
	}
}
