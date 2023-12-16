import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 고유번호의 처음 5자리 : 00_000 ~ 99_999
 * 6번째 자리 : 검증수.
 * 검증수 = 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지.
 *
 */
public class _2475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0, num;
		for (int i = 0; i < 5; i++) {
			num = Integer.parseInt(st.nextToken());
			sum += num * num;
		}
		sum %= 10;
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}
}
