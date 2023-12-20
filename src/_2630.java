import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * N = 2, 4, 8, ... , 64, 128
 * 하얀색 : 0, 파란색 : 1
 */
public class _2630 {

	// 한 변의 길이 N
	static int N;
	static int[][] arr;
	static int whiteCount = 0;
	static int blueCount = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		chunbae(0, 0, N);
		
		bw.write(whiteCount + "\n" + blueCount);
		bw.flush();
		bw.close();
	}
	
	
	public static void chunbae(int x, int y, int size) {

		// 마지막 한 피스일때
		if (size == 1) {
			if (arr[x][y] == 1) ++ blueCount;
			else ++ whiteCount;
			return;
		}
		
		// 편-안-
		boolean isClear = true;
		// 첫 번째 색종이 ㄱㄱ
		int category = arr[x][y];
		
		// 색깔이 같은지 찾아보자아..
		Loop1: for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				// 색깔이 다르네..
				if (arr[i][j] != category) {
					isClear = false;
					break Loop1;
					
				}
			}
		}
		
		if (isClear) {
			if (category == 0) ++ whiteCount;
			else ++ blueCount;
			return;
		}
		// 색깔이 다르다면..
		else {			
			size = size / 2;
			
			// 4등분		
			chunbae(x + size, y, size); 		// 제 1사분면
			chunbae(x, y, size); 				// 제 2사분면						
			chunbae(x, y + size, size);			// 제 3사분면
			chunbae(x + size, y + size, size); 	// 제 4사분면					
		}
	}

}
