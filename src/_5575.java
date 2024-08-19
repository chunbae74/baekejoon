import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5575 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int s1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			
			if (s2 < s1) {
				m2 -= 1;
				s2 += 60;
			}
			int calS = s2 - s1;
			
			if (m2 < m1) {
				h2 -= 1;
				m2 += 60;
			}
			int calM = m2 - m1;
			int calH = h2 - h1;
			
			System.out.println(calH + " " + calM + " " + calS);
		}
	}

}
