import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 첫째 줄에 상근이가 가지고 있는 카드 개수 N이 주어짐
 * 둘째 줄에는 숫자카드에 적혀있는 정수가 주어짐
 * 셋째 줄에는 M이 주어짐
 * 넷째 줄에는 M개의 카드가 주어짐.
 *
 */

public class _10815 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] card = new int[N];
		for (int i = 0; i<N; i++) card[i] = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Arrays.sort(card);
		for (int i = 0 ; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			bw.write(isFound(card, num)?"1 " : "0 ");
		}
		bw.flush();
		bw.close();
	}
	
	public static boolean isFound(int[] array, int n) {
		int begin = 0, end = array.length - 1;
		int mid;
		while(begin <= end) {
			mid = (begin + end) / 2;
			if (array[mid] > n) end = mid - 1;
			else if (array[mid] < n) begin = mid + 1;
			else return true;
		}
		return false;
	}
}


/*
public class _10815 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i<N; i++) hs.add(Integer.parseInt(st.nextToken()));
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			bw.write(hs.contains(num)?"1 ":"0 ");
		}
		bw.flush();
		bw.close();
	}
}
*/