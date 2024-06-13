import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _20493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int x = 0;
		int y = 0;
		// 0: 상 / 1: 하 / 2: 좌 / 3: 우
		int direct = 3;
		int preT = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int nowT = Integer.parseInt(st.nextToken());
			String s = st.nextToken();

			// 이전까지 온 길 갱신
			if (direct == 0) {
				y += (nowT - preT);
			} else if (direct == 1) {
				y -= (nowT - preT);
			} else if (direct == 2) {
				x -= (nowT - preT);
			} else if (direct == 3) {
				x += (nowT - preT);
			}
			
			preT = nowT;
			// 방향 갱신
			if (s.equals("right")) {
				if (direct == 0) direct = 3;
				else if (direct == 1) direct = 2;
				else if (direct == 2) direct = 0;
				else if (direct == 3) direct = 1;
			} else if (s.equals("left")) {
				if (direct == 0) direct = 2;
				else if (direct == 1) direct = 3;
				else if (direct == 2) direct = 1;
				else if (direct == 3) direct = 0;
			}
		}
		
		if (direct == 0) {
			y += (T - preT);
		} else if (direct == 1) {
			y -= (T - preT);
		} else if (direct == 2) {
			x -= (T - preT);
		} else if (direct == 3) {
			x += (T - preT);
		}
		
		bw.write(x + " " + y);
		bw.flush();
		bw.close();
		br.close();
	}

}
