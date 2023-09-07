package Week1.Day2;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int T = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int sum = M;
		for(int i=0;i<N;i++){
			int c = Integer.parseInt(br.readLine());
			sum += c;
		}
		M=sum%60;
		T=T+sum/60;
		T=T%24;
		System.out.println(T + " " + M);
		
	}
}