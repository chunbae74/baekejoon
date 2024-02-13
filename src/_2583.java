import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * K: 사각형의 개수
 * 왼쪽 아래 꼭짓점(x, y)와 오른쪽 위 꼭짓점(x, y)가 차례로 주어진다.
 */
public class _2583 {
	static int X, Y, K;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[Y][X];
		visited = new boolean[Y][X];
		for (int i = 0; i < K; i++) {
			
		}
	}

}
