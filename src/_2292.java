 import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int sum = 1, index = 0;
		while(sum < n) {
			sum += index * 6;
			index ++;
		}
		if (index == 0) index = 1;
		bw.write(index + "");
		bw.flush();
		bw.close();
	}
}
