import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24061 {

	static int[] A, tmp;
	static String result = "-1";
	static int count = 0;
	static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N];
		tmp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(A, 0, N - 1);
		System.out.println(result);
	}
	
	public static void merge_sort(int[] A, int p, int r) {
		if (count > K) return;
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(A, p, q);
			merge_sort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}
	
	public static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		
		while (i <= q && j <= r) {
			if (A[i] <= A[j]) {
				tmp[t] = A[i];
				i++;
			}
			else {
				tmp[t] = A[j];
				j++;
			}
			t++;
		}
		
		while (i <= q) {
			tmp[t] = A[i];
			t++;
			i++;
		}
		
		while (j <= r) {
			tmp[t] = A[j];
			t++;
			j++;
		}
		
		i = p;
		t = 0;
		
		while (i <= r) {
			count++;
			A[i] = tmp[t];
			if (count == K) {
				StringBuilder sb = new StringBuilder();
				for (int num: A) sb.append(num).append(" ");
				result = sb.toString();
				break;
			}
			i++;
			t++;
		}
	}

}
