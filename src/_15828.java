import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class _15828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		while(true) {
			int num = Integer.parseInt(br.readLine());
			
			if (num == -1) break;
			
			if (queue.size() >= N && num != 0) continue; // 용량 초과일경우 데이터 안받음
			else {
				if (num == 0) { // 패킷 하나를 처리했음
					queue.poll();
				}
				else {
					queue.offer(num);
				}
			}
		}
		
		if (queue.size() < 1) bw.write("empty");
		else {
			StringBuilder sb = new StringBuilder();
			for(int num: queue) sb.append(num).append(" ");
			bw.write(sb.toString());			
		}
		bw.flush();
		bw.close();
	}

}
