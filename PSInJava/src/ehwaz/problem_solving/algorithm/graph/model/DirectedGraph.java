package ehwaz.problem_solving.algorithm.graph.model;

import java.util.*;
import lombok.Getter;


/**
 * Created by Sangwook on 2016-04-12.
 */
public class DirectedGraph {
    protected Set<Vertex> vertices;
    @Getter private Set<DirectedEdge> edges;

    public DirectedGraph() {
        this.vertices = new HashSet<Vertex>();
        this.edges = new HashSet<DirectedEdge>();
    }

    //@Override
    public void addEdge(Vertex v1, Vertex v2, int weight) {
        vertices.add(v1);
        vertices.add(v2);
        edges.add(new DirectedEdge(v1, v2, weight));
    }
}
