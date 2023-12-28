public class DFSArrayGraph {
    static boolean[] visited;
    static int[][] staticGraph;
    public static void main(String[] args) {
        int[][] graph = {
                {0,1,1,0,0},
                {1,0,0,1,0},
                {1,0,0,1,1},
                {0,1,1,0,0},
                {0,0,1,0,0},
        };
        staticGraph = graph;
        visited = new boolean[graph.length];
        dfs(3);
    }

    static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i < staticGraph[start].length; i++){
            if (!visited[i] && staticGraph[start][i] == 1){
                dfs(i);
            }
        }
    }
}
