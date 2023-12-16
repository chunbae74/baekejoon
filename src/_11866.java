import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class _11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= N; i++) deque.add(i);
		
		StringJoiner joiner = new StringJoiner(", ");
		while(deque.size() > 0) {
			int n = (K > deque.size())?K % deque.size() : K;
			for(int i = 0; i < n; i++) {
				deque.offer(deque.poll());
			}
			joiner.add(deque.removeLast() + "");
		}
		bw.write("<"+joiner.toString()+">");
		bw.flush();
		bw.close();
		
	}
}

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11866 {

	public static void main(String[] args) throws IOException {
		// TimeOut. 코드 최적화 필요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		boolean[] isOut = new boolean[N];
		for(int i = 0; i<arr.length; i++) arr[i] = i+1;
		int howManyOut = 0, index = -1;
		String[] s = new String[N];
		while(howManyOut < N) {
			for (int i = 0; i<3; i++) {
				index ++;
				if (index == 7) index = 0;
				if (isOut[index]) i--;
			}
			s[howManyOut++] = Integer.toString(arr[index]);
			isOut[index] = true;
		}
		bw.write("<" + String.join(", ", s) + ">");
		bw.flush();
		bw.close();
	}
}
*/