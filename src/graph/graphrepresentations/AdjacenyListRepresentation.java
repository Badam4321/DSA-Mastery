package graph.graphrepresentations;
import java.util.*;

public class AdjacenyListRepresentation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//no of vertices
        int m = sc.nextInt();//no of edges
        List<List<Integer>> gr = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            gr.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++){
            int u = sc.nextInt();//starting vertex of edge
            int v = sc.nextInt();//ending vertex of edge
            gr.get(u).add(v);
            gr.get(v).add(u);
        }
        for(int i = 0 ; i < n ; i++){
            System.out.print("Adjacent vertices of vertex " + i + ": ");
            for(Integer vertex : gr.get(i)){
                System.out.print(vertex + " ");
            }
            System.out.println();
        }

    }

}
