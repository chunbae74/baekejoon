package 첫번째나들이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * [품질, 가격] 
 * 1. 품질 높은 순. 만약 같은 품질이면 저렴한 것 우선
 * 2. 가격 낮은 순. 만약 같은 가격이라면 높은 품질 우선
 */
public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (e1, e2) -> {
			if (e1[0] == e2[0]) return e1[1] - e2[1];
			else return e2[0] - e1[0];
		});
		
		bw.write(arr[0][0] + " " + arr[0][1] + " " + arr[1][0] + " " + arr[1][1] + "\n");
		
		Arrays.sort(arr, (e1, e2) -> {
			if (e1[1] == e2[1]) return e2[0] - e1[0];
			else return e1[1] - e2[1];
		});
		
		bw.write(arr[0][0] + " " + arr[0][1] + " " + arr[1][0] + " " + arr[1][1] + "\n");
		bw.flush();
		bw.close();
	}

}
