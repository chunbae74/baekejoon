import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10870 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		if (N == 0) bw.write("0");
		else {

			int[] arr= new int[N + 1];
			arr[0] = 0;
			arr[1] = 1;
			for (int i = 2; i < N + 1; i++) {
				arr[i] = arr[i - 1] + arr[i - 2];
			}
			bw.write(arr[N] + "");
		}
		bw.flush();
		bw.close();
	}

}
