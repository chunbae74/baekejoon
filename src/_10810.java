/**
 * 각각의 바구니에 1번부터 N번까지 번호 있음
 * 1번부터 N번까지 번호가 적혀있는 공 매우 많음
 * 맨 처음에는 바구니에 공이 들어있지 않고, 바구니에는 공을 1개만 넣을 수 있음
 * 도현이는 앞으로 M번 공을 넣으려고 한다. 도현이는 한 번 공을 넣을떄 공을 넣을 바구니 범위를 정하고, 
 * 정한 바구니에 모두 같은 번호가 적혀있는 공을 넣는다.
 * 바구니에 공이 이미 있는 경우에는 들어있는 공을 빼고, 새로운 공을 넣는다.
 * i, j, k : i번 바구니에 j번 바구니까지 k번 공을 넣는다.
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10810 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] box = new int[n]; // n개의 바구니 생성
		for (int i = 0; i<box.length; i++) box[i] = 0; // 처음 값 모두 0으로 초기화
		
		for (int a = 0; a < m; a++) { // 앞으로 공 M번 넣기
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int b = (i-1); b <= (j-1); b++) { //i번 바구니부터 j번 바구니까지 공을 넣는다.
				box[b] = k;
			}
		}
		for (int order: box) bw.write(order + " ");
		bw.flush();
		bw.close();
		
	}

}
