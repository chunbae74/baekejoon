import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25179 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		if (N <= M) {
			if (N == 1) {
				System.out.println("Can't win");
			} else {
				System.out.println("Can win");
			}
			
		} else {
			long quotient = N / M;
			long remainder = N % M;

			// 내 차례일 때
			if (quotient % 2 == 0) {
				// 1만 남겨두기가 가능하다면
				if (remainder <= M - 1) {
					System.out.println("Can win");
				} else {
					System.out.println("Can't win");
				}
			}
			// 상대 차례일 때
			else {
				// 상대가 1만 남겨두기가 가능하다면
				if (remainder <= M - 1) {
					System.out.println("Can't win");
				} else {
					System.out.println("Can win");
				}
			}
		}
	}

}
