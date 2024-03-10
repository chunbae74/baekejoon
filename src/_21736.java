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
 * -1: 벽
 * 0: 빈공간
 * 1: 사람
 * 2: 도연이
 */
public class _21736 {
	static int X, Y;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	
	// 도연이의 위치
	static int[] start;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[Y][X];
		visited = new boolean[Y][X];
		
		for (int y = 0; y < Y; y++) {
			String s = br.readLine();
			for (int x = 0; x < X; x++) {
				char c = s.charAt(x);
				if (c == 'X') map[y][x] = -1;
				else if (c == 'O') map[y][x] = 0;
				else if (c == 'P') map[y][x] = 1;
				else if (c == 'I') {
					map [y][x] = 2;
					start = new int[] { x, y };
				}
			}
		}
		
		bfs();
		
		bw.write((count == 0) ? "TT" : (count + ""));
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		visited[start[1]][start[0]] = true;
		
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				// 범위를 넘어선다면
				if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) continue;
				// 이미 방문했다면
				if (visited[nextY][nextX]) continue;
				// 벽에 막혀 지나갈 수 없다면
				if (map[nextY][nextX] == -1) continue;
				
				// 사람이라면
				if (map[nextY][nextX] == 1) count ++;
				visited[nextY][nextX] = true;
				queue.offer(new int[] { nextX, nextY });
			}
		}
	}

}
