import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _20926 {
	static final int INF = Integer.MAX_VALUE >> 1;
<<<<<<< Updated upstream
	static final boolean isDebug = false;
=======
>>>>>>> Stashed changes
	static int X, Y;
	static int startX, startY, endX, endY;
	static int[][] graph;
	static int[][] dist;

	static PriorityQueue<int[]> pq;
<<<<<<< Updated upstream

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

=======
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
>>>>>>> Stashed changes
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		dist = new int[Y][X];
		/*
<<<<<<< Updated upstream
		 * -2 : ������ -1 : ����
		 */
		graph = new int[Y][X];

=======
		 * -2 : 구덩이
		 * -1 : 바위
		 */
		graph = new int[Y][X];
		
>>>>>>> Stashed changes
		for (int y = 0; y < Y; y++) {
			String input = br.readLine();
			for (int x = 0; x < X; x++) {
				dist[y][x] = INF;
				int c = input.charAt(x);
				if (c == 'R') {
					graph[y][x] = -1;
				} else if (c == 'T') {
					startX = x;
					startY = y;
					graph[y][x] = 0;
				} else if (c == 'E') {
					endX = x;
					endY = y;
					graph[y][x] = 0;
				} else if (c == 'H') {
					graph[y][x] = -2;
				} else {
					graph[y][x] = c - '0';
				}
			}
		}
<<<<<<< Updated upstream

=======
		
>>>>>>> Stashed changes
		// { nowX, nowY, dist[nowY][nowX] }
		pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[2], e2[2]));
		dist[startY][startX] = 0;
		for (int i = 0; i < 4; i++) {
<<<<<<< Updated upstream
			pq.offer(new int[] { startX, startY, dist[startY][startX], i });
		}

		int d = 0;

=======
			pq.offer(new int[] { startX, startY, dist[startY][startX], i});
		}
		
>>>>>>> Stashed changes
		while (!pq.isEmpty()) {
			int nowX = pq.peek()[0];
			int nowY = pq.peek()[1];
			int nowCost = pq.peek()[2];
			int nowDirection = pq.peek()[3];
			pq.poll();
<<<<<<< Updated upstream

			if (dist[nowY][nowX] < nowCost)
				continue;

			if (graph[nowY][nowX] < 0)
				continue;

			if (nowX == endX && nowY == endY)
				break;
			d++;
//         if (d > 20) break;
//         System.out.printf("nowX = %d\tnowY = %dnowCost = %d\tdist[nowY][nowX] = %d\tnowDirection = %d\n", nowX, nowY, nowCost, dist[nowY][nowX], nowDirection);
			move(nowX, nowY, nowDirection);
		}

		if (isDebug) {
			for (int y = 0; y < Y; y++) {
				for (int x = 0; x < X; x++) {
					System.out.print((dist[y][x] == INF ? "-" : dist[y][x]) + " ");
				}
				System.out.println();
			}
		}

=======
			
			if (dist[nowY][nowX] < nowCost) continue;
			
			if (graph[nowY][nowX] < 0) continue;
			
			if (nowX == endX && nowY == endY) break;
			
			move(nowX, nowY, nowDirection);
		}
		
>>>>>>> Stashed changes
		System.out.println(dist[endY][endX] == INF ? -1 : dist[endY][endX]);
	}

	/**
	 * @param direction 상하좌우(0,1,2,3)
<<<<<<< Updated upstream
	 * @return { endX, endY }
	 */
	public static void move(int nowX, int nowY, int direction) {
		boolean canGoToTheEdge = true;
		
=======
	 * @return { endX, endY }에 도착하였는지 여부
	 */
	public static void move(int nowX, int nowY, int direction) {
>>>>>>> Stashed changes
		int nowCost = dist[nowY][nowX];

		int nextCost = nowCost;
		// 상
		if (direction == 0) {
<<<<<<< Updated upstream
			for (int nextY = nowY - 1; nextY > 0; nextY--) {
				int nextX = nowX;
				if (graph[nextY][nextX] < 0) {
					canGoToTheEdge = false;
					return;
				}

				nextCost += (graph[nextY][nextX] >= 0 ? graph[nextY][nextX] : 0);
				
				// 앞에 바위가 있다면
				if (graph[nextY - 1][nextX] == -1) {
					canGoToTheEdge = false;
					if (dist[nextY][nextX] > nextCost) {
						dist[nextY][nextX] = nextCost;
						pq.offer(new int[] { nextX, nextY, dist[nextY][nextX], 2 });
						pq.offer(new int[] { nextX, nextY, dist[nextY][nextX], 3 });
						return;
					}
				}
				// 앞에 바위가 없다면
				else {
					if (dist[nextY][nextX] > nextCost) {
						dist[nextY][nextX] = nextCost;
					}
				}
			} // for문 끝
			
			// 가장 맨 끝 값 최신화
			if (graph[0][nowX] >= 0 && canGoToTheEdge) {
				nextCost += (graph[0][nowX] >= 0 ? graph[0][nowX] : 0);

				if (dist[0][nowX] > nextCost) {
					dist[0][nowX] = nextCost;
				}
			}
		}

		// 하
		else if (direction == 1) {
			for (int nextY = nowY + 1; nextY < Y - 1; nextY++) {
				int nextX = nowX;
				if (graph[nextY][nextX] < 0) {
					canGoToTheEdge = false;
					return;
				}

				nextCost += (graph[nextY][nextX] >= 0 ? graph[nextY][nextX] : 0);
				
				// 앞에 바위가 있다면
				if (graph[nextY + 1][nextX] == -1) {
					canGoToTheEdge = false;
					if (dist[nextY][nextX] > nextCost) {
						dist[nextY][nextX] = nextCost;
						pq.offer(new int[] { nextX, nextY, dist[nextY][nextX], 2 });
						pq.offer(new int[] { nextX, nextY, dist[nextY][nextX], 3 });
						return;
					}
				}
				// 앞에 바위가 없다면
				else {
					if (dist[nextY][nextX] > nextCost) {
						dist[nextY][nextX] = nextCost;
					}
				}
			} // for문 끝
			
			// 가장 맨 끝 값 최신화
			if (graph[Y - 1][nowX] >= 0 && canGoToTheEdge) {
				nextCost += (graph[Y - 1][nowX] >= 0 ? graph[Y - 1][nowX] : 0);

				if (dist[Y - 1][nowX] > nextCost) {
					dist[Y - 1][nowX] = nextCost;
				}
			}
		}

		// 좌
		else if (direction == 2) {
			for (int nextX = nowX - 1; nextX > 0; nextX--) {
				int nextY = nowY;
				if (graph[nextY][nextX] < 0) {
					canGoToTheEdge = false;					
					return;
				}

				nextCost += (graph[nextY][nextX] >= 0 ? graph[nextY][nextX] : 0);
				
				// 앞에 바위가 있다면
				if (graph[nextY][nextX - 1] == -1) {
					canGoToTheEdge = false;
					if (dist[nextY][nextX] > nextCost) {
						dist[nextY][nextX] = nextCost;
						pq.offer(new int[] { nextX, nextY, dist[nextY][nextX], 0 });
						pq.offer(new int[] { nextX, nextY, dist[nextY][nextX], 1 });
						return;
					}						
				}
				// 앞에 바위가 없다면
				else {
					if (dist[nextY][nextX] > nextCost) {
						dist[nextY][nextX] = nextCost;
					}
				}
			} // for문 끝
			
			// 가장 맨 끝 값 최신화
			if (graph[nowY][0] >= 0 && canGoToTheEdge) {
				nextCost += (graph[nowY][0] >= 0 ? graph[nowY][0] : 0);

				if (dist[nowY][0] > nextCost) {
					dist[nowY][0] = nextCost;
=======
			int nextY = nowY - 1;
			if (nextY < 0) return;
			if (graph[nextY][nowX] == -2) return;
				
			nextCost += (graph[nextY][nowX] >= 0 ? graph[nextY][nowX] : 0);
			if (dist[nextY][nowX] > nextCost) {
				// 방향전환 (좌, 우)
				if (graph[nextY][nowX] == -1) {
					pq.offer(new int[] { nowX, nextY + 1, dist[nextY + 1][nowX], 2 });
					pq.offer(new int[] { nowX, nextY + 1, dist[nextY + 1][nowX], 3 });
				} else {
					dist[nextY][nowX] = nextCost;
					pq.offer(new int[] { nowX, nextY, dist[nextY][nowX], 0 });
				}
			}
		} 
		
		// 하
		else if (direction == 1) {
			int nextY = nowY + 1;
			if (nextY >= Y) return;
			if (graph[nextY][nowX] == -2) return;
				
			nextCost += (graph[nextY][nowX] >= 0 ? graph[nextY][nowX] : 0);
			if (dist[nextY][nowX] > nextCost) {
				// 방향전환 (좌, 우)
				if (graph[nextY][nowX] == -1) {
					pq.offer(new int[] { nowX, nextY - 1, dist[nextY - 1][nowX], 2 });
					pq.offer(new int[] { nowX, nextY - 1, dist[nextY - 1][nowX], 3 });
				} else {
					dist[nextY][nowX] = nextCost;
					pq.offer(new int[] { nowX, nextY, dist[nextY][nowX], 1 });
				}
			}
		}
		
		// 좌
		else if (direction == 2) {
			int nextX = nowX - 1;
			if (nextX < 0) return;
			if (graph[nowY][nextX] == -2) return;
				
			nextCost += (graph[nowY][nextX] >= 0 ? graph[nowY][nextX] : 0);
			if (dist[nowY][nextX] > nextCost) {
				// 방향전환 (상, 하)
				if (graph[nowY][nextX] == -1) {
					pq.offer(new int[] { nextX + 1, nowY, dist[nowY][nextX + 1], 0 });
					pq.offer(new int[] { nextX + 1, nowY, dist[nowY][nextX + 1], 1 });
				} else {
					dist[nowY][nextX] = nextCost;
					pq.offer(new int[] { nextX, nowY, dist[nowY][nextX], 2 });
>>>>>>> Stashed changes
				}
			}
		}

		// 우
		else if (direction == 3) {
<<<<<<< Updated upstream
			for (int nextX = nowX + 1; nextX < X - 1; nextX++) {
				int nextY = nowY;
				if (graph[nextY][nextX] < 0) {
					canGoToTheEdge = false;
					return;
				}

				nextCost += (graph[nextY][nextX] >= 0 ? graph[nextY][nextX] : 0);
				
				// 앞에 바위가 있다면
				if (graph[nextY][nextX + 1] == -1) {
					canGoToTheEdge = false;
					if (dist[nextY][nextX] > nextCost) {
						dist[nextY][nextX] = nextCost;
						pq.offer(new int[] { nextX, nextY, dist[nextY][nextX], 0 });
						pq.offer(new int[] { nextX, nextY, dist[nextY][nextX], 1 });
						return;
					}
					
				}
				// 앞에 바위가 없다면
				else {
					if (dist[nextY][nextX] > nextCost) {
						dist[nextY][nextX] = nextCost;
					}
				}
			} //for 문 끝
			
			// 가장 맨 끝 값 최신화
			if (graph[nowY][X - 1] >= 0 && canGoToTheEdge) {
				nextCost += (graph[nowY][X - 1] >= 0 ? graph[nowY][X - 1] : 0);
	
				if (dist[nowY][X - 1] > nextCost) {
					dist[nowY][X - 1] = nextCost;
=======
			int nextX = nowX + 1;
			if (nextX >= X) return;
			if (graph[nowY][nextX] == -2) return;
				
			nextCost += (graph[nowY][nextX] >= 0 ? graph[nowY][nextX] : 0);
			if (dist[nowY][nextX] > nextCost) {
				// 방향전환 (상, 하)
				if (graph[nowY][nextX] == -1) {
					pq.offer(new int[] { nextX - 1, nowY, dist[nowY][nextX - 1], 0 });
					pq.offer(new int[] { nextX - 1, nowY, dist[nowY][nextX - 1], 1 });
				} {
					dist[nowY][nextX] = nextCost;
					pq.offer(new int[] { nextX, nowY, dist[nowY][nextX], 3 });
>>>>>>> Stashed changes
				}
			}
		}
	}
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
