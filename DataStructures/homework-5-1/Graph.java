import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Collection;


public class Graph<V> { 
   
    // Keep an index from node labels to nodes in the map
    protected Map<V, Vertex<V>> vertices; 

    /**
     * Construct an empty Graph.
     */
    public Graph() {
       vertices = new HashMap<V, Vertex<V>>();
    }

    /**
     * Retrieve a collection of vertices. 
     */  
    public Collection<Vertex<V>> getVertices() {
        return vertices.values();
    }

    public void addVertex(V u) {
        addVertex(new Vertex<>(u));
    }
    
    public void addVertex(Vertex<V> v) {
        if (vertices.containsKey(v.name)) 
            throw new IllegalArgumentException("Cannot create new vertex with existing name.");
        vertices.put(v.name, v);
    }

    /**
     * Add a new edge from u to v.
     * Create new nodes if these nodes don't exist yet. 
     * @param u unique name of the first vertex.
     * @param w unique name of the second vertex.
     * @param cost cost of this edge. 
     */
    public void addEdge(V u, V w, Double cost) {
        if (!vertices.containsKey(u))
            addVertex(u);
        if (!vertices.containsKey(w))
            addVertex(w);

        vertices.get(u).addEdge(
            new Edge<>(vertices.get(u), vertices.get(w), cost)); 

    }

    public void addEdge(V u, V w) {
        addEdge(u,w,1.0);
    }

    public void printAdjacencyList() {
        for (V u : vertices.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(u.toString());
            sb.append(" -> [ ");
            for (Edge e : vertices.get(u).getEdges()){
                sb.append(e.target.name);
                sb.append(" ");
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }    
  
   /**
    * Add a bidirectional edge between u and v. Create new nodes if these nodes don't exist
    * yet. This method permits adding multiple edges between the same nodes.
    *
    * @param u  
    *          the name of the source vertex.
    * @param v 
    *          the name of the target vertex.
    * @param cost
    *          the cost of this edge
    */
    public void addUndirectedEdge(V u, V v, Double cost) {
        addEdge(u,v, cost);
        addEdge(v,u, cost);
    }

    /****************************
     * Your code follows here.  *
     ****************************/ 
    
    // Part 1
    public void computeAllEuclideanDistances() {
        for (Vertex<V> v : vertices.values()) {
            for (Edge<V> e : v.getEdges()) {
                e.distance = Math.sqrt((e.source.posX - e.target.posX) * (e.source.posX - e.target.posX)
                                       + (e.source.posY - e.target.posY) * (e.source.posY - e.target.posY));
            }
        }
     
        return;
    }
    
    // Part 2
    public void doDijkstra(V s) {
		for (Vertex<V> v : vertices.values()) {
			v.cost = Integer.MAX_VALUE;
			v.visited = false;
			v.backpointer = null;
		}
		
		vertices.get(s).cost = 0;
		
		BinaryHeap<Vertex<V>> heap = new BinaryHeap<>();
		heap.insert(vertices.get(s));
		
		while (!heap.isEmpty()) {
			Vertex<V> u = heap.deleteMin();
			u.visited = true;
			
			for (Edge<V> e : u.getEdges()) {
				if (e.target.visited == false) {
					double c = u.cost + e.distance;
					if (c < e.target.cost) {
						e.target.cost = c;
						e.target.backpointer = u;
						heap.insert(e.target);
					}
				}
			}
		}
			
		return;
    }

    // Part 3
    public List<Edge<V>> getDijkstraPath(V s, V t) {
		doDijkstra(s);
		List<Edge<V>> list = new LinkedList<>();
		
		for (Vertex<V> v = vertices.get(t); v.backpointer != null; v = v.backpointer) {
			List<Edge<V>> tmp = v.backpointer.getEdges();
			for (int i = 0; i < tmp.size(); i++) {
				if (tmp.get(i).target.equals(v))
					list.add(tmp.get(i));	
			}
		}
		return list;
    }   
}