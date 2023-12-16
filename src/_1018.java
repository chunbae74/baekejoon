import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 이중 배열에 input값을 저장한다.
 * 이후 8x8 체스판을 위아래로 한칸씩 옮겨간다. (for문 i, j)
 * 각 경우의 수에서 얼마나 바꿔야 하는지 비교한다.
 * 이 때 맨 첫번째 색깔을 기준점으로 잡는 경우의 수와
 * 첫번째 색갈의 "반대 색"을 기준점으로 잡는 경우의 수가 있다.
 * 각각 count1, count2, preColor1, preColor2에 저장한다.
 * 이후 마지막에 Math.min(count1, count2)값을 min값과 비교 후 min값을 업데이트한다.
 *
 */
public class _1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		
		// 이중배열에 일단 다 저장한다.
		char[][] board = new char[row][column];
		for (int i= 0; i < row; i++) {
			String s = br.readLine();
			for (int j = 0; j < column; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		// 8x8 칸을 한칸씩 움직여가며 모든 경우의 수를 비교해본다.
		for (int i = 0; i <= row - 8; i++) {
			for (int j = 0; j <= column - 8; j++) {
				char preColor1 = 'A'; // 경우의 수1의 이전 색깔
				char preColor2 = 'A'; // 경우의 수2의 이전 색깔
				boolean isStarted = false;
				int count1 = 0;
				int count2 = 1; // 경우의 수2의 경우 맨 첫번째 칸부터 반대 색을 칠해야 하므로.
				
				for (int k = 0; k < 8 ; k++) { // 가로
					for (int m = 0; m < 8; m++) { // 세로
						char nowColor = board[i+k][j+m];
						if (!isStarted) { // 만약 맨 첫번째 칸일 경우
							isStarted = true;
							preColor1 = nowColor; 
							preColor2 = (nowColor == 'B')?'W':'B'; // 맨 첫번째 색깔에 반대 색을 칠한다.
							continue;
						} else { // 만약 맨 첫번째 칸이 아닌 경우
							if (preColor1 == nowColor) { // 색깔을 칠해줘야 하는 경우
								count1 ++;
								preColor1 = (preColor1 == 'B')?'W':'B';
							} else preColor1 = nowColor;
							if (preColor2 == nowColor) { // 색깔을 칠해줘야 하는 경우
								count2 ++;
								preColor2 = (preColor2 == 'B')?'W':'B';
							} else preColor2 = nowColor;
							
						}
					}
					// 다음 줄로 넘어가기 직전 preColor 값을 업데이트 해준다.
					preColor1 = (preColor1 == 'B')?'W':'B';
					preColor2 = (preColor2 == 'B')?'W':'B';
				}
				
				// 최소값을 저장한다.
				int minCountValue = Math.min(count1, count2);
				if (min > minCountValue) min = minCountValue;
			}
		}
		
		bw.write(min + "");
		bw.flush();
		bw.close();
	}
}
