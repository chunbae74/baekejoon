import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * T : 테스트 케이스 개수. 각 테스트케이스는 두 줄로 이루어져 있음
 * N : 문서의 개수 (1 <= N <= 100)
 * M : 몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여있는지 나타냄
 * 맨 왼쪽은 0번째임.
 * 
 *
 */
public class _1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int N, M;
		int[] arr = new int[100];
		int index = 0;
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int importance = Integer.parseInt(st.nextToken());
				arr[index++] = importance;
			}
						
			
		}
	}

}
