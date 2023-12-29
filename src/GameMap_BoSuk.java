import java.util.Arrays;
import java.util.LinkedList;

public class GameMap_BoSuk {
    static int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int n ,m;
    static int[][] visited;

    static class Node {
        int x ;
        int y ;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];

        LinkedList<Node> Q = new LinkedList<>();
        Q.add(new Node(0, 0));
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }

        visited[0][0] = 1;

        while (!Q.isEmpty()) {
            Node node = Q.poll();
            for (int[] direction : move) {
                int nx = node.x + direction[0];
                int ny = node.y + direction[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] == -1 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[node.x][node.y] + 1;
                    Q.add(new Node(nx, ny));
                }
            }
        }
        System.out.println(visited[n-1][m-1]);
    }
}
