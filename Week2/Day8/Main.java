package Week2.Day8;
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int answer = 0;
		while(N!=0) {
			if(N-14>=0) {
				N-=14;
				answer++;
			} else if (N-7>=0) {
				N-=7;
				answer++;
			} else if(N-1>=0){
				N-=1;
				answer++;
			}
		}
		System.out.println(answer);
	}
}