package Week3.Day11;
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Integer N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		Integer A = Integer.parseInt(st.nextToken());
		Integer B = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N+1];
		
		//풀이에서는 MAX_VALUE로 초기화 했다. MAX_VALUE 가 아니라 N보다 큰값이면 다 가능하지 않을까 생각한다.
		for(int i=0;i<=N;i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		
		for(int i=0;i<=N;i++) {
			if(i-A>=0 && dp[i-A] != Integer.MAX_VALUE) {
				dp[i] = Math.min(dp[i], dp[i-A] + 1);
			}
			//N-A 를 했을때보다 횟수가 더 적을경우 N-B로 한것을 선택한다.
			if(i-B>=0 && dp[i-B] != Integer.MAX_VALUE) {
				dp[i] = Math.min(dp[i], dp[i-B] + 1);
			}
		}
		
		//for문 끝까지 돌렸을때 dp[N] 값이 여전히 MAX_VALUE라면 -1을 출력한다.
		System.out.println(dp[N] != Integer.MAX_VALUE ? dp[N] : -1);
	}
}