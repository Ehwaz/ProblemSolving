package ehwaz.problem_solving.ds.binarytree;

import org.testng.Assert;
import org.testng.annotations.Test;

import ehwaz.problem_solving.ds.binarytree.testcases.*;

/**
 * Created by Sangwook on 2016-04-09.
 */
public class BinaryTreeEqualsTest {
    @Test
    public void testEquals() throws Exception {
        BinaryTree tree1 = new BinaryTree(1);

        Assert.assertEquals(tree1.equals(1), false);
        Assert.assertEquals(tree1.equals(null), false);

        BinaryTreeBuilder builder = new BinaryTreeBuilder();
        BinaryTree tree2_1 = Util.createFullBinaryTree0();
        BinaryTree tree2_2 = Util.createFullBinaryTree0();
        Assert.assertEquals(tree2_1.equals(tree2_2), true);
        Assert.assertEquals(tree2_2.equals(tree2_1), true);

        BinaryTree tree3 = Util.createTree3();
        BinaryTree tree3_2 = Util.createTree3();
        BinaryTree tree4 = Util.createTree4();
        Assert.assertEquals(tree3.equals(tree3_2), true);
        Assert.assertEquals(tree3.equals(tree4), false);
    }
}