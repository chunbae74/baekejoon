import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _27648 {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		br.close(); // 입력 종료
		
		if (X + Y - 1 > K) {
			System.out.println("NO");
			System.exit(0);
		}
		
		sb.append("YES\n");
		
		for (int start = 1; start <= Y; start ++) {
			for (int x = start; x < X + start; x++) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
