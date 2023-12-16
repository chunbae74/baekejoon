import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _2418 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i<N; i++) {
			int order = Integer.parseInt(st.nextToken());
			set.add(order);
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<M; i++) {
			int order = Integer.parseInt(st.nextToken());
			if (set.contains(order)) bw.write("1\n");
			else bw.write("0\n");
		}
		/*
		 * 여전히 시간초과...
		int[] arr = new int[N];
		for (int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<M; i++) {
			int order = Integer.parseInt(st.nextToken());
			boolean found = false;
			Loop2 : for (int j = 0; j<N; j++) {
				if (arr[j] == order) {
					found = true;
					break Loop2;
				}
				else continue;
			}
			bw.write(((found==true)?1:0) + "\n");
		}
		*/
		/*
		 * 시간초과
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i<N; i++) {
			int order = Integer.parseInt(st.nextToken());
			al.add(order);
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<M; i++) {
			int order = Integer.parseInt(st.nextToken());
			if (al.contains(order)) bw.write("1\n");
			else bw.write("0\n");
		}
		*/
		bw.flush();
		bw.close();
	}

}
