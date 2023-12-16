import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _5585 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = {500, 100, 50, 10, 5, 1};
		int T = 1000 - Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			count += T / arr[i];
			T %= arr[i];
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
