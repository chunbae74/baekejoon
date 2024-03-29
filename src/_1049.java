import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * N : 끊어진 기타줄 개수
 * M : 브랜드 개수
 * 
 * 패키지 가격 / 낱개의 가격
 */
public class _1049 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] sortByPac = new int[M][2];
		int[][] sortByUnit = new int[M][2];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sortByPac[i][0] = sortByUnit[i][0] = Integer.parseInt(st.nextToken());
			sortByPac[i][1] = sortByUnit[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sortByPac, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		Arrays.sort(sortByUnit, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int cost = 0;
		while (N > 0) {
			if (N >= 6) {
				cost += Math.min(sortByPac[0][0], sortByUnit[0][1] * 6);
				N -= 6;
			}
			// 6개 미만으로 남았다면
			else {
				cost += Math.min(sortByPac[0][0], sortByUnit[0][1] * N);
				N = 0;
			}
		}
		
		bw.write(cost + "");
		bw.flush();
		bw.close();
	}

}
