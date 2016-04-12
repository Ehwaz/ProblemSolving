package ehwaz.problem_solving.algorithm.graph.model.tests;

import ehwaz.problem_solving.algorithm.graph.model.Edge;
import ehwaz.problem_solving.algorithm.graph.model.Vertex;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Sangwook on 2016-04-12.
 */
public class EdgeTest {
    Vertex v1, v2, v3, v4;
    Edge edge1, edge2, edge3;

    @BeforeTest
    public void setUp() throws  Exception {
        v1 = new Vertex(1);
        v2 = new Vertex(2);
        v3 = new Vertex(3);
        v4 = new Vertex(4);

        edge1 = new Edge(1, v1, v2, 3);
        edge2 = new Edge(2, v1, v2, 4);
        edge3 = new Edge(3, v3, v4, 4);
    }

    @Test
    public void testEquals() throws Exception {
        Assert.assertEquals(edge1.equals(edge1), true);
        Assert.assertEquals(edge1.equals(null), false);
        Assert.assertEquals(edge1.equals(edge2), false);
        Assert.assertEquals(edge1.equals(edge3), false);
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(edge1.hashCode() == edge1.hashCode(), true);
        Assert.assertEquals(edge2.hashCode() == edge2.hashCode(), true);
        Assert.assertEquals(edge3.hashCode() == edge3.hashCode(), true);

        Assert.assertEquals(edge1.hashCode() == edge3.hashCode(), false);
        Assert.assertEquals(edge2.hashCode() == edge1.hashCode(), false);
        Assert.assertEquals(edge3.hashCode() == edge2.hashCode(), false);
    }

    @Test
    public void testCompareTo() throws Exception {
        Assert.assertEquals(edge1.compareTo(edge1) == 0, true);
        Assert.assertEquals(edge1.compareTo(edge2) < 0, true);

        Assert.assertEquals(edge2.compareTo(edge3) == 0, true);
    }
}