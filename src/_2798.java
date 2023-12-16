import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 각 카드에는 양의 정수
 * 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓은 후 숫자 M을 외침
 * N장의 카드 중 3장의 카드 골라야함. 
 * 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 함
 * N M 주어짐
 *
 */
public class _2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int c1, c2, c3, num = 0;
		for (int i = 0; i < arr.length; i++) {
			c1 = arr[i];
			for (int j = 0; j < arr.length; j++) {
				c2 = arr[j];
				if (c1 == c2) continue;
				for (int k = 0; k < arr.length; k++) {
					c3 = arr[k];
					if (c1 == c3 || c1 == c2 || c2 == c3) continue;
					int sum = c1 + c2 + c3;
					if (sum > M) continue;
					if (sum > num) num = sum;
				}
			}
		}
		bw.write(num + "");
		bw.flush();
		bw.close();
	}
}
