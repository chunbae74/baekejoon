/**
 * 바구니 총 N개, 각각 1번부터 N번까지 번호 있음
 * 바구니에는 공이 1개씩 들어있고, 처음에는 바구니에 적혀 있는 번호와 같은 번호가 적힌 공 있음
 * 앞으로 M번 공을 바꾸려고 함
 * 공 바꿀 바구니 2개 선택하고, 두 바구니에 들어있는 공을 서로 교환
 * 첫째 줄에 N과 M 주어짐
 * i번 바구와 j번 바구니의 공을 교환함.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10813 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int box;
		for (int i = 0; i < n; i++) arr[i] = (i+1); // 박스 초기화
		for (int i = 0; i < m; i++) { // m번 공 바꿈
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken()) - 1;
			int J = Integer.parseInt(st.nextToken()) - 1;
			box = arr[I];
			arr[I] = arr[J];
			arr[J] = box;
		}
		for (int order: arr) bw.write(order + " ");
		bw.flush();
		bw.close();
	}

	private static StringTokenizer StringTokenizer(String readLine) {
		// TODO Auto-generated method stub
		return null;
	}

}
