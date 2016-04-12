package ehwaz.problem_solving.algorithm.graph.model;

import lombok.*;

/**
 * Created by Sangwook on 2016-04-12.
 */
public class DirectedEdge extends Edge {
    // Constraint of directed edge: (ID of src vertex) <= (ID of dst vertex)
    // Ref: http://stackoverflow.com/a/13918505

    DirectedEdge(int id, Vertex src, Vertex dst) {
        super(id);
        // I think writing this line like "if (src.compareTo(dst) <= 0)" is not good in readability.
        if (src.getId() <= dst.getId()) {
            this.src = src;
            this.dst = dst;
        } else {
            this.src = dst;
            this.dst = src;
        }
    }

    DirectedEdge(int id, Vertex src, Vertex dst, int weight) {
        super(id, weight);
        if (src.getId() <= dst.getId()) {
            this.src = src;
            this.dst = dst;
        } else {
            this.src = dst;
            this.dst = src;
        }
    }


    DirectedEdge(Vertex src, Vertex dst) {
        super(-1);
        if (src.getId() <= dst.getId()) {
            this.src = src;
            this.dst = dst;
        } else {
            this.src = dst;
            this.dst = src;
        }
    }

    DirectedEdge(Vertex src, Vertex dst, int weight) {
        super(-1, weight);
        if (src.getId() <= dst.getId()) {
            this.src = src;
            this.dst = dst;
        } else {
            this.src = dst;
            this.dst = src;
        }
    }
}
