import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값 (소숫점 이하 첫째 자리에서 반올림한 값)
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값 (여러 개 있을 때에는 최빈값 중 두 번쨰로 작은 값)
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이 (범위 출력)
 *
 */

public class _2108 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 홀수
		int sum = 0; 
		HashMap<Integer, Integer> hm = new HashMap<>();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			hm.put(num, hm.getOrDefault(num, 0) + 1);
			al.add(num);
			sum += num;
		}
		Collections.sort(al);
		
		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(hm.entrySet());
		entryList.sort(Map.Entry.comparingByValue((e1, e2) -> {
			return e2 - e1;
		}));
		
		int secondNum = entryList.get(0).getKey();
		if (entryList.size() != 1) {
			if (entryList.get(0).getValue() == entryList.get(1).getValue()) { // 똑같은 값이 여러 개 있단 소리
				secondNum = getSecond(entryList);
			}			
		}
		int avg = (int)Math.round((double) sum / N);
		if (avg == -0) avg = 0;
		System.out.printf("%d\n%d\n%d\n%d", avg, al.get((N-1)/2), secondNum, (al.get(al.size() -1) - al.get(0)));
	}
	
	public static int getSecond(List<Map.Entry<Integer, Integer>> entryList) {
		int max = entryList.get(0).getValue();
		ArrayList<Integer> al = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry: entryList) {
			if (entry.getValue() != max) break;
			else al.add(entry.getKey());
		}
		Collections.sort(al);
		return al.get(1);
	}

}
