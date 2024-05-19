import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _31859 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
		String originName = st.nextToken();
      
		boolean[] arr = new boolean[26];
        int count = originName.length();
        
        // step 1
		for (int i = 0; i < originName.length(); i++) {
			char c = originName.charAt(i);
            if (!arr[c - 'a']) {
                sb.append(c);
                arr[c - 'a'] = true;
                count --;
            }
        }
		
		// step 2
        sb.append(count + 4);
        // step 3
        sb.insert(0, N + 1906);
        // step 4
        sb = sb.reverse();
        // step 5
        sb.insert(0, "smupc_");
		
        bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}