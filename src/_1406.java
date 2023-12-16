import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stack = new Stack<>();
		String input = br.readLine();
		for(Character c: input.toCharArray()) stack.add(c);
		
		int M = Integer.parseInt(br.readLine());
		
		Character command; 
		Character text = '\u2000';
		int index = input.length();
		
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			command = s.charAt(0);
			
			switch(command) {
			case 'L' : // 왼쪽으로
				if (index != 0) index --;
				break;
				
			case 'D': // 오른쪽으로
				if (index != stack.size()) index ++;
				break;
				
			case 'B': // 왼쪽문자 삭제
				if (index == 0) break;
				stack.remove(--index);
				break;
				
			case 'P': // 문자 왼쪽에 추가
				text = s.charAt(2);
				stack.add(index++, text);
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character s: stack) sb.append(s);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
