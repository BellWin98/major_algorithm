import java.util.ArrayList;
import java.util.List;

public class DFSListGraph {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) {
        int[][] inputArr = {{0,1}, {0,2}, {1,3}, {2,3}, {2,4}};
        int N = 5;
        visited = new boolean[N];
        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++){
            adjList.add(new ArrayList<>());
        }
        for (int[] a : inputArr){
            addEdge(a[0], a[1]);
        }
        dfs(1);
    }

    static void addEdge(int start, int end){
        adjList.get(start).add(end);
        adjList.get(end).add(start); // 단방향으로 주어졌을 때 사용
    }

    static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");
        for (int target : adjList.get(start)){
            if (!visited[target]){
                dfs(target);
            }
        }
    }
}
