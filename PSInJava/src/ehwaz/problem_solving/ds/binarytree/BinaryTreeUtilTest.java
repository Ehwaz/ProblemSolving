package ehwaz.problem_solving.ds.binarytree;

import ehwaz.problem_solving.ds.binarytree.testcases.Util;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sangwook on 2016-04-09.
 */
public class BinaryTreeUtilTest {
    @Test
    public void testGetHeightRec() {
        BinaryTree tree0 = Util.createFullBinaryTree0();
        BinaryTree tree1 = Util.createFullBinaryTree1();
        BinaryTree tree3 = Util.createTree3();
        BinaryTree tree4 = Util.createTree4();

        Assert.assertEquals(tree0.getHeightRec(), 3);
        Assert.assertEquals(tree1.getHeightRec(), 5);
        Assert.assertEquals(tree3.getHeightRec(), 4);
        Assert.assertEquals(tree4.getHeightRec(), 4);
    }

    @Test
    public void testGetHeight() {
        BinaryTree tree0 = Util.createFullBinaryTree0();
        BinaryTree tree1 = Util.createFullBinaryTree1();
        BinaryTree tree3 = Util.createTree3();
        BinaryTree tree4 = Util.createTree4();

        Assert.assertEquals(tree0.getHeight(), 3);
        Assert.assertEquals(tree1.getHeight(), 5);
        Assert.assertEquals(tree3.getHeight(), 4);
        Assert.assertEquals(tree4.getHeight(), 4);
    }

    @Test
    public void testGetDiameter() {
        BinaryTree tree0 = Util.createFullBinaryTree0();
        BinaryTree tree1 = Util.createFullBinaryTree1();
        BinaryTree tree3 = Util.createTree3();
        BinaryTree tree4 = Util.createTree4();

        Assert.assertEquals(tree0.getDiametorRec(), 5);
        Assert.assertEquals(tree0.getDiametorRecOn2(), 5);
        Assert.assertEquals(tree1.getDiametorRec(), 9);
        Assert.assertEquals(tree1.getDiametorRecOn2(), 9);
        Assert.assertEquals(tree3.getDiametorRec(), 6);
        Assert.assertEquals(tree3.getDiametorRecOn2(), 6);
        Assert.assertEquals(tree4.getDiametorRec(), 6);
        Assert.assertEquals(tree4.getDiametorRecOn2(), 6);

        BinaryTree root = new BinaryTree(1);
        root.setLeft(new BinaryTree(2));
        root.setRight(new BinaryTree(3));

        root.getLeft().setLeft(new BinaryTree(4));
        root.getLeft().setRight(new BinaryTree(5));

        BinaryTree node4 = root.getLeft().getLeft();
        node4.setLeft(new BinaryTree(8));

        BinaryTree node5 = root.getLeft().getRight();
        node5.setRight(new BinaryTree(11));

        node5.getRight().setLeft(new BinaryTree(22));
        Assert.assertEquals(root.getDiametorRec(), 6);
        Assert.assertEquals(root.getDiametorRecOn2(), 6);
    }
}