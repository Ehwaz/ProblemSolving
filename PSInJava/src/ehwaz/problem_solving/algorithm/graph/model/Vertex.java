package ehwaz.problem_solving.algorithm.graph.model;

import lombok.*;

/**
 * Created by Sangwook on 2016-04-12.
 */
public class Vertex implements Comparable<Vertex> {
    @Getter final private int id;

    public Vertex(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj instanceof Vertex) == false) {
            return false;
        }
        if (this == obj) { return true; }

        Vertex other = (Vertex) obj;
        if (this.id != other.id) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        return 11 * id;
    }

    @Override
    public String toString() {
        return "[" + Integer.toString(id) + "]";
    }

    @Override
    public int compareTo(Vertex other) {
        //return Integer.compare(this.id, other.id);
        return (this.id - other.id);    // same as above line.
    }
}
