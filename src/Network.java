public class Network {
    static int answer = 0;
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++){
            dfs(computers, visited, i);
        }
        System.out.println(n - answer);
    }

    static void dfs(int[][] computers, boolean[] visited, int start){
        visited[start] = true;
        for (int i = 0; i < computers[start].length; i++){
            if (!visited[i] && computers[start][i] == 1){
                answer++;
                dfs(computers, visited, i);
            }
        }
    }
}
