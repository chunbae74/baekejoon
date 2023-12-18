import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 참고 : https://st-lab.tistory.com/95
 */
public class _2447 {

	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		drawStar(0, 0, N, false);
		// 그려내기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(arr[i][j] + "");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void drawStar(int x, int y, int N, boolean isEmpty) {
//		// 만약 공백 구간이라면
		if (isEmpty) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return; 
		}
		
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}
		
		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count ++;
//				System.out.printf("x = %dㅣy = %d\n", i, j);
				if (count == 5) drawStar(i, j, N/3, true);
				else drawStar(i, j, N/3, false);
			}
			// 빈 공간
//			if (count == 5) {
//				drawStar(x, y, N, true);
//			}
//			else {
//				drawStar(x, y, N, false);
//			}
		}
	}

}
