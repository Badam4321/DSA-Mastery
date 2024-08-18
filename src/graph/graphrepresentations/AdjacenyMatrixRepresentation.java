package graph.graphrepresentations;
import java.util.Arrays;
import java.util.Scanner;
public class AdjacenyMatrixRepresentation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edges = sc.nextInt();
        int vertices = sc.nextInt();
        int[][] adjacencyMat = new int[vertices + 1][vertices + 1];
        for(int i = 0 ; i < edges ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjacencyMat[u][v] = 1;
            adjacencyMat[v][u] = 1;
        }
        System.out.println(Arrays.deepToString(adjacencyMat));

    }
}
