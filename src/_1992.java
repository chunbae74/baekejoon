import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1992 {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		quardTree(0, 0, N);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void quardTree(int x, int y, int size) {
		if (size == 1) {
			sb.append(arr[y][x]);
			return;
		}
		
		boolean tf = isSame(x, y, size);
		
		if (!tf) {
			sb.append("(");
			size /= 2;
			quardTree(x, y, size); 					// 왼쪽 위
			quardTree(x + size, y, size); 			// 오른쪽 위
			quardTree(x, y + size, size); 			// 왼쪽 아래
			quardTree(x + size, y + size, size); 	// 오른쪽 아래
			sb.append(")");
		}
		else {
			sb.append(arr[y][x]);
			return;
		}
		
	}
	
	public static boolean isSame(int x, int y, int size) {
		int color = arr[y][x];
		boolean isSame = true;
		Loop1: for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (color != arr[i][j]) {
					isSame = false;
					break Loop1;
				}
			}
		}
		
		return isSame;
	}

}
