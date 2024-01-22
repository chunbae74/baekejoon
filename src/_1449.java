import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 시작, 끝지점 : 좌우 0.5
 * N : 물이 새는 곳의 개수
 * L : 테이프의 길이
 */
public class _1449 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int count = 1;
		double start = Math.max(arr[0] - 0.5, 0);
		double end;
		for (int i = 1; i < arr.length; i++) {
			end = arr[i] + 0.5;
			// 테이프 하나로 수리 가능하다면
			if (end - start <= L) {
				continue;
			}
			// 테이프 하나로 수리가 불가능하다면
			else {
				// 새로운 테이프 on
				count ++;
				// 시작지점 업데이트
				start = arr[i] - 0.5;
			}
		}
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}

}
