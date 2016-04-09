package ehwaz.problem_solving.ds.binarytree.testcases;

import ehwaz.problem_solving.ds.binarytree.BinaryTree;

/**
 * Created by Sangwook on 2016-04-09.
 */
public class Util {
    public static BinaryTree createFullBinaryTree0() {
        BinaryTree root = new BinaryTree(1);
        root.setLeft(new BinaryTree(2));
        root.setRight(new BinaryTree(3));

        root.getLeft().setLeft(new BinaryTree(4));
        root.getLeft().setRight(new BinaryTree(5));
        root.getRight().setLeft(new BinaryTree(6));
        root.getRight().setRight(new BinaryTree(7));

        return root;
    }

    public static BinaryTree createFullBinaryTree1() {
        BinaryTree root = new BinaryTree(1);
        root.setLeft(new BinaryTree(2));
        root.setRight(new BinaryTree(3));

        root.getLeft().setLeft(new BinaryTree(4));
        root.getLeft().setRight(new BinaryTree(5));
        root.getRight().setLeft(new BinaryTree(6));
        root.getRight().setRight(new BinaryTree(7));

        BinaryTree node4 = root.getLeft().getLeft();

        node4.setLeft(new BinaryTree(8));
        node4.setRight(new BinaryTree(9));

        node4.getLeft().setLeft(new BinaryTree(16));
        node4.getLeft().setRight(new BinaryTree(17));
        node4.getRight().setLeft(new BinaryTree(18));
        node4.getRight().setRight(new BinaryTree(19));

        BinaryTree node5 = root.getLeft().getRight();

        node5.setLeft(new BinaryTree(10));
        node5.setRight(new BinaryTree(11));

        node5.getLeft().setLeft(new BinaryTree(20));
        node5.getLeft().setRight(new BinaryTree(21));
        node5.getRight().setLeft(new BinaryTree(22));
        node5.getRight().setRight(new BinaryTree(23));

        BinaryTree node6 = root.getRight().getLeft();

        node6.setLeft(new BinaryTree(12));
        node6.setRight(new BinaryTree(13));

        node6.getLeft().setLeft(new BinaryTree(24));
        node6.getLeft().setRight(new BinaryTree(25));
        node6.getRight().setLeft(new BinaryTree(26));
        node6.getRight().setRight(new BinaryTree(27));

        BinaryTree node7 = root.getRight().getRight();

        node7.setLeft(new BinaryTree(14));
        node7.setRight(new BinaryTree(15));

        node7.getLeft().setLeft(new BinaryTree(28));
        node7.getLeft().setRight(new BinaryTree(29));
        node7.getRight().setLeft(new BinaryTree(30));
        node7.getRight().setRight(new BinaryTree(31));

        return root;
    }

    public static BinaryTree createTree3() {
        BinaryTree root = new BinaryTree(1);

        root.setLeft(new BinaryTree(2));
        root.setRight(new BinaryTree(3));

        root.getLeft().setRight(new BinaryTree(5));
        root.getRight().setRight(new BinaryTree(7));

        root.getRight().getRight().setLeft(new BinaryTree(13));

        return root;
    }

    public static BinaryTree createTree4() {
        BinaryTree root = new BinaryTree(1);

        root.setLeft(new BinaryTree(2));
        root.setRight(new BinaryTree(3));

        root.getLeft().setRight(new BinaryTree(5));
        root.getRight().setLeft(new BinaryTree(6));

        root.getLeft().getRight().setLeft(new BinaryTree(10));

        return root;
    }

}
