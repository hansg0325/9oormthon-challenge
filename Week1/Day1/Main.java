package Week1.Day1;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		double W = Double.parseDouble(input[0]);
		double R = Double.parseDouble(input[1]);
		int answer = (int)Math.floor(W*(1+R/30));

		System.out.println(answer);
	}
}