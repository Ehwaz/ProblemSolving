package ehwaz.problem_solving.algorithm.graph.model;

import lombok.Getter;

import java.util.*;

/**
 * Created by Sangwook on 2016-04-12.
 */

// Undirected graph
public class DirectedGraph extends Graph {
    @Override
    public void addEdge(int v1, int v2, int weight) {
        Vertex vertex1 = new Vertex(v1);
        Vertex vertex2 = new Vertex(v2);

        addEdge(vertex1, vertex2, weight);
    }

    public void addEdge(Vertex from, Vertex to, int weight) {
        Edge newEdge = new Edge(from, to, weight);
        vertices.add(from);
        vertices.add(to);

        List<Edge> fromList;
        if (adjLists.containsKey(from)) {
            fromList = adjLists.get(from);
        } else {
            fromList = new ArrayList<Edge>();
            adjLists.put(from, fromList);
        }
        fromList.add(newEdge);
    }

    private void getTopoUtil(int vIdx, boolean[] visited, Stack<Vertex> resultRev) {
        visited[vIdx-1] = true;
        Vertex v = findVertex(vIdx);
        Vertex otherV;
        int otherId;
        if (adjLists.containsKey(v)) {
            for (Edge e : adjLists.get(v)) {
                otherId = e.getOtherVertex(v).getId();
                if (visited[otherId - 1] == false) {
                    getTopoUtil(otherId, visited, resultRev);
                }
            }
        }
        resultRev.push(v);
    }
    public String getTopologicalSort() {
        Stack<Vertex> resultRev = new Stack<Vertex>();
        boolean[] visited = new boolean[vertices.size()];

        for (Vertex v : vertices) {
            if (visited[v.getId()-1] == false) {
                getTopoUtil(v.getId(), visited, resultRev);
            }
        }

        StringBuilder result = new StringBuilder();
        while (resultRev.empty() == false) {
            result.append(resultRev.pop().toString() + " ");
        }

        return result.toString().trim();
    }
}
