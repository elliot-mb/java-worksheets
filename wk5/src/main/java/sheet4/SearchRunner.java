package sheet4;

import com.google.common.graph.ImmutableValueGraph;
import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class SearchRunner {
    private ImmutableValueGraph<Integer, Integer> graph;

    public void createGraph() throws IOException {
        graph = Search.readGraph(
                Resources.toString(Resources.getResource("map.txt"),
                        StandardCharsets.UTF_8));
    }

    public static void main(String[] args) throws IOException {
        SearchRunner system = new SearchRunner();
        system.createGraph();
        Search.shortestPathFromSourceToDestination(system.graph, 1, 34);
    }
}