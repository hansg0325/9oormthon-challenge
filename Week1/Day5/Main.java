package Week1.Day5;
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(input[i]));
		}
		
		Collections.sort(list, new Comparator<Integer>(){
			@Override //Override 어노테이션은 필수가 아니지만 실수하지 않기 위해 권장된다고 한다. 필수라고 생각하자.
			public int compare(Integer o1, Integer o2){
				//Integer.bitCount(int) 라는 함수를 사용. int의 수를 2진수로 변환 후 1의 개수를 세서 반환한다.
				int binaryO1 = Integer.bitCount(o1);
				int binaryO2 = Integer.bitCount(o2);
				//1의 개수가 같을 때, 10진수 기준으로 내림차순
				if(binaryO1 == binaryO2) {
					return o2 - o1;
				} else {
					//아닐 경우 2진수 1의 개수 기준으로 내림차순
					return binaryO2 - binaryO1;
				}
			}
		});
			
		System.out.println(list.get(K-1));
			
	}
}