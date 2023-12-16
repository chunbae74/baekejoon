import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A_LEN = Integer.parseInt(st.nextToken());
		int B_LEN = Integer.parseInt(st.nextToken());
		HashSet<Integer> A = new HashSet<>(); // 집합 A
		HashSet<Integer> B = new HashSet<>(); // 집합 B
		HashSet<Integer> Co = new HashSet<>(); // A와 B의 교집합
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < A_LEN; i++) {
			int num = Integer.parseInt(st.nextToken());
			A.add(num);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B_LEN; i++) {
			int num = Integer.parseInt(st.nextToken());
			B.add(num);
			if (A.contains(num)) Co.add(num);
		}
		int num1 = A.size() - Co.size();
		int num2 = B.size() - Co.size();
		bw.write(num1 + num2 + "");
		bw.flush();
		bw.close();
	}
}
