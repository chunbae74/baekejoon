import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * a b c d e f (-999 ~ 999)
 * ax + by = c
 * dx + ey = f
 * (x, y) 유일하게 존재.
 */
public class _19532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int x = 0, y = 0;
		if (a*e - d*b != 0 && b != 0) { // 0으로 나뉘지 않는 경우
			x = (c*e - f*b) / (a*e - d*b);
			y = (c - a*x) / b;
		} else {
			if (b == 0) {
				x = c / a;
				y = (f - d*x) / e;
			} else; // a*e = d*b인 경우. 그러나 x, y가 하나밖에 없으므로 존재할 수 없는 경우임.
		}
		bw.write(x + " " + y);
		bw.flush();
		bw.close();
	}	

}
