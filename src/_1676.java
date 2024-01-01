import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 참고 : https://st-lab.tistory.com/165
// 2는 5보다 작은 수여서 연속된 수를 곱하면 자연스레 모든 값들의 소인수 분해들은 2의 개수가 5의 개수보다 많음
// 즉, 0의 개수는 5의 개수와 같다.
public class _1676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		while (N >= 5) {
			count += N / 5;
			N /= 5;
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
}
