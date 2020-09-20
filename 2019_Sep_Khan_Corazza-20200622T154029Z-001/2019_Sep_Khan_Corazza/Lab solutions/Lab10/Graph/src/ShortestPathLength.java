import java.util.HashMap;

public class ShortestPathLength extends BreadthFirstSearch {
    Vertex startingVertex;
    Vertex endingVertex;
    HashMap<String, Integer> levelMap = new HashMap<String, Integer>();
    int shortestDistance = -1;

    public ShortestPathLength(Graph graph, Vertex u, Vertex v) {
        super(graph);
        startingVertex = u;
        endingVertex = v;
        levelMap.put(u.toString(), 0);
        super.start(u);

    }

    @Override
    protected void processEdge(Edge e) {

        if(levelMap.containsKey(e.u.toString())){
            levelMap.put(e.v.toString(), levelMap.get(e.u.toString()) + 1);
        } else if (levelMap.containsKey(e.v.toString())) {
            levelMap.put(e.u.toString(), levelMap.get(e.v.toString()) + 1);
        }

//        System.out.println(levelMap.toString());

    }

    public int getShortestDistance() {
        if(levelMap.get(endingVertex.toString()) != null) {
            shortestDistance = levelMap.get(endingVertex.toString());
        }

        return shortestDistance;
    }
}
