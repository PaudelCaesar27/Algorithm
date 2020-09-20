public class HasCycle extends BreadthFirstSearch {
    private boolean isCycle;
    private int edges = 0;
    private int vertex = 0;
    public HasCycle(Graph graph) {
        super(graph);
    }

    @Override
    protected void processEdge(Edge e) {
        ++edges;
    }


    public int getCycleConnected() {
        return edges;
    }
}
