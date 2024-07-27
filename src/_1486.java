import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1486 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int INF = Integer.MAX_VALUE >> 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		// 높이차이가 T보다 크지 않은 곳으로만 다닐 수 있다.
		int T = Integer.parseInt(st.nextToken());
		// 제한시간
		int D = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[Y][X];
		int[][] distStartFromHotel = new int[Y][X];
		int[][] distEndAtHotel = new int[Y][X];
		
		for (int y = 0; y < Y; y++) {
			String input = br.readLine();
			for (int x = 0; x < X; x++) {
				distStartFromHotel[y][x] = distEndAtHotel[y][x] = INF;
				char c = input.charAt(x);
				if ('a' <= c && c <= 'z') {
					graph[y][x] = c - 'a' + 26;
				} else if ('A' <= c && c <= 'Z') {
					graph[y][x] = c - 'A';
				}
			}
		}
		
		
	}

}
