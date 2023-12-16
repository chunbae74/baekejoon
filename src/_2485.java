import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 나무 사이들의 거리를 distance 배열에 저장하고
 * distance 수들의 최대공약수 구하기.
 *
 */
public class _2485 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> tree = new ArrayList<>();
//		ArrayList<Integer> distance = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			tree.add(num);
		}
		Collections.sort(tree);

		int gcd = 0;
		for(int i = 1; i < tree.size(); i++) {
			int d = tree.get(i) - tree.get(i - 1);
			gcd = gcd(Math.min(gcd, d), Math.max(gcd, d));
//			if(!distance.contains(d)) distance.add(d);
		}
		
//		Collections.sort(distance);
		
//		distance = cal(distance);
//		if (distance.size() == 1) gcd = distance.get(0);
//		else gcd = gcd(distance.get(0), distance.get(1));
//		bw.write("gcd = " + gcd + "\n");
		// 갯수 = ((맨 끝 값 - 맨 처음 값 ) / gcd) + 1 - N
		bw.write(((tree.get(N - 1) - tree.get(0)) / gcd) + 1 - N + "");
		bw.flush();
		bw.close();
		
	}
	
	public static ArrayList cal(ArrayList<Integer> arr) {
		if (arr.size() < 3) return arr;
		else {
			ArrayList<Integer> cal = new ArrayList<>();
			for(int i = 1; i < arr.size(); i++) {
				int result = arr.get(i) - arr.get(i-1);
				if (!cal.contains(result)) cal.add(result);
			}
			arr = cal;
			return cal(arr);
		}
	}
	
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a%b);
	}
}
