import java.util.List;

public interface Graph {
	
	// Eventually, our graphs will include more functions than this
	// ... but let's start here.
	void addEdge(int v1, int v2);
	List<Integer> topologicalSort();
	int[] neighbors(int vertex);

}
