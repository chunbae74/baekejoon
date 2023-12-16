/**
 * 한수의 현재위치 (x, y)
 * 왼쪽 아래 꼭짓점 (0, 0)
 * 오른쪽 위 꼭짓점 (w, h)
 * x y w h
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int x_min = Math.min(Math.abs(x - w), x);
		int y_min = Math.min(Math.abs(y - h), y);
		bw.write(Math.min(x_min, y_min) + "");
		bw.flush();
		bw.close();
	}
}
