import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] cArr = br.readLine().toCharArray();
		Arrays.sort(cArr);
		if (cArr[0] != '0') bw.write("-1");
		else {
			int sum = 0; // 각 자리수의 합
			for (int i: cArr) sum += i;
			if (sum % 3 != 0) bw.write("-1");
			else {
				for (int i = cArr.length - 1; i >= 0; i--) bw.write(cArr[i] + "");
			}
		}
		bw.flush();
		bw.close();
	}

}
