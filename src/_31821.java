import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _31821 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int M = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int i = 0; i < M; i++) {
			int menu = Integer.parseInt(br.readLine()) - 1;
			sum += arr[menu];
		}
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
