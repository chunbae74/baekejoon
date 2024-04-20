import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 테케모음 : https://www.acmicpc.net/board/view/139960
 *         https://www.acmicpc.net/board/view/134925
 */
public class _1107 {
	// targetChannel 길이
	static int inputDepth;
	// 이동하려고 하는 채널
	static int targetChannel;
	static int[] arr;
	static int min;
	
	static boolean isDebug = false;
	static ArrayList<Integer> al = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		inputDepth = input.length();
		targetChannel = Integer.parseInt(input);
		
		arr = new int[inputDepth + 1];
		// 고장난 숫자 버튼 개수
		int M = Integer.parseInt(br.readLine());
		
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				al.add(Integer.parseInt(st.nextToken()));
			}			
		}
		
		min = Math.abs(targetChannel - 100);
		
		// min 이 0이면 그 자체로 최소이므로 계산할 필요 X
		if (min != 0) dfs(0);
		
		bw.write(min + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int depth) {
		if (depth == inputDepth + 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < depth; i++) {
				sb.append(arr[i]);
			}
			int result = Integer.parseInt(sb.toString());
			int cal = (Integer.toString(result).length()) + Math.abs(targetChannel - result);
			if (cal > 0 && min > cal) {
				if (isDebug) {
					System.out.printf("min = %d\tresult = %d\n", cal, result);
				}
				
				min = cal;
			}
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			// 망가진버튼
			if (al.contains(i)) {
				// 숫자 0버튼인 경우
				if (i == 0 && depth < inputDepth) {
					// 앞자리 숫자들이 모두 0인가
					boolean isZero = true;
					Loop1: for (int d = 0; d < depth; d++) {
						if (arr[d] != 0) {
							isZero = false;
							break Loop1;
						}
					}
					// 앞자리에 0이 없는경우 pass (자릿수에 변동이 없는경우)
					if (!isZero) continue;
				}
				// 다른 숫자의 경우 pass
				else continue;
			}
			arr[depth] = i;
			dfs(depth + 1);
		}
	}

}
