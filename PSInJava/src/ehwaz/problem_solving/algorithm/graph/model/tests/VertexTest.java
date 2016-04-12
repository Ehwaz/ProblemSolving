package ehwaz.problem_solving.algorithm.graph.model.tests;

import ehwaz.problem_solving.algorithm.graph.model.Vertex;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Sangwook on 2016-04-12.
 */
public class VertexTest {
    Vertex v1, v2, v3, v1_2;

    @BeforeMethod
    public void setUp() throws Exception {
        v1 = new Vertex(1);
        v2 = new Vertex(2);
        v3 = new Vertex(3);
        v1_2 = new Vertex(1);
    }

    @Test
    public void testEquals() throws Exception {
        Assert.assertEquals(v1.equals(v1), true);
        Assert.assertEquals(v1.equals(null), false);
        Assert.assertEquals(v1.equals(v2), false);
        Assert.assertEquals(v1.equals(1), false);

        // I don't like this behavior but...
        Assert.assertEquals(v1.equals(v1_2), true);
    }

    @Test
    public void testHashCode() throws Exception {
        Assert.assertEquals(v1.hashCode() == v1.hashCode(), true);
        Assert.assertEquals(v1.hashCode() == v2.hashCode(), false);
        Assert.assertEquals(v1.hashCode() == v1_2.hashCode(), true);
    }

    @Test
    public void testCompareTo() throws Exception {
        Assert.assertEquals(v1.compareTo(v1) == 0, true);
        Assert.assertEquals(v1.compareTo(v2) < 0, true);
        Assert.assertEquals(v3.compareTo(v1) > 0, true);
    }
}