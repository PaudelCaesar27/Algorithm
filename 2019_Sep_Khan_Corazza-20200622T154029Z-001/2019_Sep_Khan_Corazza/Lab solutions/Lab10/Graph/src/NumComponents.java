public class NumComponents extends BreadthFirstSearch {

    private int numComponents = 0;
    public NumComponents(Graph graph) {
        super(graph);
    }

    @Override
    protected void additionalProcessing() {
        ++numComponents;
    }

    public int getNumComponents() {
        return numComponents;
    }
}
