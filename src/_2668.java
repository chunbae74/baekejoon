import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2668 {
	static int[][] givenArr;
	static int[] arr;
	static boolean[] visited;
	static boolean[] finalVisited;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		givenArr = new int[N + 1][2];
		finalVisited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			givenArr[i] = new int[] { i, Integer.parseInt(br.readLine()) };
		}
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			visited[i] = true;
			dfs(givenArr[i][1], i);
		}
		
		sb.append(max).append("\n");
		for (int i = 1; i <= N; i++) {
			if (finalVisited[i]) {
				sb.append(i).append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int next, int start) {
		// 한 바퀴 돌았을 때
		if (next == start && visited[start]) {
			// 중복값 있는지 확인
			boolean doubleCheck = false;
			int count = 0;
			for (int i = 1; i < visited.length; i++) {
				if (visited[i]) count ++;
				
				// 중복 발생하면
				if (visited[i] == finalVisited[i] && visited[i] == true) {
					doubleCheck = true;
				}
			}
			
			// System.out.printf("중복 start = %d\t중복여부 = %b\n", start, doubleCheck);
			// 중복 있다면
			if (doubleCheck) {
				// 어느게 더 큰지 비교
				if (max < count) {
					max = count;
					for (int i = 1; i < visited.length; i++) {
						finalVisited[i] = visited[i];
					}
				}
			} else {
				max += count;
				for (int i = 1; i < visited.length; i++) {
					if (visited[i]) {
						finalVisited[i] = true;
					}
				}
			}
			return;
		}
		
		// 꼬임
		else if (visited[next]) {
			return;
		}
		
		visited[next] = true;
		dfs(givenArr[next][1], start);
	}
 
}
