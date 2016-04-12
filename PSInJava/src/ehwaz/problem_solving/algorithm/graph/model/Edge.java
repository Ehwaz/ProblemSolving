package ehwaz.problem_solving.algorithm.graph.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Sangwook on 2016-04-12.
 */
public class Edge implements Comparable<Edge> {
    @Getter protected final int id;
    @Getter protected final int weight;
    @Getter @Setter protected Vertex src;
    @Getter @Setter protected Vertex dst;

    public Edge(int id) {
        this.id = id;
        this.weight = 1;
        src = null;
        dst = null;
    }

    public Edge(int id, int weight) {
        this.id = id;
        this.weight = weight;
        src = null;
        dst = null;
    }

    public Edge(int id, Vertex src, Vertex dst) {
        this.id = id;
        this.weight = 1;
        this.src = src;
        this.dst = dst;
    }

    public Edge(int id, Vertex src, Vertex dst, int weight) {
        this.id = id;
        this.weight = weight;
        this.src = src;
        this.dst = dst;
    }

    public Edge(Vertex src, Vertex dst) {
        this.id = -1;
        this.weight = 1;
        this.src = src;
        this.dst = dst;
    }

    public Edge(Vertex src, Vertex dst, int weight) {
        this.id = -1;
        this.weight = weight;
        this.src = src;
        this.dst = dst;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj instanceof Edge) == false) {
            return false;
        }
        if (this == obj) { return true; }

        Edge other = (Edge) obj;
        if (this.id == other.id &&
                this.src == other.src &&
                this.dst == other.dst) { return true; }

        return false;
    }

    @Override
    public int hashCode() {
        return 11 * id + 17 * src.hashCode() + 19 * dst.hashCode() + 31 * weight;
    }

    @Override
    public String toString() {
        return "Edge " + Integer.toString(id) + ": v(" + src.getId() + ") -> v(" + dst.getId() + ")";
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

    public Vertex getOtherVertex(Vertex v) {
        if (this.src.equals(v)) { return this.dst; }
        else if (this.dst.equals(v)) { return this.src; }
        else { return null; }
    }
}