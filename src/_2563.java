import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] board = new int[100][100];
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int n1, n2, count = 0;
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			n2 = Integer.parseInt(st.nextToken());
			for (int j = 0; j<10; j++) {
				for (int k = 0; k<10; k++) {
					if (board[(n1+j)][(n2+k)] == 0) {
						count++;
						board[(n1+j)][(n2+k)] = 1;
					}
				}
			}
		}
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
