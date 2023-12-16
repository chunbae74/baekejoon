/**
 * 에라토스테네스의 체
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _6588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] isNotSosu = new boolean[1_000_000 + 1]; // 소수면은 false, 소수가 아니면 true.
		isNotSosu[0] = isNotSosu[1] = true;
		for (int i = 2; i< isNotSosu.length; i++) {
			if (!isNotSosu[i]) {
				for (int j = i*2; j < isNotSosu.length; j += i) {
					isNotSosu[j] = true;
				}
			} else continue;
		}
		
		int n;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			// 8 = 3 + 5 = 5 + 3;
			Loop2: for(int i = 3; i <= n/2 ; i+=2) {
				int num2 = n - i;
				if (!isNotSosu[i] && !isNotSosu[num2]) {
					bw.write(n + " = " + Math.min(i, num2) + " + " + Math.max(i,  num2));
					bw.write("\n");
					break Loop2;
				} else continue Loop2;
			}
		}
		bw.flush();
		bw.close();
	}
}