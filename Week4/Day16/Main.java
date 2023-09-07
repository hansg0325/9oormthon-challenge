package Week4.Day16;
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] bridges = new boolean[N+1][N+1];
		boolean[] visited = new boolean[N+1];//default == false
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			bridges[s][e] = true;
		}
		int count = 0;
		for(int i=1;i<=N;i++){
			if(visited[i]==false){
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			
			while(!q.isEmpty()){
				int currentNode = q.poll();
				visited[currentNode] = true;
				
				for(int nextNode=1;nextNode<=N;nextNode++){
					if(bridges[currentNode][nextNode] == true && 
						 bridges[nextNode][currentNode] == true && 
						 visited[nextNode] == false){
						q.add(nextNode);
					}
				}
			}
			count++;
		}
		}
		System.out.println(count);
	}
}