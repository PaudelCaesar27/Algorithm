package labsolns10.graph2;

public class NumComponents extends BreadthFirstSearch {
	private int numComponents = 0;
	public NumComponents(Graph graph) {
		super(graph);
		
	}
	
	@Override
	public void additionalProcessing() {
		++numComponents;
	}
	
	public int getNumComponents() {
		return numComponents;
	}

}
