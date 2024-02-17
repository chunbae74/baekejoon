import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * H, Y, X
 * S : 시작지점
 * E : 출구
 * # : 지나갈 수 없음
 * . : 비어있는 칸
 */
public class _6593 {
	static boolean isDebug = false;
	static int X, Y, H;
	static int[][][] building;
	static boolean[][][] visited;
	static int[] cor;
	static int[] destination;
	
	static int[] dx = { 0, 0, 1, -1, 0, 0};
	static int[] dy = { 1, -1, 0, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			// 테스트케이스 끝
			if (X == 0 && Y == 0 && H == 0) break;
			
			building = new int[H][Y][X];
			visited = new boolean[H][Y][X];
			
			for (int h = 0; h < H; h++) {
				for (int y = 0; y < Y; y++) {
					String s = br.readLine();
					for (int x = 0; x < X; x++) {
						char c = s.charAt(x);
						
						if (c == 'S') {
							cor = new int[] { x, y, h };
							building[h][y][x] = 1;
						}
						else if (c == '.') {
							building[h][y][x] = 0;
						}
						else if (c == '#') {
							building[h][y][x] = -1;
						}
						else if (c == 'E') {
							destination = new int[] { x, y, h };
							building[h][y][x] = -2;
						}
					}
				}
				// 각 층 사이에는 빈 줄이 있음
				br.readLine();
			} // for문 끝
			
			bfs();
			
			if (isDebug) {
				for (int h = 0; h < H; h++) {
					for (int y = 0; y < Y; y++) {
						for (int x = 0; x < X; x++) {
							System.out.print(building[h][y][x] + " ");
						}
						System.out.println();
					}
					System.out.println();
				}
			}
			
			int result = building[destination[2]][destination[1]][destination[0]];
			if (result == -2) {
				sb.append("Trapped!").append("\n");
			}
			else {
				sb.append("Escaped in ").append(result - 1).append(" minute(s).\n");
			}
			
		} // 테스트케이스 끝
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(cor);
		visited[cor[2]][cor[1]][cor[0]] = true;
		
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			int nowH = queue.peek()[2];
			queue.poll();
			
			for (int i = 0; i < 6; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				int nextH = nowH + dh[i];
				
				if (nextX < 0 || nextY < 0 || nextH < 0 || nextX >= X || nextY >= Y || nextH >= H) continue;
				if (visited[nextH][nextY][nextX] || building[nextH][nextY][nextX] == -1) continue;
				
				building[nextH][nextY][nextX] = building[nowH][nowY][nowX] + 1;
				if (nextX == destination[0] && nextY == destination[1] && nextH == destination[2]) {
					return;
				}	
				
				visited[nextH][nextY][nextX] = true;
				queue.offer(new int[] { nextX, nextY, nextH });
			}
			
			/*
			if (isDebug) {
				for (int h = 0; h < H; h++) {
					for (int y = 0; y < Y; y++) {
						for (int x = 0; x < X; x++) {
							System.out.print(building[h][y][x] + " ");
						}
						System.out.println();
					}
					System.out.println();
				}
			}
			*/
		}
	}

}
