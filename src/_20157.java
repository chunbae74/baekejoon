import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 반례: https://www.acmicpc.net/board/view/105478
 */
public class _20157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1,2,3,4사분면
		HashMap<Double, Integer>[] hm = new HashMap[4];
		
		for (int i = 0; i < 4; i++) {
			hm[i] = new HashMap<>();
		}

		int N = Integer.parseInt(br.readLine());
		int max = 0;
		// { 상, 하, 좌, 우 }
		int[] straight = new int[4];
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			double slop = 0.0;
			// 화살의 경로가 y축인 경우
			if (x == 0) {
				if (y > 0) {
					straight[0] ++;
					max = Math.max(max, straight[0]);
				} else if (y < 0) {
					straight[1] ++;
					max = Math.max(max, straight[1]);
				}
				continue;
			} else {
				// x축
				if (y == 0) {
					if (x > 0) {
						straight[3] ++;
						max = Math.max(max, straight[3]);
					} else if (x < 0) {
						straight[2] ++;
						max = Math.max(max, straight[2]);
					}
					continue;
				}
				
				int quadrant = -1;
				// 1사분면
				if (x > 0 && y > 0) {
					quadrant = 0;
				// 2사분면
				} else if (x < 0 && y > 0) {
					quadrant = 1;
				// 3사분면
				} else if (x < 0 && y < 0) {
					quadrant = 2;
				// 4사분면
				} else if (x > 0 && y < 0) {
					quadrant = 3;
				}
				
				slop = ((double) x) / y;
				hm[quadrant].put(slop, hm[quadrant].getOrDefault(slop, 0) + 1);
				max = Math.max(max, hm[quadrant].get(slop));
			}
		}

		System.out.println(max);
	}

}
