import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _7795 {
	static int[] A, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sizeA = Integer.parseInt(st.nextToken());
			int sizeB = Integer.parseInt(st.nextToken());
			A = new int[sizeA];
			B = new int[sizeB];
			st = new StringTokenizer(br.readLine());
			for (int a = 0; a < sizeA; a++) {
				A[a] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int b = 0; b < sizeB; b++) {
				B[b] = Integer.parseInt(st.nextToken());
			}
			
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			int minB = B[0];
			int maxB = B[sizeB - 1];

			int count = 0;
			for (int i = 0; i < sizeA; i++) {
				int num = A[i];
				// A[i]가 B보다 큰 쌍의 개수 없음
				if (num <= minB) continue;
				// A[i]가 모든 B보다 큼
				else if (num > maxB) {
					count += sizeB;
					continue;
				}
				// A[i]가 부분적으로만 큼
				else {
					// idx: A[i]이하의 수 중 가장 큰 수의 위치
					int idx = binarySearch(A[i]);
					count += idx;
				}
			}
			
			sb.append(count).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int binarySearch(int num) {
		int start = 0;
		int end = B.length;
		int mid = -1;
		
		while (start < end) {
			mid = (start + end) / 2;
			
			if (num <= B[mid]) {
				end = mid;
			} else if (num > B[mid]) {
				start = mid + 1;
			}
		}
		
		return end;
	}

}
