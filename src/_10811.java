import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있음.
 * M번 바구니의 순서를 역순으로 만들려고 한다.
 * 첫째 줄에 N과 M이 주어짐.
 * i번째 바구니부터 j번째 바구니의 순서를 역순으로 만듦.
 */
public class _10811 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for (int i = 0; i<N; i++) arr[i] = i+1;
		for (int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			int boxCount = J-I + 1;
			int orderSaveBox;
			if (boxCount % 2 == 0) { // 상자 짝수개
				for (int l = 0; l < boxCount/2; l++) {
					int num1 = I+l-1;
					int num2 = J-l-1;
					orderSaveBox = arr[num1];
					arr[num1] = arr[num2];
					arr[num2] = orderSaveBox;
				}
			} else { // 상자 홀수개
				for (int l = 0; l < (boxCount-1)/2; l++) {
					int num1 = I+l-1;
					int num2 = J-l-1;
					orderSaveBox = arr[num1];
					arr[num1] = arr[num2];
					arr[num2] = orderSaveBox;
				}
			}
		}
		for(int order: arr) bw.write(order + " ");
		bw.flush();
		bw.close();
	}

}
