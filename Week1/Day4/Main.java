package Week1.Day4;
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] k = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
		int Max = 1;
		int cur = 0;
		int point = 0;
		for(int i=0;i<N;i++) {
			if(k[i]>=Max) {
				Max=k[i];
				cur = i;
			}
		}
		int tmp = k[cur];
		for(int i=cur;i<N;i++){
			if(k[i]<=tmp) {
				point+=k[i];
				tmp = k[i];
			} else {
				point = 0;
				break;
			}
		}
		if(point!=0) {
			tmp = k[cur];
			for(int i=cur-1;i>=0;i--){
				if(k[i]<=tmp) {
					point+=k[i];
					tmp = k[i];
				} else {
					point = 0;
					break;
				}
			}
		}
		System.out.println(point);
	}
}