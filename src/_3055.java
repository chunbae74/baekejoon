import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * D : 비버의 굴
 * S : 고슴도치의 위치 
 * * : 물. 물은 돌과 비버의 굴에 접근 불가능
 * X : 돌
 */
/*
 * 반례모음: https://www.acmicpc.net/board/view/125622
 */
public class _3055 {
	static boolean isDebug = false;
	static int X, Y;
	static int[][] waterMap;
	static int[][] hedgeMap;
	static boolean[][] waterVisited;
	static boolean[][] hedgeVisited;
	static Queue<int[]> water = new LinkedList<>();
	static Queue<int[]> hedge = new LinkedList<>();
	static int[] destination;
	static boolean clear = false;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
	
		waterMap = new int[Y][X];
		hedgeMap = new int[Y][X];
		waterVisited = new boolean[Y][X];
		hedgeVisited = new boolean[Y][X];
		
		for (int y = 0; y < Y; y++) {
			String s = br.readLine();
			for (int x = 0; x < X; x++) {
				char c = s.charAt(x);
				
				if (c == '*') {
					water.offer(new int[] { x, y });
					waterMap[y][x] = 1;
				} 
				else if (c == 'X') {
					waterMap[y][x] = -1;
					hedgeMap[y][x] = -1;
				}
				else if (c == 'D') {
					waterMap[y][x] = -1;
					destination = new int[] { x, y };
				}
				else if (c == 'S') {
					hedgeMap[y][x] = 1;
					hedge.offer(new int[] { x, y });
				}
			}
		}
		
		waterBfs();
		hedgeBfs();
	
		if (isDebug) {
			System.out.println("water::");
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					System.out.print(waterMap[y][x] + " ");
				}
				System.out.println();
			}
			System.out.println("\n" + "-".repeat(10));
			
			System.out.println("hedge::");
			
			for (int yy = 0; yy < Y; yy++) {
				for (int xx = 0; xx < X; xx++) {
					System.out.print(hedgeMap[yy][xx] + " ");
				}
				System.out.println();
			}
		}
		
		bw.write((clear) ? ((hedgeMap[destination[1]][destination[0]] - 1) + "") : "KAKTUS");
		bw.flush();
		bw.close();
	}

	
	public static void waterBfs() {
		while (!water.isEmpty()) {
			int nowX = water.peek()[0];
			int nowY = water.peek()[1];
			water.poll();
			waterVisited[nowY][nowX] = true;
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) continue;
				if (waterVisited[nextY][nextX] || waterMap[nextY][nextX] == -1) continue;
				
				waterMap[nextY][nextX] = waterMap[nowY][nowX] + 1;
				water.offer(new int[] { nextX, nextY });
				waterVisited[nextY][nextX] = true;
				
			}	
		}
	}
	
	public static void hedgeBfs() {
		while (!hedge.isEmpty()) {
			int nowX = hedge.peek()[0];
			int nowY = hedge.peek()[1];
			hedge.poll();
			hedgeVisited[nowY][nowX] = true;
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) continue;
				if (hedgeVisited[nextY][nextX] || hedgeMap[nextY][nextX] == -1) continue;
				
				hedgeMap[nextY][nextX] = hedgeMap[nowY][nowX] + 1;
				if (nextX == destination[0] && nextY == destination[1]) {
					clear = true;
					return;
				}

				if (waterMap[nextY][nextX] > 0 && (waterMap[nextY][nextX] <= hedgeMap[nowY][nowX] + 1)) continue;
				
				hedgeVisited[nextY][nextX] = true;
				hedge.offer(new int[] { nextX, nextY });
			}
			
			if (isDebug) {				
				for (int yy = 0; yy < Y; yy++) {
					for (int xx = 0; xx < X; xx++) {
						System.out.print(hedgeMap[yy][xx] + " ");
					}
					System.out.println();
				}
				System.out.println();
			System.out.println();
			}
		}
	}
}
