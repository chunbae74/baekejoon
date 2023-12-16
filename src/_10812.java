/**
 * 왼쪽으로부터 i번째 바구니부터 j번째 바구니의 순서를 회전시킨다. 그 때 기준 바구니는 k번째 바구니이다. 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < N; i++) al.add(i+1);
		
		int i, j, k;
		for (int ii = 0; ii < M; ii++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			for (int s = i; s < k; s++) {
				int num = al.get(i-1);
				al.remove(i-1);
				al.add(j-1,num);
			}
		}
		for(int num: al) bw.write(num + " ");
		bw.flush();
		bw.close();
	}

}
