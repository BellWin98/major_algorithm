import java.util.*;

public class FarNode {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        };

        visited = new boolean[n];
        distance = new int[n];
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for (int[] a : edge){
            addEdge(a[0] - 1, a[1] - 1);
        }
        bfs(0);
        Arrays.sort(distance);
        int max = distance[distance.length - 1];
        int count = 0;
        for (int number : distance){
            if (number == max){
                count++;
            }
        }
        System.out.println(count);
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

    static void addEdge(int start, int end){
        adjList.get(start).add(end);
        adjList.get(end).add(start); // 단방향으로 주어졌을 때 사용
    }
}
