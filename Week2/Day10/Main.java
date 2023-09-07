package Week2.Day10;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());

        //goorm과 player의 시작 위치 생성
        st = new StringTokenizer(br.readLine(), " ");
        int[] goormPos = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        //bolean 배열은 기본적으로 false로 초기화된다
        boolean[][] goormVisited = new boolean[N][N];
        st = new StringTokenizer(br.readLine(), " ");
        int[] playerPos = {Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1};
        boolean[][] playerVisited = new boolean[N][N];


        //보드판 생성
        String[][] board = new String[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = st.nextToken();
            }
        }
        int goormScore = move(goormPos, goormVisited, 1, board, N);
        int playerScore = move(playerPos, playerVisited, 1, board, N);

        if (goormScore > playerScore) {
            System.out.println("goorm " + goormScore);
        } else if (goormScore < playerScore) {
            System.out.println("player " + playerScore);
        }
        
    }

        //dx/dy 기법을 사용해 행렬에서 방향을 관리, 문제가 문자열형태로 주기때문에 map을 사용

    static HashMap<String, int[]> directions = new HashMap<String, int[]>() {
        {
            put("U", new int[]{-1, 0});
            put("D", new int[]{1, 0});
            put("L", new int[]{0, -1});
            put("R", new int[]{0, 1});
        }
    };


        //좌표에서 이동을 하다 보드판을 넘어갔을 경우 반대편으로 넘어가는 함수
        static int setPos(int a,int N) {
            if (a == -1) return N - 1;
            if(a == N) return 0;
            return a;
        }

        //게임을 진행하다 종료됬을때의 점수를 return 해주는 함수
        static int move(int[] pos, boolean[][] visited, int score, String[][] board, int N) {

            //말의 위치
            int x = pos[0];
            int y = pos[1];
            //방문한 위치는 true로 전환
            visited[x][y] = true;
            //score는 초기에 1점

            boolean flag = true;
            //flag가 false가 되면 while문 종료
            while(flag) {
                String command = board[x][y];
                //command의 첫번째 문자
                int distance = Integer.parseInt(command.substring(0, command.length() - 1));
                //command의 두번째 문자
                String direction = command.substring(command.length() - 1);
                //distance만큼 direction 방향으로 이동
                for(int i=0;i<distance;i++) {
                    //이 부분이 약간 이해가 헷갈린다
                    x+=directions.get(direction)[0];
                    y+=directions.get(direction)[1];
                    x = setPos(x, N);
                    y = setPos(y, N);

                    if(!visited[x][y]){
                        visited[x][y] = true;
                        score++;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            return score;
        }

}