import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _9063 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x_min, x_max, y_min, y_max = 0;
		x_min = x_max = Integer.parseInt(st.nextToken());
		y_min = y_max = Integer.parseInt(st.nextToken());
		int x, y;
		for (int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if (x_max < x) x_max = x;
			else if (x_min > x) x_min = x;
			if (y_max < y) y_max = y;
			else if(y_min > y) y_min = y;
		}
		int len = x_max - x_min;
		int width = y_max - y_min;
		bw.write((len * width) + "");
		bw.flush();
		bw.close();
	}
}
