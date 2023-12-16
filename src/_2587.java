import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _2587 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[5];
		int avg = 0, num;
		for(int i = 0; i<5; i++) {
			num = Integer.parseInt(br.readLine());
			arr[i] = num;
			avg += num;
		}
		Arrays.sort(arr);
		bw.write(avg / 5 + "\n");
		bw.write(arr[2] + "");
		bw.flush();
		bw.close();
	}

}
