import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2847 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		
		for (int i = N - 1; i >= 0; i--) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		int preScore = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (preScore <= arr[i]) {
				int cal = Math.abs(arr[i] - preScore) + 1;
				count += cal;
				arr[i] -= cal;
			}
			preScore = arr[i];
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
