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
	static int X, Y;
	static char[][] map;
	static boolean[] visited = new boolean[26];
	static int count = 0;
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new char[Y][X];
		for (int y = 0; y < Y; y++) {
			String s = br.readLine();
			for (int x = 0; x < X; x++) {
				map[y][x] = s.charAt(x);
			}
		}
	}

}
