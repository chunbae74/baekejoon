import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * //입력
 * 0: 갈 수 없는 땅
 * 1: 갈 수 있는 땅
 * 2: 목표지점
 * 
 * //출력
 * 0: 원래 갈 수 없는 땅
 * 원래 갈 수 있으나 도달할 수 없는 땅
 */
public class _14940 {
	static int X, Y;
	static int[][] arr;
	static int[][] givenArr;
	static int[] start;
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		arr = new int[Y][X];
		givenArr = new int[Y][X];
		
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				givenArr[y][x] = Integer.parseInt(st.nextToken());
				arr[y][x] = -1;
				
				// 출발지점
				if (givenArr[y][x] == 2) {
					start = new int[] { x, y, 0 };
					arr[y][x] = 0;
				}
			}
		}
		
		bfs();
		
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				int num = arr[y][x];
				if (num == -1) {
					if (givenArr[y][x] == 0) bw.write("0 ");
					else bw.write("-1 ");
				}
				else {
					bw.write(arr[y][x] + " ");
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			int count = queue.peek()[2];
			queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				// 지도의 범위를 벗어난 땅
				if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) continue;
				// 처음부터 갈 수 없는 땅
				if (givenArr[nextY][nextX] == 0) continue;
				// 이미 방문한 땅
				if (arr[nextY][nextX] != -1) continue;
				
				queue.offer(new int[] { nextX, nextY, count + 1 });
				arr[nextY][nextX] = count + 1;
			}
		}
	}

}
