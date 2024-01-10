import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * num = { {1, 2}, {1, 4}, {2, 3} ... };
 */
public class _1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] num = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i][0] = Integer.parseInt(st.nextToken());
			num[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num, (e1, e2) -> {
			// 끝나는 시간이 같다면
			if (e1[1] == e2[1]) {
				// 시작하는 시간 순으로 정렬
				if (e1[0] >= e2[0]) return 1;
				else return -1;
			}
			// 끝나는 시간이 다르다면
			else {
				if (e1[1] > e2[1]) return 1;
				else return -1;
			}
		});

		int count = 0;
		int endT = 0;
		
		for (int[] arr: num) {
			// 해당 idx의 시작하는 시간이 마지막 회의 종료 시간보다 같거나 나중이라면
			if (arr[0] >= endT) {
				count ++;
				endT = arr[1];
			}
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
