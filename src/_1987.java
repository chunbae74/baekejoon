import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 세로 Y / 가로 X
 */
public class _1987 {
	static boolean isDebug = false;
	static int X, Y;
	static int[][] map;
	static boolean[] visited = new boolean[26];
	static int result = 0;
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			String s = br.readLine();
			for (int x = 0; x < X; x++) {
				map[y][x] = s.charAt(x) - 'A';
			}
		}
		
		visited[map[0][0]] = true;
		dfs(0, 0, 1);
		
		bw.write(result + "");
		bw.flush();
		bw.close();
	}
	
	
	public static void dfs(int x, int y, int count) {
		
		result = Math.max(result, count);
		
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) continue;
			int nextC = map[nextY][nextX];
			// 이미 지나간 알파벳
			if (visited[nextC]) continue;
			
			visited[nextC] = true;
			dfs(nextX, nextY, count + 1);
			visited[nextC] = false;
		}
		
		if (isDebug) {
			for (int i = 0; i < 26; i++) {
				if (visited[i]) {
					System.out.print((char) (i + 'A') + " ");
				}
			}
			System.out.println();
		}
		return;
	}

}
