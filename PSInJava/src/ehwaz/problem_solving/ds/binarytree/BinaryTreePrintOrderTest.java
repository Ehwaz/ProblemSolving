package ehwaz.problem_solving.ds.binarytree;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import ehwaz.problem_solving.ds.binarytree.testcases.*;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Sangwook on 2016-04-09.
 */
public class BinaryTreePrintOrderTest {
    private BinaryTree fullBinaryTree0, fullBinaryTree1, tree3, tree4;

    private final String IN_FILENAME = "inorder.txt";
    private final String LEV_FILENAME = "levelorder.txt";
    private final String POST_FILENAME = "postorder.txt";
    private final String PRE_FILENAME = "preorder.txt";

    private final String ANS_FBTree0_PATH = "src/ehwaz/problem_solving/ds/binarytree/testcases/fullbinarytree0_";
    private final String ANS_FBTree1_PATH = "src/ehwaz/problem_solving/ds/binarytree/testcases/fullbinarytree1_";
    private final String ANS_Tree3_PATH = "src/ehwaz/problem_solving/ds/binarytree/testcases/tree3_";
    private final String ANS_Tree4_PATH = "src/ehwaz/problem_solving/ds/binarytree/testcases/tree4_";

    @BeforeMethod
    public void setUp() throws Exception {
        fullBinaryTree0 = Util.createFullBinaryTree0();
        fullBinaryTree1 = Util.createFullBinaryTree1();
        tree3 = Util.createTree3();
        tree4 = Util.createTree4();
    }

    @Test
    public void testPrintInPreOrder() throws Exception {
        String FBT0_answer = new String(Files.readAllBytes(Paths.get(ANS_FBTree0_PATH + PRE_FILENAME)));
        String FBT0_resultRec = fullBinaryTree0.printInPreOrderRec();
        String FBT0_result = fullBinaryTree0.printInPreOrder();
        Assert.assertEquals(FBT0_resultRec, FBT0_answer);
        Assert.assertEquals(FBT0_result, FBT0_answer);

        String FBT1_answer = new String(Files.readAllBytes(Paths.get(ANS_FBTree1_PATH + PRE_FILENAME)));
        String FBT1_resultRec = fullBinaryTree1.printInPreOrderRec();
        String FBT1_result = fullBinaryTree1.printInPreOrder();
        Assert.assertEquals(FBT1_result, FBT1_answer);
        Assert.assertEquals(FBT1_resultRec, FBT1_answer);

        String T3_answer = new String(Files.readAllBytes(Paths.get(ANS_Tree3_PATH + PRE_FILENAME)));
        String T3_resultRec = tree3.printInPreOrderRec();
        String T3_result = tree3.printInPreOrder();
        Assert.assertEquals(T3_resultRec, T3_answer);
        Assert.assertEquals(T3_result, T3_answer);

        String T4_answer = new String(Files.readAllBytes(Paths.get(ANS_Tree4_PATH + PRE_FILENAME)));
        String T4_resultRec = tree4.printInPreOrderRec();
        String T4_result = tree4.printInPreOrder();
        Assert.assertEquals(T4_resultRec, T4_answer);
        Assert.assertEquals(T4_result, T4_answer);
    }

    @Test
    public void testPrintInPostOrder() throws Exception {
        String FBT0_answer = new String(Files.readAllBytes(Paths.get(ANS_FBTree0_PATH + POST_FILENAME)));
        String FBT0_resultRec = fullBinaryTree0.printInPostOrderRec();
        String FBT0_result = fullBinaryTree0.printInPostOrder();
        Assert.assertEquals(FBT0_resultRec, FBT0_answer);
        Assert.assertEquals(FBT0_result, FBT0_answer);

        String FBT1_answer = new String(Files.readAllBytes(Paths.get(ANS_FBTree1_PATH + POST_FILENAME)));
        String FBT1_resultRec = fullBinaryTree1.printInPostOrderRec();
        String FBT1_result = fullBinaryTree1.printInPostOrder();
        Assert.assertEquals(FBT1_result, FBT1_answer);
        Assert.assertEquals(FBT1_resultRec, FBT1_answer);

        String T3_answer = new String(Files.readAllBytes(Paths.get(ANS_Tree3_PATH + POST_FILENAME)));
        String T3_resultRec = tree3.printInPostOrderRec();
        String T3_result = tree3.printInPostOrder();
        Assert.assertEquals(T3_resultRec, T3_answer);
        Assert.assertEquals(T3_result, T3_answer);

        String T4_answer = new String(Files.readAllBytes(Paths.get(ANS_Tree4_PATH + POST_FILENAME)));
        String T4_resultRec = tree4.printInPostOrderRec();
        String T4_result = tree4.printInPostOrder();
        Assert.assertEquals(T4_resultRec, T4_answer);
        Assert.assertEquals(T4_result, T4_answer);
    }

    @Test
    public void testPrintInInOrder() throws Exception {
        String FBT0_answer = new String(Files.readAllBytes(Paths.get(ANS_FBTree0_PATH + IN_FILENAME)));
        String FBT0_resultRec = fullBinaryTree0.printInInOrderRec();
        String FBT0_result = fullBinaryTree0.printInInOrder();
        Assert.assertEquals(FBT0_resultRec, FBT0_answer);
        Assert.assertEquals(FBT0_result, FBT0_answer);

        String FBT1_answer = new String(Files.readAllBytes(Paths.get(ANS_FBTree1_PATH + IN_FILENAME)));
        String FBT1_resultRec = fullBinaryTree1.printInInOrderRec();
        String FBT1_result = fullBinaryTree1.printInInOrder();
        Assert.assertEquals(FBT1_result, FBT1_answer);
        Assert.assertEquals(FBT1_resultRec, FBT1_answer);

        String T3_answer = new String(Files.readAllBytes(Paths.get(ANS_Tree3_PATH + IN_FILENAME)));
        String T3_resultRec = tree3.printInInOrderRec();
        String T3_result = tree3.printInInOrder();
        Assert.assertEquals(T3_resultRec, T3_answer);
        Assert.assertEquals(T3_result, T3_answer);

        String T4_answer = new String(Files.readAllBytes(Paths.get(ANS_Tree4_PATH + IN_FILENAME)));
        String T4_resultRec = tree4.printInInOrderRec();
        String T4_result = tree4.printInInOrder();
        Assert.assertEquals(T4_resultRec, T4_answer);
        Assert.assertEquals(T4_result, T4_answer);
    }

    @Test
    public void testPrintInLevelOrder() throws Exception {
        String FBT0_answer = new String(Files.readAllBytes(Paths.get(ANS_FBTree0_PATH + LEV_FILENAME)));
        String FBT0_result = fullBinaryTree0.printInLevelOrder();
        Assert.assertEquals(FBT0_result, FBT0_answer);

        String FBT1_answer = new String(Files.readAllBytes(Paths.get(ANS_FBTree1_PATH + LEV_FILENAME)));
        String FBT1_result = fullBinaryTree1.printInLevelOrder();
        Assert.assertEquals(FBT1_result, FBT1_answer);

        String T3_answer = new String(Files.readAllBytes(Paths.get(ANS_Tree3_PATH + LEV_FILENAME)));
        String T3_result = tree3.printInLevelOrder();
        Assert.assertEquals(T3_result, T3_answer);

        String T4_answer = new String(Files.readAllBytes(Paths.get(ANS_Tree4_PATH + LEV_FILENAME)));
        String T4_result = tree4.printInLevelOrder();
        Assert.assertEquals(T4_result, T4_answer);
    }
}