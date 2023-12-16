import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int sum = 1, line = 1;
		while (sum < n) {
			sum += ++line;
		}
		int order = n - (sum - line);
		if (line % 2 == 0) { // 짝수 번째 줄
			bw.write(order + "/" + (line + 1 - order));
		} else {
			bw.write((line + 1 - order) + "/" + order);			
		}
		bw.flush();
		bw.close();
	}
}
