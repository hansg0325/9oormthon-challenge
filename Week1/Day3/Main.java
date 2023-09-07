package Week1.Day3;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i=0;i<T;i++){
			String[] input = br.readLine().split(" ");
			int num1 = Integer.parseInt(input[0]);
			int num2 = Integer.parseInt(input[2]);
			if(input[1].equals("+")){
				sum+=num1+num2;
			} else if(input[1].equals("-")){
				sum+=num1-num2;
			} else if(input[1].equals("*")){
				sum+=num1*num2;
			} else if(input[1].equals("/")){
				sum+=num1/num2;
			}
		}
		System.out.println(sum);
	}
}