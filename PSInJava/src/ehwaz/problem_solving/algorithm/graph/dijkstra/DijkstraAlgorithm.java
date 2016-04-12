package ehwaz.problem_solving.algorithm.graph.dijkstra;

import ehwaz.problem_solving.algorithm.graph.model.*;

import java.io.InputStream;
import java.util.*;

/**
 * Created by Sangwook on 2016-04-12.
 */
public class DijkstraAlgorithm {
    private Set<Vertex> settledVertices;
    private Set<Vertex> unSettledVertices;
    boolean isExecutionDone = false;

    private Map<Vertex, Vertex> predecessors;
    private Map<Vertex, Integer> distFromSrc;

    private Vertex getMinWeightVertex(Set<Vertex> unSettledVertices) {
        Vertex minWeightVertex = null;
        int curVertexWeight, minWeight = Integer.MAX_VALUE/2;

        // TODO: reduce this to O(1) using heap.
        for (Vertex v : unSettledVertices) {
            if (minWeightVertex == null) {
                minWeightVertex = v;
                minWeight = distFromSrc.get(v);
            }
            else {
                curVertexWeight = distFromSrc.get(v);
                if (curVertexWeight < minWeight) {
                    minWeightVertex = v;
                    minWeight = curVertexWeight;
                }
            }
        }

        return minWeightVertex;
    }

    private void updateMinDistances(Graph graph, Vertex minWeightVertex) {
        List<Edge> edgesOfGivenVertex = graph.getAdjList(minWeightVertex);
        if (edgesOfGivenVertex == null) { throw new RuntimeException("Error in getting edge info of minWeightVertex"); }

        // Given dataset contains edges whose SRC & DST vertices are same but weight is different,
        // but it doesn't affect the result only if all different edges are maintained.
        Map<Vertex, Integer> uniqueEdges = new HashMap<Vertex, Integer>();
        Vertex tempV;
        int minWeight, tempWeight;

        int prevMinDistFromSrc, newDistFromSrc;
        int relayVertexDistFromSrc = distFromSrc.get(minWeightVertex);
        for (Edge e : edgesOfGivenVertex) {
            tempV = e.getOtherVertex(minWeightVertex);
            tempWeight = e.getWeight();
            if (settledVertices.contains(tempV) == false) {
                prevMinDistFromSrc = distFromSrc.get(tempV);
                newDistFromSrc = relayVertexDistFromSrc + tempWeight;
                if (newDistFromSrc < prevMinDistFromSrc) {
                    distFromSrc.put(tempV, newDistFromSrc);
                    predecessors.put(tempV, minWeightVertex);
                }
            }
        }
    }

    public LinkedList<Vertex> getMinimalPath(Vertex dst) {
        if (isExecutionDone == false) {
            throw new RuntimeException("DijkstraAlgorithm.getMinimalPath(): run after execute() is completed.");
        }

        LinkedList<Vertex> path = new LinkedList<Vertex>();
        Vertex vertexOneStepBefore = dst;
        if (predecessors.get(vertexOneStepBefore) == null) { return null; }

        path.add(vertexOneStepBefore);
        while (predecessors.get(vertexOneStepBefore) != null) {
            vertexOneStepBefore = predecessors.get(vertexOneStepBefore);
            path.add(vertexOneStepBefore);
        }
        Collections.reverse(path);

        return path;
    }

    public int getDistFromSrc(Vertex v) {
        if (isExecutionDone == false) {
            throw new RuntimeException("DijkstraAlgorithm.getDistFromSrc(): run after execute() is completed.");
        }

        return distFromSrc.get(v);
    }

    public void execute(Graph graph, Vertex srcVertex) {
        settledVertices = new HashSet<Vertex>();
        unSettledVertices = new HashSet<Vertex>();
        predecessors = new HashMap<Vertex, Vertex>();
        distFromSrc = new HashMap<Vertex, Integer>();

        // Initalization
        for (Vertex v : graph.getVertices()) {
            if (v == srcVertex) {
                distFromSrc.put(v, 0);
            } else {
                distFromSrc.put(v, Integer.MAX_VALUE/2);
            }
            unSettledVertices.add(v);
        }

        Vertex minWeightVertex;
        while (unSettledVertices.size() > 0) {
            minWeightVertex = getMinWeightVertex(unSettledVertices);
            if (minWeightVertex == null) { break; }

            settledVertices.add(minWeightVertex);
            unSettledVertices.remove(minWeightVertex);
            updateMinDistances(graph, minWeightVertex);
        }

        isExecutionDone = true;
    }

    public static void runExecution(InputStream istream) {
        Scanner sc = new Scanner(istream);

        int testNum = sc.nextInt();
        sc.nextLine();
        for (int testCnt = 0; testCnt < testNum; testCnt++) {
            int vertexNum = sc.nextInt();
            int edgeNum = sc.nextInt();
            sc.nextLine();

            List<Integer> vertexIdList = new ArrayList<Integer>();
            Graph graph = new Graph();

            int v1_id, v2_id, srcVertexId;
            Vertex srcVertex, targetVertex;
            for (int edgeCnt = 0; edgeCnt < edgeNum; edgeCnt++) {
                String[] edgeInfo = sc.nextLine().split(" ");

                v1_id = Integer.parseInt(edgeInfo[0]);
                v2_id = Integer.parseInt(edgeInfo[1]);
                graph.addEdge(new Vertex(v1_id), new Vertex(v2_id), Integer.parseInt(edgeInfo[2]));

                if (vertexIdList.contains(v1_id) == false) { vertexIdList.add(v1_id); }
                if (vertexIdList.contains(v2_id) == false) { vertexIdList.add(v2_id); }
            }
            srcVertexId = sc.nextInt();
            srcVertex = graph.findVertex(srcVertexId);

            DijkstraAlgorithm algoObj = new DijkstraAlgorithm();
            algoObj.execute(graph, srcVertex);

            Collections.sort(vertexIdList);

            int minDist;
            for (int vId : vertexIdList) {
                if (vId != srcVertexId) {
                    targetVertex = graph.findVertex(vId);
                    minDist = algoObj.getDistFromSrc(targetVertex);
                    if (minDist == Integer.MAX_VALUE/2) { System.out.print(-1 + " "); }
                    else { System.out.print(minDist + " "); }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        runExecution(System.in);
    }
}
