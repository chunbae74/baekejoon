import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1926 {
	static int X, Y;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		visited = new boolean[Y][X];
		
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		int picNum = 0;
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (visited[y][x] || map[y][x] == 0) continue;
				int num = bfs(x, y);
				result = Math.max(result, num);
				picNum ++;
			}
		}
		
		bw.write(picNum + "\n" + result);
		bw.flush();
		bw.close();
	}

	public static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[y][x] = true;
		int count = 1;
		
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) continue;
				if (visited[nextY][nextX] || map[nextY][nextX] == 0) continue;
				
				count ++;
				visited[nextY][nextX] = true;
				queue.offer(new int[] { nextX, nextY });
			}
		}
		
		return count;
	}
}
