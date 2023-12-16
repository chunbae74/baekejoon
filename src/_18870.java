import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _18870 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] origin = new int[N]; // 기존값 배열
		int[] sorted = new int[N]; // 순서 정렬되는 배열
		for(int i = 0; i < N; i++) {
			origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sorted);
		
		// key : num, value : rank
		HashMap<Integer, Integer> hm =new HashMap<>();
		int rank = 0;
		for(int i : sorted) {
			if (!hm.containsKey(i)) hm.put(i, rank++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : origin) {
			sb.append(hm.get(i)).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}

/**
 * ArrayList의 contains() 경우 O(n)의 시간복잡도를 가지고 있음.
 * ArrayList 전체를 순회하면서 있나 없나를 살펴보고 그 결과를 반환하기 때문.
 * 반면에 HashSet의 contains()의 경우 O(1)의 시간복잡도를 가지고 있음.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class _18870 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num;
		int[] arr = new int[N];
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if (!hs.contains(num)) hs.add(num);
			arr[i] = num;
		}
		Integer[] a = hs.toArray(new Integer[hs.size()]);
		Arrays.sort(a);
		for(int i = 0; i<N; i++) {
			bw.write(getIndex(a, arr[i]) + " ");
		}
		bw.flush();
		bw.close();
	}
	
	public static int getIndex(Integer[] al, int n) {
		int start = 0;
		int end = al.length;
		int mid = 0;
		while(start <= end) {
			mid = (start+end)/2;
			if (al[mid] > n) end = mid;
			else if (al[mid] < n) start = mid + 1;
			else break;
		}
		return mid;
	}
}
*/
