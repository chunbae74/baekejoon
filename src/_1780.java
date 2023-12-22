import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1780 {
	static int N;
	static int[][] arr;
	static int c1, c2, c3;
	public static void main(String[] args) throws IOException  {
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
		
		bw.write(c1 + "\n" + c2 + "\n" + c3);
		bw.flush();
		bw.close();
	}
	
	public static void chunbae(int x, int y, int size) {
		if (size == 1) {
			category(arr[x][y]);
			return;
		}
		
		int firstNum = arr[x][y];
		boolean isClear = true;
		Loop1: for (int i = x; i < x + size; i ++) {
			for (int j = y; j < y + size; j++) {
				if (firstNum != arr[i][j]) {
					isClear = false;
					break Loop1;
				}
			}
		}
		
		if (isClear) {
			category(firstNum);
			return;
		}
		else {
			size /= 3;
			chunbae(x, y, size); // 1
			chunbae(x + size, y, size); // 2
			chunbae(x + size * 2, y, size); // 3
			chunbae(x, y + size, size); // 4
			chunbae(x + size, y + size, size); // 5
			chunbae(x + size * 2, y + size, size); // 6
			chunbae(x, y + size * 2, size); // 7
			chunbae(x + size, y + size * 2, size); // 8
			chunbae(x + size * 2, y + size * 2, size); // 9
		}
	}
	
	public static void category(int num) {
		if (num == -1) ++ c1;
		else if (num == 0) ++ c2;
		else ++ c3;
		return;
	}

}
