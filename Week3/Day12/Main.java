package Week3.Day12;
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[][] M = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int count = 0;
		// dx/dy기법
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// dx/dy 기법을 사용한 탐색 및 큐를 사용한 탐색 후보 관리
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				//[i][j] 가 1이고 visited가 false인 자리 탐색
				if(M[i][j] == 1 && visited[i][j] == false) {
					//첫 번째 탐색 후보 생성
					//visited 변수 갱신
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[]{i, j});
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						//poll = 큐 첫번째 값을 반환하고 제거
						int[] current = q.poll();
						
						//상,하,우,좌 탐색
						for(int k=0;k<4;k++) {
							int nextX = current[0] + dx[k];
							int nextY = current[1] + dy[k];
							//탐색하는 4방 좌표가 범위를 벗어나는지 아닌지
							if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
								//새롭게 4방 탐색한 좌표가 조건에 해당하는지
								if(M[nextX][nextY] == 1 && visited[nextX][nextY] == false) {
									//새롭게 탐색한 좌표들도 조건에 해당한다면 탐색후보에 추가한다.
									q.add(new int[]{nextX, nextY});
									visited[nextX][nextY] = true;
								}
							}
						}
					}
					//탐색이 끝나면 count++;
					count++;
				}
			}
		}
		System.out.println(count);
	}
}