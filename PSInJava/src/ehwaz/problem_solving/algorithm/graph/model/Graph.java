package ehwaz.problem_solving.algorithm.graph.model;

import java.util.*;
import lombok.*;

/**
 * Created by Sangwook on 2016-04-12.
 */

// Undirected graph
public class Graph {
    @Getter protected Set<Vertex> vertices;
    protected Map<Vertex, List<Edge>> adjLists;

    public Graph() {
        this.vertices = new HashSet<Vertex>();
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

    public void addEdge(int v1, int v2, int weight) {
        Vertex vertex1 = new Vertex(v1);
        Vertex vertex2 = new Vertex(v2);

        addEdge(vertex1, vertex2, weight);
    }

    public void addEdge(Vertex v1, Vertex v2, int weight) {
        Edge newEdge = new Edge(v1, v2, weight);
        vertices.add(v1);
        vertices.add(v2);

        // Add in both directions: this class is for undirected graph.
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

    // Assumes the graph is connected graph.
    public String getDFS(Vertex startVertex) throws Exception {
        if (vertices.contains(startVertex) == false) {
            throw new Exception("printDFS: graph does not contain given start vertex.");
        }

        Stack<Vertex> vStack = new Stack<Vertex>();
        vStack.add(startVertex);

        boolean[] visited = new boolean[vertices.size()];
        StringBuilder result = new StringBuilder();
        Vertex curVertex, otherVertex;
        while (vStack.empty() == false) {
            curVertex = vStack.pop();
            if (visited[curVertex.getId()-1] == false) {
                visited[curVertex.getId() - 1] = true;
                result.append(" " + curVertex.toString());
                if (adjLists.containsKey(curVertex)) {
                    for (Edge e : adjLists.get(curVertex)) {
                        otherVertex = e.getOtherVertex(curVertex);
                        vStack.push(otherVertex);
                    }
                }
            }
        }

        return result.toString().trim();
    }

    // Assumes the graph is connected graph.
    public String getBFS(Vertex startVertex) throws Exception {
        if (vertices.contains(startVertex) == false) {
            throw new Exception("printBFS: graph does not contain given start vertex.");
        }

        Queue<Vertex> vQueue = new LinkedList<Vertex>();
        vQueue.add(startVertex);

        boolean[] visited = new boolean[vertices.size()];
        StringBuilder result = new StringBuilder();
        Vertex curVertex, otherVertex;
        while (vQueue.isEmpty() == false) {
            curVertex = vQueue.poll();
            if (visited[curVertex.getId()-1] == false) {
                visited[curVertex.getId() - 1] = true;
                result.append(curVertex.toString()  +  " ");
                if (adjLists.containsKey(curVertex)) {
                    for (Edge e : adjLists.get(curVertex)) {
                        otherVertex = e.getOtherVertex(curVertex);
                        vQueue.add(otherVertex);
                    }
                }
            }
        }

        return result.toString().trim();
    }
}
