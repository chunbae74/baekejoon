import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * arr[H][Y][X]
 * 1: 익은 토마토
 * 0: 익지 않은 토마토
 * -1: 토마토가 들어있지 않은 칸
 */
public class _7569 {
	static boolean isDebug = false;
	static int X, Y, H;
	static int[][][] arr;
	static boolean[][][] visited;
	static Queue<int[]> queue = new LinkedList<>();
	
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dy = { -1, 0, 1, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][Y][X];
		visited = new boolean[H][Y][X];
		
		int zeroNum = 0;
		for (int h = 0; h < H; h++) {
			for (int y = 0; y < Y; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < X; x++) {
					arr[h][y][x] = Integer.parseInt(st.nextToken());
					if (arr[h][y][x] == 0) zeroNum ++;
					else if (arr[h][y][x] == 1) queue.offer(new int[] { x, y, h });
				}
			}
		}
		
		if (zeroNum == 0) {
			System.out.println("0");
			System.exit(0);
		}
		
		bfs();
		
		if (isDebug) {
			for (int h = 0; h < H; h++) {
				for (int y = 0; y < Y; y++) {
					for (int x = 0; x < X; x++) {
						System.out.print(arr[h][y][x] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			System.out.println("-".repeat(15));
		}
			
		boolean isClear = true;
		int maxValue = 0;
		Loop1: for (int h = 0; h < H; h++) {
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					// 아직 안익은 토마토가 있다면
					if (arr[h][y][x] == 0) {
						isClear = false;
						break Loop1;
					}
					else if (arr[h][y][x] > 0) {
						maxValue = Math.max(maxValue, arr[h][y][x]);
					}
				}
			}
		}
		
		bw.write(isClear ? (maxValue - 1 + "") : "-1");
		bw.flush();
		bw.close();
	}
	
	
	public static void bfs() {
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
				if (visited[nextH][nextY][nextX] || arr[nextH][nextY][nextX] != 0) continue;
				
				arr[nextH][nextY][nextX] = arr[nowH][nowY][nowX] + 1;
				queue.offer(new int[] { nextX, nextY, nextH });
			}
		}
	}

}
