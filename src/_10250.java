import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _10250 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int H, W, N;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine()); 
			H = Integer.parseInt(st.nextToken()); // 호텔 층 수
			W = Integer.parseInt(st.nextToken()); // 한 층당 방 개수
			N = Integer.parseInt(st.nextToken()); // n번째 손님
			int y = N % H;
			int x = N / H + 1;
			if (y == 0) {
				y = H;
				x --;
			}
			sb.append(y + String.format("%02d", x)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
