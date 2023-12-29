import java.util.*;

public class GameMap {
    static boolean[] visited;
    static int[] distance;
    static List<List<Integer>> adjList;
    public static void main(String[] args) {
        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        int m = maps.length;
        int n = maps[0].length;
        visited = new boolean[n * m];
        distance = new int[n * m];
        adjList = new ArrayList<>();
        for (int i = 0; i < n * m; i++){
            adjList.add(new ArrayList<>());
        }
        Arrays.fill(distance, 1);

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (maps[i][j] == 0){
                    continue;
                }
                int[] dx = {-1, 1, 0, 0};
                int[] dy = {0, 0, -1, 1};
                for (int d = 0; d < 4; d++){
                    int target_i = i + dx[d];
                    int target_j = j + dy[d];
                    if (target_i >= 0 && target_i < m
                            && target_j >= 0 && target_j < n && maps[target_i][target_j] == 1){
                        addEdge((i) * n + j, (target_i) * n + target_j);
                    }
                }
            }
        }
        System.out.println(bfs(0, n * m -1));
    }

    static int bfs(int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            for (int target : adjList.get(vertex)){
                if (!visited[target]){
                    distance[target] = distance[vertex] + 1;
                    queue.add(target);
                    visited[target] = true;
                    if (target == end){
                        return distance[end];
                    }
                }
            }
        }
        return -1;
    }

    static void addEdge(int start, int end){
        adjList.get(start).add(end);
        adjList.get(end).add(start);
    }
}
