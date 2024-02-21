import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 24.02.21 시간초과 ;;
 * hasTeam:
 * 0 : 아직 모름
 * 1 : 팀 있음
 * -1 : 팀 없음
 */
public class _9466 {
	static int[] arr;
	static boolean[] visited;
	static int[] hasTeam;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			hasTeam = new int[n + 1];
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				// 자기 자신을 선택한 경우; 팀으로 인정됨
				if (arr[j] == j) {
					hasTeam[j] = 1;
				}
			}
			
			for (int j = 1; j <= n; j++) {
				// 팀여부가 이미 정해진 사람은 스킵
				if (hasTeam[j] != 0) continue;
				visited = new boolean[n + 1];
				dfs(j, n);
			}
			
			sb.append(count).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int num, int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(arr[num]);
		visited[num] = true;
		int[] orderArr = new int[n];
		int order = 0;
		orderArr[order ++] = num;
		
		while (!queue.isEmpty()) {
			int nextNum = queue.poll();
			orderArr[order ++] = nextNum;
			
			// 내가 고른 상대가 이미 팀이 있을 경우
			if (hasTeam[nextNum] == 1) {
				for (int i = 0; i < order - 1; i++) {
					if (hasTeam[orderArr[i]] == 0) {
						hasTeam[orderArr[i]] = -1;					
						count ++;								
					}
				}
				return;
			}
			// 내가 고른 상대가 이미 팀이 없음이 확정되었을경우
			else if (hasTeam[nextNum] == -1) {
				for (int i = 0; i < order - 1; i++) {
					if (hasTeam[orderArr[i]] == 0) {
						hasTeam[orderArr[i]] = -1;					
						count ++;								
					}
				}
				return;
			}
			
			// 어느곳에서 고리 완성
			if (visited[nextNum]) {
				// 고리 시작지점과 종료지점이 다르다면
				if (nextNum != num) {
					boolean isFound = false;
					for (int i = 0; i < order; i++) {
						// 고리가 연결되는 곳 찾음
						if (orderArr[i] == nextNum) {
							isFound = true;
						}
						if (isFound) {
							hasTeam[orderArr[i]] = 1;
						} else {
							if (hasTeam[orderArr[i]] == 0) {
								hasTeam[orderArr[i]] = -1;					
								count ++;								
							}
						}
					}
					return;
				}
				
				// 팀을 이룬 인원들 결과처리해주기
				for (int i = 1; i <= n; i++) {
					if (visited[i]) {
						hasTeam[i] = 1;
					}
				}
				return;
			}
			
			// 아직 팀을 이뤘는지, 실패인지 결과가 안나왔을때
			visited[nextNum] = true;
			queue.offer(arr[nextNum]);
		}
	}

}
