import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1520 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int[] dx = new int[] { 0, 0, 1, -1 };
		final int[] dy = new int[] { 1, -1, 0, 0 };
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[][] map = new int[Y][X];
		
		for (int y = 0; y < Y; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < X; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		// { x, y }
		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] { 0, 0});
		int ans = 0;
		while (!stack.isEmpty()) {
			int nowX = stack.peek()[0];
			int nowY = stack.peek()[1];
			stack.pop();
			
			if (nowX == X - 1 && nowY == Y - 1) {
				ans ++;
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if (0 > nextX || nextX >= X || 0 > nextY || nextY >= Y) continue;
				
				if (map[nextY][nextX] < map[nowY][nowX]) {
					stack.add(new int[] { nextX, nextY });
				}
			}
		}
		
		System.out.println(ans);
	}

}
