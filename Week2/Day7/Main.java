package Week2.Day7;
import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++){
				if(Integer.parseInt(st.nextToken())==1) {
					arr[i][j] = -1;
				} else {
					arr[i][j] = 0;
				}
			}
		}
		for(int i=0;i<N;i++){
			int score = 0;
			for(int j=0;j<N;j++){
				if(arr[i][j]==0){
					if(i-1>=0){
						if(arr[i-1][j]==-1) arr[i][j]++;
					}
					if(i+1<N){
						if(arr[i+1][j]==-1) arr[i][j]++;
					}
					if(j-1>=0){
						if(arr[i][j-1]==-1) arr[i][j]++;
					}
					if(j+1<N){
						if(arr[i][j+1]==-1) arr[i][j]++;
					}
					if(i-1>=0 && j-1>=0){
						if(arr[i-1][j-1]==-1) arr[i][j]++;
					}
					if(i-1>=0 && j+1<N){
						if(arr[i-1][j+1]==-1) arr[i][j]++;
					}
					if(i+1<N && j-1>=0){
						if(arr[i+1][j-1]==-1) arr[i][j]++;
					}
					if(i+1<N && j+1<N){
						if(arr[i+1][j+1]==-1) arr[i][j]++;
					}
				}
			}
		}
		
		int answer = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(arr[i][j]==K) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}