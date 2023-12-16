import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _24062 {
	static int[] A, B, tmp;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		tmp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(A, 0, N - 1);
		System.out.println(result);
	}
	
	public static void merge_sort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			merge_sort(A, p, q);
			merge_sort(A, q+1, r);
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
			if (Arrays.toString(A).equals(Arrays.toString(B))) {
				result = 1;
				break;
			}
			A[i] = tmp[t];
			i++;
			t++;
		}
	}

}
