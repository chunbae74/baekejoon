import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _3010 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> queue = new LinkedList<>();
		
		final int size = 7;
		final int[] dx1 = { 0, 0, 1, -1 };
		final int[] dy1 = { 1, -1, 0, 0 };
		final int[] dx2 = { 0, 0, 2, -2 };
		final int[] dy2 = { 2, -2, 0, 0 };
		
		/*
		 * o : 1
		 * . : 2
		 */
		int[][] map = new int[size][size];
		for (int y = 0; y < size; y++) {
			String input = br.readLine();
			for (int x = 0; x < size; x++) {
				char c = input.charAt(x);
				if (c == 'o') {
					map[y][x] = 1;
				} else if (c == '.') {
					map[y][x] = 2;
					queue.offer(new int[] { x, y });
				}
			}
		}
		
		int count = 0;
		while (!queue.isEmpty()) {
			int nowX = queue.peek()[0];
			int nowY = queue.peek()[1];
			queue.poll();
			
			for (int i = 0; i < dx1.length; i++) {
				int nextX1 = nowX + dx1[i];
				int nextY1 = nowY + dy1[i];
				int nextX2 = nowX + dx2[i];
				int nextY2 = nowY + dy2[i];
				
				if (0 > nextX1 || nextX1 >= size || 0 > nextY1 || nextY1 >= size) continue;
				if (0 > nextX2 || nextX2 >= size || 0 > nextY2 || nextY2 >= size) continue;
				
				if (map[nextY1][nextX1] == 1 && map[nextY2][nextX2] == 1) {
					count ++;
				}
			}
		}
		
		System.out.println(count);
	}

}
