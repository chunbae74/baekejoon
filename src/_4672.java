import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class _4672 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] arr = new boolean[10_000 + 1];
		for(int i = 1; i < arr.length; i++) cal(arr, i);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < arr.length; i++) {
			if (!arr[i]) sb.append(i).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static void cal(boolean[] arr, int num) {
		String s = Integer.toString(num);
		int sum = num;
		for(int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - '0';
		}
		if (sum > 10_000) return;
		else {
			arr[sum] = true;
			cal(arr, sum);
		}
	}

}
