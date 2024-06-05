import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2224 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		final int INF = 100;
		final int LEN = 26;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[LEN * 2][LEN * 2];
		
		for (int i = 0; i < LEN * 2; i++) {
			for (int j = 0; j < LEN * 2; j++) {
				if (i == j) continue;
				else dist[i][j] = INF;
			}
		}
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			char A = input.charAt(0);
			char B = input.charAt(input.length() - 1);
			
			// P => P
			if (A == B) continue;
			
			int idxA, idxB;
			idxA = idxB = 0;
			if ('A' <= A && A <= 'Z') idxA = A - 'A';
			else if ('a' <= A && A <= 'z') idxA = A - 'a' + LEN;
			if ('A' <= B && B <= 'Z') idxB = B - 'A';
			else if ('a' <= B && B <= 'z') idxB = B - 'a' + LEN;
		
			// idxA -> idxB
			dist[idxA][idxB] = 1;
		}
		
		for (int k = 0; k < LEN * 2; k++) {
			for (int i = 0; i < LEN * 2; i++) {
				for (int j = 0; j < LEN * 2; j++) {
					if (i == j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		
		int count = 0;
		for (int i = 0; i < LEN * 2; i++) {
			for (int j = 0; j < LEN * 2; j++) {
				if (i == j) continue;
				if (dist[i][j] == INF) continue;
				count ++;
				char A = getCharForNumber(i);
				char B = getCharForNumber(j);
				sb.append(A).append(" => ").append(B).append("\n");
			}
		}
		
		bw.write(count + "\n" + sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static char getCharForNumber(int i) {
		if (0 <= i && i < 26) 
			return String.valueOf((char)(i + 65)).charAt(0);
		else 
			return String.valueOf((char)(i + 97 - 26)).charAt(0);
	}

}
