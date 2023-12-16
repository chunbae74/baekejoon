import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _10757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		int[] num1 = new int[10_000 + 1];
		int[] num2 = new int[10_000 + 1];
		int index1 = 0, index2 = 0;
		for(int i = s1.length()-1; i >= 0; i--) num1[index1++] = s1.charAt(i)-'0';
		for(int i = s2.length()-1; i >= 0; i--) num2[index2++] = s2.charAt(i)-'0';
		boolean isOver = false;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Math.max(index1, index2); i++) {
			int sum = num1[i] + num2[i];
			if (isOver) sum += 1;
			
			if (sum >= 10) {
				isOver = true;
				sum -= 10;
			} else isOver = false;
			
			sb.append(sum);
		}
		if(isOver) sb.append("1");
		bw.write(sb.reverse().toString());
		bw.flush();
		bw.close();
	}

}
