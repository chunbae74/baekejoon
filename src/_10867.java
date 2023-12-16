import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 수정사항 : 절댓값이 1,000보다 작거나 같은 정수 -> 음수도 가능.
 * 
 */
public class _10867 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!al.contains(num)) al.add(num);
		}
		
		Collections.sort(al);
		
		StringBuilder sb = new StringBuilder();
		for(int n: al) sb.append(n).append(" ");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] arr = new boolean[2_000 + 1];
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!arr[num + 1_000]) arr[num + 1_000] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			if (arr[i]) sb.append(i - 1_000).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		*/
	}

}
