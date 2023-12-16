import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] sorted = new int[N];
		int num;
		for(int i = 0; i<N; i++) {
			num = Integer.parseInt(st.nextToken());
			sorted[i] = num;
		}
		Arrays.sort(sorted);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			num = Integer.parseInt(st.nextToken());
			sb.append(upperBound(sorted, num) - lowerBound(sorted, num)).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static int lowerBound(int[] arr, int key) {
		int lo = 0; 
		int hi = arr.length;
		int mid = 0;
		while(lo < hi) {
			mid = (lo + hi) / 2;
			if (arr[mid] < key) lo = mid + 1;
			else hi = mid;
		}
		return lo;
	}
	
	public static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		int mid = 0;
		while (lo < hi) {
			mid = (lo + hi) / 2;
			if (arr[mid] <= key) lo = mid + 1;
			else hi = mid;
		}
		return lo;
	}
}
/**
 * HashMap을 이용한 풀이
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<>();
		int num;
		
		
		// getOrDefault(key, defaultValue)
		// key에 대해 map에 저장 된 value를 반환한다
		// 만약 value가 없을 경우 두 번째 인자값을 반환함
		for(int i=0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			hm.put(num,  hm.getOrDefault(num, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i<M; i++) {
			num = Integer.parseInt(st.nextToken());
			sb.append(hm.getOrDefault(num, 0)).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
*/
