import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16234 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int[] dx = { 0, 0, 1, -1 };
		final int[] dy = { 1, -1, 0, 0 };
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		// L명 이상
		int L = Integer.parseInt(st.nextToken());
		// R명 이하
		int R = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		boolean[][] isOpen = new boolean[N][N];
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		boolean isClear = true;
		while (true) {
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					
				}
			}
		}
		
	}

}
