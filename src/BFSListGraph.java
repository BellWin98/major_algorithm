import java.util.*;

public class BFSListGraph {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) {
        int[][] inputArr = {{0,1}, {0,2}, {1,3}, {2,3}, {2,4}};
        int N = 5;
        visited = new boolean[N];
        distance = new int[N];
        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++){
            adjList.add(new ArrayList<>());
        }
        for (int[] a : inputArr){
            addEdge(a[0], a[1]);
        }
        /*
        i: 세로 길이, 행의 개수
        j: 가로 길이, 열의 개수
            1) 시작 노드 표현식
                - (0,0) 시작 → i * 열의 개수 + j + 1
                - (1,1) 시작 → (i - 1) * 열의 개수 + j
            2) 타겟의 번호 (인덱스가 아니라 데이터 값)
                - 상: (i - 1 - 1) * 열의 개수 + j
                - 하: (i - 1 + 1) * 열의 개수 + j
                - 좌: (i - 1) * 열의 개수 + j - 1
                - 우: (i - 1) * 열의 개수 + j + 1
            3) 타겟의 유효성: 인덱스 i와 j의 상하좌우 길이 체크
                - 상: if (i - 1) >= 1
                - 하: if (i + 1) <= 3 (행의 개수)
                - 좌: if (j - 1) >= 1
                - 우: if (j + 1) <= 5 (열의 개수)
            4) 상하좌우 체크 로직 (if 4개 나열한거랑 동일한 코드)
            */
//        for (int i = 1; i <= 3; i++){
//            for (int j = 1; j <= 5; j++){
//                int[] dx = {-1, 1, 0, 0};
//                int[] dy = {0, 0, -1, 1};
//                for (int d = 0; d < 4; d++){
//                    int target_i = i + dx[d];
//                    int target_j = j + dy[d];
//                    if (target_i >= 1 && target_i <= 3 && target_j >= 1 && target_j <= 5){
//                        addEdge((i -1) * 5 + j, (target_i - 1) * 5 + target_j);
//                    }
//                }
//            }
//        }
//        System.out.print("BFS 순서: ");
//        bfs(0);
//        System.out.println();
//        System.out.print("거리: ");
//        Arrays.stream(distance).forEach(a -> System.out.print(a + " "));

        // 최단 거리
        int shortest = bfs(0, 4);
        System.out.println("최단거리: " + shortest);
    }

    static void addEdge(int start, int end){
        adjList.get(start).add(end);
        adjList.get(end).add(start); // 단방향으로 주어졌을 때 사용
    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        // target: List안에 들어가 있는 값
        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // 실질적으로 방문
            System.out.print(vertex + " ");
            for (int target : adjList.get(vertex)){
                if (!visited[target]){
                    distance[target] = distance[vertex] + 1;
                    queue.add(target); // 방문 예정인 데이터를 큐에 담음
                    visited[target] = true;
                }
            }
        }
    }

    static int bfs(int start, int destination){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        // target: List안에 들어가 있는 값
        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // 실질적으로 방문
            System.out.print(vertex + " ");
            for (int target : adjList.get(vertex)){
//                if (target == destination){
//                    System.out.print(target + " ");
//                    return distance[++vertex];
//                }
                if (!visited[target]){
                    distance[target] = distance[vertex] + 1;
                    queue.add(target); // 방문 예정인 데이터를 큐에 담음
                    visited[target] = true;
                    if (target == destination){
                        System.out.print(target + " ");
                        return distance[destination];
                    }
                }

            }
        }
        return -1;
    }
}
