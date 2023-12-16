import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _4779 {
	static int n;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		
		while ((str = br.readLine()) != null) {
			n = Integer.parseInt(str);
			int len = (int)Math.pow(3, n);
			sb = new StringBuilder();
			for (int i = 0; i < len; i++) {
				sb.append("-");
			}
			
			division(0, len);
			System.out.println(sb);
		}
	}
	
	public static void division(int start, int size) {
		if (size == 1) return;
		
		int newSize = size / 3;
		
		for (int i = start + newSize; i < start + 2*newSize; i++) {
			sb.setCharAt(i, ' ');
		}
		
		// System.out.println("before : " + sb.toString());
		division(start, newSize);
		// System.out.println("mid : " + sb.toString());
		division(start + 2*newSize, newSize);
		// System.out.println("after : " + sb.toString());
		// System.out.println();
		//System.out.println();
	}
	
}
