import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * K: 사각형의 개수
 * 왼쪽 아래 꼭짓점(x, y)와 오른쪽 위 꼭짓점(x, y)가 차례로 주어진다.
 */
public class _2583 {
	static int X, Y, K;
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
		K = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		visited = new boolean[Y][X];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x0 = Integer.parseInt(st.nextToken());
			int y0 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			for (int y = y0; y < y1; y++) {
				for (int x = x0; x < x1; x++) {
					map[y][x] = -1;
				}
			}
		}
		
		int sectionNum = 0;
		ArrayList<Integer> al = new ArrayList<>();
		
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (map[y][x] == -1 || visited[y][x]) continue;
				sectionNum ++;
				int area = bfs(x, y);
				al.add(area);
			}
		}
		
		Collections.sort(al);
		bw.write(sectionNum + "\n");
		for (int n: al) {
			bw.write(n + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	
	public static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[y][x] = true;
		
		int area = 1;
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) continue;
				if (visited[nextY][nextX] || map[nextY][nextX] == -1) continue;
				
				area ++;
				visited[nextY][nextX] = true;
				queue.offer(new int[] { nextX, nextY });
			}
		}
		
		return area;
	}
}
