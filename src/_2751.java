import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * https://st-lab.tistory.com/106
 * 필수로 읽어보기!
 */
public class _2751 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[2_000_000 + 1];
		int num;
		for(int i = 0; i<N; i++) {
			num = Integer.parseInt(br.readLine());
			arr[num + 1_000_000] = true;
		}
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]) bw.write((i-1_000_000) + "\n");
		}
		bw.flush();
		bw.close();
	}

}
