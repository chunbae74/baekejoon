import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10989 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10_000 + 1]; // 수의 범위 : 1~10,000
		int num;
		for(int i = 0 ; i<N; i++) {
			num = Integer.parseInt(br.readLine());
			arr[num] ++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			while(arr[i]-- > 0) bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
		
	}

}
