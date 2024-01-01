import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9663 {
	static int N;
	static int count = 0;
	
	//참고 : https://st-lab.tistory.com/118
	/*
	 * idx는 row를, arr[idx]는 column을 나타낸다.
	 * arr[0] = 1 : 0번째 줄 0번째 칸에 Queen 놓기
	 * arr[2] = 3 : 2번째 줄 3번째 칸에 Queen 놓기
	 * ...
	 */
	static int[] arr = new int[15];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
				
		nQueen(0);
		
		bw.write(count + "");
		bw.flush();
		bw.close();
	}
	
	/*
	 * idx 즐에 Quuen 놓기
	 */
	public static void nQueen(int idx) {
		// 모든 줄에 Queen 다 놓음
		if (idx == N) {
			count++;
			return;
		} 
		

		for (int i = 0; i < N; i++) {
			arr[idx] = i;
			// 만약 옳은 곳이라면
			if (isRight(idx)) nQueen(idx + 1);
		}
	}
	
	/*
	 * idx 칸에 놔둔 Queen이 올바른 위치일까?
	 */
	public static boolean isRight(int idx) {
		int element = arr[idx];
		for (int i = 0; i < idx; i++) {
			// 한 줄에 있는지
			if (arr[i] == element) {
				return false;
			}
			// 대각선상에 있는지
			else if (Math.abs(element - arr[i]) == Math.abs(i - idx)) {
				return false;
			}
		}
		
		return true;
	}

}
