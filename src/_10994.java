import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10994 {

	static char[][] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		int len = 4 * N - 3;
		arr = new char[len][len];
	
		draw(0, N);
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				bw.write(arr[i][j] + "");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void draw(int startPoint, int loop) {
		int center = -2 * loop + (2 * N);

		if (loop == 1) {
			arr[center][center] = '*';
			return;
		}

		int len = 4 * loop - 3;
		
		startPoint = -2 * loop + (2 * N);

		for (int i = startPoint; i < startPoint + len; i++) {
			for (int j = startPoint; j < startPoint + len; j++) {
				if (i == startPoint) {
					arr[i][j] = '*';
				}
				else if (i == startPoint + len - 1) {
					arr[i][j] = '*';
				}
				else {
					if (j == startPoint) {
						arr[i][j] = '*';
					}
					else if (j == startPoint + len - 1) {
						arr[i][j] = '*';
					}
					else {
						arr[i][j] = ' ';						
					}
				}
			}
		}
		

		draw(startPoint, loop - 1);
	}
	

}
