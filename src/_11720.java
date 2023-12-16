import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		// getBytes() 사용. getBytes()는 문자열을 byte 배열로 반환함
		int sum = 0;
		for (int num: br.readLine().getBytes()) sum += (num - '0');
		/*
		 * chatAt() 사용
		String s = br.readLine();
		for (int i = 0; i<N; i++) sum += (s.charAt(i) - '0');
		*/
		
		/* 
		 * 배열 사용
		String[] arr = br.readLine().split("");
		for(int i = 0; i<arr.length; i++) sum += Integer.parseInt(arr[i]);
		*/
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}

}
