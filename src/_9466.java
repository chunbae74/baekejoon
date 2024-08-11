import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class _9466 {
	static int N;
	static int[] arr;
	static boolean[] hasTeam;
	static final int INF = Integer.MAX_VALUE >> 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			hasTeam = new boolean[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				// 자기 자신을 선택한 경우; 팀으로 인정됨
				if (arr[j] == j) {
					hasTeam[j] = true;
				}
			}
			
			for (int j = 1; j <= N; j++) {
				// 팀여부가 이미 정해진 사람은 스킵
				if (hasTeam[j]) continue;
				dfs(j);
			}
			
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (hasTeam[i]) continue;
				count ++;
			}
			System.out.println(count);
		}
		
	}
	
	public static void dfs(int startNum) {
		Stack<int[]> stack = new Stack<>();
		int[] dist = new int[N + 1];
		int[] backTracking = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[startNum] = 0;
		stack.add(new int[] { startNum, dist[startNum] });
		while (!stack.isEmpty()) {
			int nowNum = stack.peek()[0];
			int nowCost = stack.peek()[1];
			stack.pop();
			
			int nextNum = arr[nowNum];
			if (hasTeam[nowNum] || hasTeam[nextNum]) break;
			
			backTracking[nextNum] = nowNum;
			
			if (dist[nextNum] > nowCost + 1) {
				dist[nextNum] = nowCost + 1;
				stack.add(new int[] { nextNum, dist[nextNum] });	
			// 이미 최신화가 된 경우, 즉 이미 한 사이클이 만들어 진 경우
			} else {
				hasTeam[nextNum] = true;
				chunbae(nextNum, backTracking[nextNum], backTracking);
			}
		}
	}
	
	public static void chunbae(int start, int now, int[] backTracking) {
		if (start == now) return;
		else {
			hasTeam[now] = true;
			chunbae(start, backTracking[now], backTracking);
		}
	}

}
