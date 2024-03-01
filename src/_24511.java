import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 0 = queue : 선입선출; addLast
 * 1 = stack : 후입선출; addFirst
 */
public class _24511 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int[] arr;
		int[] type;
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		type = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			type[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			// 밖에 나와있는 숫자.
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < N; j++) {
				// 0: 큐. 선입선출
				if (type[j] == 0) {
					int temp = arr[j];
					arr[j] = num;
					num = temp;
				}
				// 1: 스택. 후입선출
				else if (type[j] == 1) {
					continue;
				}
			}
			
			sb.append(num).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
