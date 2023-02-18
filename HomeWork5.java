package Lesson5;
// Волновой алгоритм
import org.w3c.dom.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class HomeWork5 {
    int x, y, dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

}

class Util {
    private static final int M = 10;
    private static final int N = 10;
    private static final int row[] = {-1, 0, 0, 1};
    private static final int col[] = {0, -1, 1, 0};

    private static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
        return (row >= 0) && (row < M) && (col >= 0) && (col < N) && mat[row][col] == 1 && !visited[row][col];
    }

    private static void BFS(int[][] mat, int i, int j, int x, int y) {
        boolean[][] visited = new boolean[M][N];
        Queue<Node> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.add(new Node(i, j, 0));
        int min_dist = Integer.MAX_VALUE;

        while (lq.isEmpty()) {
            Node node = q.poll();
            i = node.x;
            j = node.y;
            int dist = node.dist;

            if (i == x && j == y) {
                min_dist = dist;
                break;
            }
            for (int k = 0; k < 4; k++) {
                if (isValid(mat, vizited, i + row[k], j + col[k])) {
                    vizited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }
        if (min_dist != Integer.MAX_VALUE) {
            System.out.println("Кратчайший путь:" + min_dist);
        } else {
            System.out.println("Путь назначения не может быть достигнут");
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1, 1, 1, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 1}
        };

        BFS(mat, 0, 0, 7, 5);
    }

}


