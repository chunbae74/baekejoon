import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2248 {
	static char[][] arr;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][2 * N - 1];
		
		drawTri(N - 1, 0, N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				bw.write((arr[i][j]=='*'?'*':' ') + "");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void drawTri(int x, int y, int size) {
		// 최소 사이즈
		if (size == 3) {
				arr[y][x] = '*';
				arr[y + 1][x - 1] = arr[y + 1][x + 1] = '*';
				for (int i = 0; i < 5; i++) arr[y + 2][x - 2 + i] = '*';
				return;
		}
		
		size /= 2;
		drawTri(x, y, size);
		drawTri(x - size, y + size, size);
		drawTri(x + size, y + size, size);
	}
}
