import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _14916 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;

		// 5원의 개수를 최대로 잡고 하나씩 줄여나가기
		for (int i = n / 5; i >= 0; i--) {
			// 2로 나누어떨어진다면
			if ((n - (5 * i)) % 2 == 0) {
				count += i;
				n -= 5 * i;
				count += n / 2;
				break;
			}
		}
		
		bw.write((count == 0) ? "-1" : count + "");
		bw.flush();
		bw.close();
	}

}
