package Week3.Day15;
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] count = new int[N];
		long answer = 0; // 범위가 int 의 범위를 초과하는 경우도 있어서 long 으로 선언
		Map<Integer, Integer> map = new HashMap<>();
		
		//과일의 개수는 배열에 담고, 과일 1조각당 포만감은 맵에 담는다. 맵의 키는 과일 개수의 인덱스와 같다.
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(p==1) {
				map.put(i, c);
				count[i] = p;
			} else {
				map.put(i, c/p);
				count[i] = p;
			}
		}
		//1조각당 포만감이 높은 순으로 내림차순한다
		List<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
		//keys는 내림차순으로 정렬되어있기때문에 foreach문으로 keys 를 순회
		for(Integer key : keys){
			//K가 0이 될경우 break
			if(K==0){
				break;
			}
			//포만감이 높은 순으로 과일의 개수에서 하나씩 빼면서 answer에 더한다. K가 0이 될경우 break
			for(int i=0;i<count[key];i++) {
				answer+=map.get(key);
				K--;
				if(K==0){
					break;
				}
			}
		}
		System.out.println(answer);
	}
}