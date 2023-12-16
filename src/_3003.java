import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _3003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int order;
		// 킹1, 퀸1, 룩2, 비숍2, 나이트2, 폰8
		int[] arr = {1, 1, 2, 2, 2, 8};
		for (int i = 0; i<6; i++) {
			order = Integer.parseInt(st.nextToken());
			bw.write(arr[i] - order + " ");
		}
		bw.flush();
		bw.close();
	}

}
