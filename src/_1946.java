import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
 * 동순위 없음
 * 서류심사 / 면접
 */
public class _1946 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine()); 
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];
			
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, new Comparator<int[]>() {
				
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			int rank = N + 1;
			int count = 0;
			for (int[] idx: arr) {
				// 만약 서류심사 순위도 낮고 면접도 낮다면 탈락
				if (idx[1] > rank) {
					continue;
				} 
				
				rank = idx[1];
				count ++;
			}
			
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
	}

}
