package ehwaz.problem_solving.algorithm.graph.model;

import java.util.*;
import lombok.*;

/**
 * Created by Sangwook on 2016-04-12.
 */

// Undirected graph
public class Graph {
    @Getter protected Set<Vertex> vertices;
    private Map<Vertex, List<Edge>> adjLists;

    public Graph() {
        this.vertices = new HashSet<Vertex>();
        //this.edges = new HashSet<Edge>();
        adjLists = new HashMap<Vertex, List<Edge>>();
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public Vertex findVertex(int id) {
        Vertex result = null;
        for (Vertex v : vertices) {
            if (v.getId() == id) { result = v; }
        }
        return result;
    }

    public void addEdge(Vertex v1, Vertex v2, int weight) {
        Edge newEdge = new Edge(v1, v2, weight);
        vertices.add(v1);
        vertices.add(v2);
        //edges.add(newEdge);

        List<Edge> v1List, v2List;
        if (adjLists.containsKey(v1)) {
            v1List = adjLists.get(v1);
        } else {
            v1List = new ArrayList<Edge>();
            adjLists.put(v1, v1List);
        }
        v1List.add(newEdge);

        if (adjLists.containsKey(v2)) {
            v2List = adjLists.get(v2);
        } else {
            v2List = new ArrayList<Edge>();
            adjLists.put(v2, v2List);
        }
        v2List.add(newEdge);
    }

    public List<Edge> getAdjList(Vertex v) {
        if (adjLists.containsKey(v) == false) {
            return null;
        }
        return adjLists.get(v);
    }
}
