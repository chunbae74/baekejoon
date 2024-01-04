import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 식의 계산은 연산자 우선순위를 무시하고 앞에서부터 진행
 * 나눗셈은 정수 나눗셈으로 몫만 취함
 * 참고 : https://st-lab.tistory.com/121
 * 진짜 너무 어렵다...;;;;
 */
public class _14888 {
	static int N;
	static int[] nums;
	// +, -, x, /
	static int[] cal = new int[4];
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(nums[0], 1);
		
		bw.write(max + "\n" + min);
		bw.flush();
		bw.close();
	}
	
	
	public static void dfs(int num, int idx) {
		// 마지막
		if (idx == N) {
			min = Math.min(num, min);
			max = Math.max(num, max);
			return;
		}

		for (int i = 0; i < 4; i++) {
			// 연산자가 없다면 건너뛰기
			if (cal[i] < 1) continue;
			
			cal[i] --;
			if (i == 0) {
				dfs(num + nums[idx], idx + 1);
			}
			else if (i == 1) {
				dfs(num - nums[idx], idx + 1);
			}
			else if (i == 2) {
				dfs(num * nums[idx], idx + 1);
			}
			else if (i == 3) {
				dfs(num / nums[idx], idx + 1);
			}
			
			cal[i] ++;
		}
	}
}
