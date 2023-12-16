import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9020 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] isNotSosu = new boolean[10_000 + 1];
		isNotSosu[0] = isNotSosu[1] = true;
		for(int i = 2; i<isNotSosu.length; i++) {
			if(!isNotSosu[i]) {
				for (int j = i*2; j<isNotSosu.length; j+=i) isNotSosu[j] = true;
			}
		}
		int n, num2;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			n = Integer.parseInt(br.readLine());
			for (int j = n/2+1; j>=2; j--) {
				num2= n - j;
				if (!isNotSosu[j] && !isNotSosu[num2]) {
					bw.write(Math.min(j,  num2) + " " + Math.max(j,  num2));
					break;
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
