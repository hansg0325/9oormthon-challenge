package Week3.Day13;
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] M = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int[] score = new int[31]; //유형의 범위는 1~30이기 때문
		// dx/dy기법
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				//건물의 유형이 0이 아니고 방문하지 않은 장소
				if(M[i][j] != 0 && visited[i][j] == false) {
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[]{i, j});
					visited[i][j] = true;
					
					//단지의 크기 최소 1, 건물의 유형(1~30)
					int size = 1;
					int target = M[i][j];
					
					while(!q.isEmpty()){
						int[] current = q.poll();
						for(int k=0;k<4;k++) {
							//상,화,우,좌 탐색
							int nextX = current[0] + dx[k];
							int nextY = current[1] + dy[k];
							
							//맵 범위 안에있을경우
							if(nextX >= 0 && nextY < N && nextX >= 0 && nextY < N){
								//방문한 곳이 아니고 해당 위치가 큐에 들어간 유형과 같은 유형일 경우
								if(visited[nextX][nextY] == false && M[nextX][nextY] == target){
									visited[nextX][nextY] = true;
									q.add(new int[]{nextX, nextY});
									//단지의 크기 증가
									size++;
								}
							}
						}
					}
					//특정 유형으로 탐색 종료 후 크기가 K 보다 클 경우 해당 건물 유형점수 증가
					if(size >= K){
						score[target]++;
					}
				}
			}
		}
		//모든 탐색 종류 후 건물의 유형중 점수가 가장 높은것을 출력
		int maxScore = 0;
		//건물 점수가 같다면 건물유형이 큰것을 선택하기 때문에 뒤에서부터 탐색
		for(int i=30;i>=0;i--){
			if(score[i]>score[maxScore]){
				maxScore = i;
			}
		}
		System.out.println(maxScore);
	}
}