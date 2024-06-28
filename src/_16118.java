import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

// input 속도개선 함수 출처: https://tlo-developer.tistory.com/311
class Node_16118 implements Comparable<Node_16118> {
	int index;
	int cost;
	int state;
	
	Node_16118(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
	
	Node_16118(int index, int cost, int state) {
		this.index = index;
		this.cost = cost;
		this.state = state;
	}
	
	@Override
	public int compareTo(Node_16118 o) {
		if (this.cost < o.cost) {
			return -1;
		} else {
			return 1;
		}
	}
}

/*
 *  반례: https://www.acmicpc.net/board/view/48207
 *  in:
 *	5 5
 *	1 2 1
 *	2 3 1
 *	1 3 1
 *	1 4 1
 *	4 5 10000
 *
 *	out: 0
 */
public class _16118 {
	static final boolean isDebug = false;
	static int N;
	static final int INF = 4_000 * 100_000 * 2 + 1;
	static ArrayList<Node_16118>[] graph;
	static int[] distOfFox;
	static int[][] distOfWolf;
	
	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader(System.in);
		N = in.readInt();
		int M = in.readInt();
		graph = new ArrayList[N + 1];
		distOfFox = new int[N + 1];
		distOfWolf = new int[N + 1][2];
		
		for (int i = 1; i < N + 1; i ++) {
			graph[i] = new ArrayList<>();
			distOfFox[i] = INF;
			distOfWolf[i] = new int[] { INF, INF };
		}
		
		for (int m = 0; m < M; m++) {
			int A = in.readInt();
			int B = in.readInt();
			int C = in.readInt() * 2;
			graph[A].add(new Node_16118(B, C));
			graph[B].add(new Node_16118(A, C));
		}
		
		dikjstraForFox(1);
		dikjstraForWolf(1);
		
		int count = 0;
		for (int i = 2; i < N + 1; i++) {
			if (distOfFox[i] < Math.min(distOfWolf[i][0], distOfWolf[i][1])) {
				count = count + 1;
			}
		}
		
		System.out.println(count);
	}
	
	public static void dikjstraForFox(int start) {
		distOfFox[start] = 0;
		PriorityQueue<Node_16118> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
		pq.offer(new Node_16118(start, distOfFox[start]));
		while (!pq.isEmpty()) {
			int nowNode = pq.peek().index;
			int nowCost = pq.peek().cost;
			pq.poll();
			
			if (distOfFox[nowNode] < nowCost) {
				continue;
			}
			
			for (Node_16118 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;

				if (distOfFox[nextNode] > distOfFox[nowNode] + nextCost) {
					distOfFox[nextNode] = distOfFox[nowNode] + nextCost;
					pq.offer(new Node_16118(nextNode, distOfFox[nextNode]));
				}
			}
			
		}
	}
	
	public static void dikjstraForWolf(int start) {
		// distOfWolf[i][0] : preNode -> i까지 2배의 속도로 옴
		// distOfWolf[i][1] : preNode -> i까지 1/2배의 속도로 옴
		distOfWolf[start][1] = 0;
		// [node, distOfWolf[node][index], index]
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
		pq.offer(new int[] { start, distOfWolf[start][1], 1 });

		while (!pq.isEmpty()) {
			int nowNode = pq.peek()[0];
			int nowCost = pq.peek()[1];
			// 0 : preNode 에서 속도 두 배로 출발하여 nowNode 도착
			// 1 : preNode 에서 속도 1/2배로 출발하여 nowNode 도착
			int nowIdx = pq.peek()[2];
			// 0 : nowNode 에서 속도 두 배로 출발하여 nextNode 도착
			// 1 : nowNode 에서 속도 1/2배로 출발하여 nextNode 도착
			int nextIdx = (nowIdx == 0) ? 1 : 0;
			pq.poll();
			
			if (distOfWolf[nowNode][nowIdx] < nowCost) continue;
			
			for (Node_16118 next: graph[nowNode]) {
				int nextNode = next.index;
				int nextCost = next.cost;
				// 속도 계산
				if (nextIdx == 0) {
					nextCost /= 2;
				} else {
					nextCost *= 2;
				}
				
				if (distOfWolf[nextNode][nextIdx] > distOfWolf[nowNode][nowIdx] + nextCost) {
					distOfWolf[nextNode][nextIdx] = distOfWolf[nowNode][nowIdx] + nextCost;
					pq.offer(new int[] { nextNode, distOfWolf[nextNode][nextIdx], nextIdx });
				}
			}
		}
	}
	
	// INPUT 속도 증가
	// 함수출처: https://maivve.tistory.com/238
	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

}
