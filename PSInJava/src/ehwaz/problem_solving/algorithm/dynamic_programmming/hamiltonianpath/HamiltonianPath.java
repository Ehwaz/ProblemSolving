package ehwaz.problem_solving.algorithm.dynamic_programmming.hamiltonianpath;

/**
 * Created by Sangwook on 2016-04-18.
 */

import java.util.*;
import java.io.*;

// Class to represent each input points.
class Node {
    final int x;
    final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Node other = (Node)o;
        return (this.x == other.x) && (this.y == other.y);
    }

    @Override
    public int hashCode() { return 7 * this.x + 1013 * this.y; }

    @Override
    public String toString() { return "(" + x + "," + y + ")"; }
}

// Class to store minimum path and its length.
class PathInfo {
    // Contents do not change during execution.
    private final ArrayList<Node> minHPath;   // stores path in the form of Node list.
    private final double pathLength;          // stores the length of the path.

    public PathInfo (ArrayList<Node> path, double length) {
        this.minHPath = new ArrayList<Node>(path);
        this.pathLength = length;
    }

    public PathInfo(PathInfo other) {
        this.minHPath = new ArrayList<Node>(other.getMinPath());
        this.pathLength = other.getLength();
    }

    public ArrayList<Node> getMinPath() { return minHPath; }
    public double getLength() { return pathLength; }
}

public class HamiltonianPath {

    // For minimum Hamiltonian path.
    // Memoization for minimum costs by (Set of Nodes in Hamiltonian path, the last Node of the path)
    static HashMap<HashSet<Node>, HashMap<Node, PathInfo>> memoization;

    // Using dynamic programming.
    // Sub problem: minPath(S, node_D) = min( minPath(S - {node_i}, node_i) + distance(node_i, node_D) ) for node_i in S.
    // lastNode: the last Node of the path.
    // nodeSet: set of intermediate nodes between (0, 0) and lastNode.
    //          nodeSet does not contain lastNode.
    private static PathInfo getShortestHamilPath(HashSet<Node> nodeSet, Node lastNode) {
        if (nodeSet.size() == 0) {
            // Base case: If there is only 1 node in nodeSet, The path is (0, 0) -> lastNode.
            ArrayList<Node> basePath = new ArrayList<Node>();
            basePath.add(new Node(0, 0));
            basePath.add(lastNode);
            double baseLength = Math.sqrt(Math.pow(lastNode.x, 2) + Math.pow(lastNode.y, 2));
            PathInfo newPathInfo = new PathInfo(basePath, baseLength);

            HashMap<Node, PathInfo> baseMap = new HashMap<Node, PathInfo>();
            baseMap.put(lastNode, newPathInfo);

            memoization.put(nodeSet, baseMap);
            return newPathInfo;
        }

        // Stores candidate paths and automatically sort by length. Used to extract the path with minimum length.
        TreeMap<Double, PathInfo> minPathCand = new TreeMap<Double, PathInfo>();
        PathInfo pathCandidate;
        double lastEdgeLen, newLength;
        ArrayList<Node> newPath;
        PathInfo newInfo;
        // Each loop execution computes "minPath(S - {node_i}, node_i) + distance(node_i, node_D)"
        for (Node beforeNode : nodeSet) {
            // "distance(node_i, node_D)"
            lastEdgeLen = Math.sqrt(Math.pow(lastNode.x - beforeNode.x, 2) + Math.pow(lastNode.y - beforeNode.y, 2));

            // Re-create partialSet.
            // Removing and re-adding from set throws ConcurrentModificationException.
            HashSet<Node> partialSet = new HashSet<Node>();
            for (Node n : nodeSet) {
                if (n.equals(beforeNode) == false) { partialSet.add(n); }
            }

            // Getting "minPath(S - {node_i}, node_i)"
            if (memoization.containsKey(partialSet)) {
                HashMap<Node, PathInfo> pathInfoMap = memoization.get(partialSet);
                if (pathInfoMap.containsKey(beforeNode)) {
                    // There's memoization info. Re-use it.
                    pathCandidate = pathInfoMap.get(beforeNode);
                } else {
                    pathCandidate = getShortestHamilPath(partialSet, beforeNode);
                }
            } else {
                pathCandidate = getShortestHamilPath(partialSet, beforeNode);
            }

            // Generate new pathInfo object.
            newPath = new ArrayList<Node>(pathCandidate.getMinPath());
            newPath.add(lastNode);
            newLength = lastEdgeLen + pathCandidate.getLength();
            newInfo = new PathInfo(newPath, newLength);

            minPathCand.put(newLength, newInfo);
        }

        if (memoization.containsKey(nodeSet) == false) {
            memoization.put(nodeSet, new HashMap<Node, PathInfo>());
        }

        // Get path info with minimum path length.
        Map.Entry<Double, PathInfo> minPath = minPathCand.firstEntry();

        // Store result to memoization.
        memoization.get(nodeSet).put(lastNode, minPath.getValue());

        return minPath.getValue();
    }

    public static void solveProb(InputStream istream) {
        Scanner sc = new Scanner(istream);
        int nodeNum = Integer.parseInt(sc.nextLine());

        int x, y;
        memoization = new HashMap<HashSet<Node>, HashMap<Node, PathInfo>>();

        HashSet<Node> nodeSet = new HashSet<Node>(nodeNum);
        for (int nodeCnt = 0; nodeCnt < nodeNum; nodeCnt++) {
            x = sc.nextInt();
            y = sc.nextInt();
            nodeSet.add(new Node(x, y));
        }
        Node lastNode = new Node(10, 10);

        PathInfo minPathInfo = getShortestHamilPath(nodeSet, lastNode);

        //System.out.println("Min path length: " + minPathInfo.getLength());
        StringBuilder result = new StringBuilder();
        List<Node> minPath = minPathInfo.getMinPath();
        for (int i = 0; i < minPath.size(); i++) {
            result.append(minPath.get(i).toString());
            if (i != minPath.size()-1) {
                result.append(" -> ");
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        solveProb(System.in);   // Using stdin

        /*
        // Using file input
        FileInputStream fistream = null;
       try {
            fistream = new FileInputStream("src/problemC/testcases/input1.txt");
            solveProb(fistream);
            fistream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
