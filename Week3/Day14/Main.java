package Week3.Day14;
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //노드 개수
		int M = Integer.parseInt(st.nextToken()); //간선 개수
		int K = Integer.parseInt(st.nextToken()); //시작 노드 번호
		Map<Integer, List<Integer>> map = new HashMap<>(); //map을 활용해 key에 노드, value에 간선을 list로 넣는다
		boolean[] visited = new boolean[N+1]; //0부터 시작이 아닌 1부터 시작하기 때문에 N+1 개 배열 생성, 기본값 false
		
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(!map.containsKey(s)){ //해당 노드로 시작하는 map이 없을경우 새로 생성 
				map.put(s,new ArrayList<>());
			}
			if(!map.containsKey(e)){
				map.put(e,new ArrayList<>());
			}
			map.get(s).add(e); //해당 노드에 간선list에 추가
			map.get(e).add(s);
		}
		
		Queue<Integer> q = new LinkedList<>(); //탐색을 위한 큐 생성
		q.add(K); //큐에 탐색할 노드 추가
		int answer = 0; //방문한 노드 개수
		int currentNode = K; //현재 노드
		while(!q.isEmpty()){
			currentNode = q.poll(); 
			answer++;
			visited[currentNode] = true; //방문한 노드는 true 로 변경
			List<Integer> tmpNodes = map.get(currentNode); //현재 노드의 list를 tmpNodes 로 생성
			if(tmpNodes != null && !tmpNodes.isEmpty()){ //list 가 존재하거나 혹은 존재하고 list가 들어있을때
				Collections.sort(tmpNodes); //정렬을 한다, 정렬을 하지 않을 경우 작은 노드 순서가 아닌 무작위로 조회가 되어 오답이 나온다
				for(int nextNode : tmpNodes){ //foreach 문으로 리스트 순회
					if(visited[nextNode]==false) { //방문하지 않는 노드일 경우
						q.add(nextNode); //while(!q.isEmpty()) 이기 때문에 q.add를 하여 다시 탐색할 노드를 집어 넣는다
						break; //break 문으로 빠져나와 다시 while 문을 수행한다.
					}
				}
			}
		}
		System.out.println(answer + " " + currentNode);
	}
}