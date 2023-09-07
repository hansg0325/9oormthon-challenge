package Week2.Day9;
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String[][] map = new String[N][N];
		int[][] score = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				map[i][j] = st.nextToken();
				score[i][j] = 0;
			}
		}
		
		int max = 0;
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			if(y-1>=0){
				if(map[y-1][x].equals("@")){
					score[y-1][x]+=2;
				} else if (map[y-1][x].equals("0")){
					score[y-1][x]++;
				}
			}
			if(y+1<N){
				if(map[y+1][x].equals("@")){
					score[y+1][x]+=2;
				} else if (map[y+1][x].equals("0")){
					score[y+1][x]++;
				}
			}
			if(x-1>=0){
				if(map[y][x-1].equals("@")){
					score[y][x-1]+=2;
				} else if (map[y][x-1].equals("0")){
					score[y][x-1]++;
				}
			}
			if(x+1<N){
				if(map[y][x+1].equals("@")){
					score[y][x+1]+=2;
				} else if (map[y][x+1].equals("0")){
					score[y][x+1]++;
				}
			}
			if(map[y][x].equals("@")){
				score[y][x]+=2;
			} else if (map[y][x].equals("0")) {
				score[y][x]++;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(score[i][j]>=max) {
					max=score[i][j];
				}
			}
		}
		System.out.println(max);
		
	}
}