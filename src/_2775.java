import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _2775 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int k, n;
		int[][] arr = new int[15][15];
		for(int i = 1; i<15; i++) arr[0][i] = i;
		
		for(int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				int sum = 0;
				for (int l = 1; l<=j; l++) sum += arr[i-1][l];
				arr[i][j] = sum;
			}
		}
		for(int i = 0; i<T; i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			bw.write(arr[k][n] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
