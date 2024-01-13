import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 참고 : https://st-lab.tistory.com/148
 * 포인트 : 뎃섬부분을 먼저 계산
 * 뺄셈을 기준으로 1차적으로 문자열을 분리해주고, 분리된 문자열들 각각에 포함된 정수 값들을 모두 더해준다.
 */
public class _1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		String[] numArr = s.split("-");

		int sum = 0;
		/*
		for (int i = 0; i < numArr.length; i++) {
			String idx = numArr[i];
			// 만약 숫자 1개로만 이루어졌다면
			if (!idx.contains("+")) {
				// 첫 번쨰 항이라면 더하기 (첫번째 항은 양수이므로)
				if (i == 0) {
					sum += Integer.parseInt(idx);									
				}
				else {
					sum -= Integer.parseInt(idx);
				}
			}
			// idx에 덧셈이 포함되어 있다면
			else {
				// 더하기로 이루어졌다면
				String[] nums = idx.split("\\+");
				for (int j = 0; j < nums.length; j++) {
					// 첫 번쨰 항이라면 더하기 (첫번째 항은 양수이므로)
					if (i == 0) {
						sum += Integer.parseInt(nums[j]);									
					}
					else {
						sum -= Integer.parseInt(nums[j]);
					}
				}
			}
		}
		*/
		
		// 깔끔한 풀이 by https://st-lab.tistory.com/148
		for (int i = 0; i < numArr.length; i++) {
			// 내부에서 덧셈의 합
			int temp = 0;
			String[] arr = numArr[i].split("\\+");
			
			for (int j = 0; j < arr.length; j++) {
				temp += Integer.parseInt(arr[j]);
			}
			
			// 만약 첫 번째 idx라면
			if (i == 0) {
				sum += temp;
			}
			else {
				sum -= temp;
			}
		}
		
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}

}
