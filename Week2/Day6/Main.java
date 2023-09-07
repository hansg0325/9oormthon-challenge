package Week2.Day6;
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		List<String> list = new ArrayList<>();
		List<String[]> arlist = new ArrayList<>();
		
		// 부분문자열배열 arlist에 등록, 존재할수 있는 모든 부분문자열 list 에 등록
		for(int i=1;i<N;i++){
			for(int j=i+1;j<N;j++){
				String first = S.substring(0,i);
				String second = S.substring(i,j);
				String third = S.substring(j,N);
				arlist.add(new String[]{first,second,third});
				list.add(first);
				list.add(second);
				list.add(third);
			}
		}
		// streamAPI를 이용한 list 중복요소 제거 및 정렬
		list = list.stream().distinct().collect(Collectors.toList());
		Collections.sort(list);
		
		//점수판 생성
		Map<String, Integer> map = new HashMap<>();
		for(int i=0;i<list.size();i++){
			map.put(list.get(i),i+1);
		}
		
		//최고점수 찾기
		int Maxscore = 0;
		for(String[] words : arlist) {
			int tmpscore = 0;
			for(String word : words) {
				tmpscore += map.get(word);
			}
			if(tmpscore>=Maxscore) {
				Maxscore = tmpscore;
			}
		}
		
		System.out.println(Maxscore);
	}
}