import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _17608 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int lastLen = arr[N-1];
		
		int count = 1; // 마지막 막대는 이미 보이므로
		int maxLen = lastLen;
		for(int i = N-1; i >= 0; i--) {
			if (arr[i] > maxLen) {
				count++;
				maxLen = arr[i];
			}
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
		
	}

}
