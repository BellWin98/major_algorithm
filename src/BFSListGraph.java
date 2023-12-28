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
        bfs(0);
        System.out.println();
        // 최단 거리
        Arrays.stream(distance).forEach(System.out::println);

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
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int target : adjList.get(vertex)){
                if (!visited[target]){
                    distance[target] = distance[vertex] + 1;
                    queue.add(target);
                    visited[target] = true;
                }
            }
        }
    }
}
