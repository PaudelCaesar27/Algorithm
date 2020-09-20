package labsolns10.graph2;

import java.util.*;

public class ConnectedComponentSearch extends BreadthFirstSearch {
	private int nextComponentNumber = 0;
	private HashMap<Vertex,Integer> vertexComponents = new HashMap<Vertex,Integer>();
	private ArrayList<List<Vertex>> verticesByComponent = new ArrayList<List<Vertex>>();
	
	public ConnectedComponentSearch(Graph graph) {
		super(graph);	
		verticesByComponent.add(new ArrayList());	
	}
	protected void additionalProcessing() {
		++nextComponentNumber;
		verticesByComponent.add(new ArrayList());
	}
	
	protected void processVertex(Vertex v) {
		vertexComponents.put(v, nextComponentNumber);
		List<Vertex> l = verticesByComponent.get(nextComponentNumber);
		l.add(v);
	}
	
	/* Return: list of components, vertexComponents map */
	Object[] getComponents() {
		start();
		Object[] retVal = new Object[2];
		List<Graph> components = new ArrayList<Graph>();
		Edge[] nextEdgeArr=null;
		List<Vertex> nextVertexList = null;
		Set<Edge> nextEdgeSet = null;
		for(int i = 0; i < nextComponentNumber; ++i){
			nextEdgeSet = new HashSet<Edge>();
			nextVertexList = verticesByComponent.get(i);
			for(Vertex v: nextVertexList) {
				List<Vertex> adjList = graph.getListOfAdjacentVerts(v);
				for(Vertex w: adjList) {
					if(!nextEdgeSet.contains(new Edge(w,v)))
					    nextEdgeSet.add(new Edge(v,w));		
				}
			}
			nextEdgeArr = nextEdgeSet.toArray(new Edge[0]);	
			Graph g = new Graph(nextEdgeArr);
			components.add(g);
		}
		retVal[0] = components;
		retVal[1] = vertexComponents;
		
		return retVal;
	}
}
