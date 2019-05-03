import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;

public class GraphImplementation implements Graph {
    int vertix;
    int[][] adjmatrix;
    public GraphImplementation(int vertix){
        this.vertix = vertix;
        adjmatrix = new int[vertix][vertix];
    }
    @Override
    public void addEdge(int v1, int v2) {

        adjmatrix[v1][v2]= 1;

    }

    @Override
    public List<Integer> topologicalSort() {
        int[][] incidents = new int[vertix][vertix];
        for (int i = 0; i < vertix; i++) {
            for (int j = 0; j <vertix; j++) {
                incidents[i][j] = adjmatrix[i][j];
            }
        }
        Set<Integer> helper = new HashSet<>();
        List<Integer> schedule = new LinkedList<>();

        for (int i = 0; i < vertix; i++) {
            for (int j = 0; j < vertix; j++) {
                boolean isErasable = true;

                for (int k = 0; k < vertix; k++) {
                    if (incidents[k][j] > 0) {
                        isErasable = false;
                        break;
                    }
                }
               if(isErasable && !helper.contains(j)){
                   helper.add(j);
                   schedule.add(j);
                   for (int l =0; l < vertix; l++){
                       incidents[j][l] = 0;
                   }
                   break;
               }

            }

        }
        return schedule;
    }

    @Override
    public int[] neighbors(int vertex) {
        int count = 0;
        int neighborCount = 0;
        for(int i = 0; i < vertix; i++){
            if(adjmatrix[vertex][i] > 0){
                count++;
            }
        }
        int [] neighbors = new int[count];
        for(int i = 0; i < vertix; i++){
            if(adjmatrix[vertex][i] > 0){
                neighbors[neighborCount++] = i;
            }
        }


        return neighbors;
    }
}
