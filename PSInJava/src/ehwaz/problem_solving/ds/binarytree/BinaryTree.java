package ehwaz.problem_solving.ds.binarytree;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.groovy.ast.expr.BinaryExpression;

import java.util.*;

/**
 * Created by Sangwook on 2016-04-09.
 */
public class BinaryTree {
    @Getter @Setter private int value;
    @Getter @Setter private BinaryTree parent;
    @Getter private BinaryTree left;
    @Getter private BinaryTree right;

    public BinaryTree(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BinaryTree)) {
            return false;
        } else if (obj == this) { return true; }

        BinaryTree otherNode = (BinaryTree)obj;
        if (this.value != otherNode.value) { return false; }

        if (this.left == null) {
            if (otherNode.left != null) { return false; }
        } else {
            if ( !(this.left.equals(otherNode.left)) ) { return false; }
        }

        if (this.right == null) {
            if (otherNode.right != null) {return false; }
        } else {
            if ( !(this.right.equals(otherNode.right)) ) { return false; }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = value;
        if (this.left != null) {
            result += 7 * this.left.hashCode();
        }
        if (this.right != null) {
            result += 11 * this.right.hashCode();
        }
        return result;
    }

    public void setLeft(BinaryTree newLeft) { this.left = newLeft; newLeft.setParent(this); }
    public void setRight(BinaryTree newRight) { this.right = newRight; newRight.setParent(this); }


    /* Traversal Methods */

    public String printInPreOrderRec() {
        StringBuilder result = new StringBuilder();
        buildPreOrderRec(result);
        return result.toString().trim();
    }
    private void buildPreOrderRec(StringBuilder result) {
        result.append(this.value + " ");
        if (this.left != null) { this.left.buildPreOrderRec(result); }
        if (this.right != null) { this.right.buildPreOrderRec(result); }
    }

    public String printInPreOrder() {
        StringBuilder result = new StringBuilder();
        Stack<BinaryTree> nodeStack = new Stack<BinaryTree>();
        nodeStack.push(this);

        BinaryTree curNode;
        while ( !nodeStack.empty() ) {
            curNode = nodeStack.pop();
            result.append(curNode.value + " ");

            if (curNode.right != null) { nodeStack.push(curNode.right); }
            if (curNode.left != null) { nodeStack.push(curNode.left); }
        }

        return result.toString().trim();
    }

    public String printInPostOrderRec() {
        StringBuilder result = new StringBuilder();
        buildPostOrderRec(result);
        return result.toString().trim();
    }
    private void buildPostOrderRec(StringBuilder result) {
        if (this.left != null) { this.left.buildPostOrderRec(result); }
        if (this.right != null) { this.right.buildPostOrderRec(result); }
        result.append(this.value + " ");
    }

    public String printInPostOrder() {
        StringBuilder result = new StringBuilder();
        Vector<String> resultVec = new Vector<String>();
        Stack<BinaryTree> nodeStack = new Stack<BinaryTree>();
        nodeStack.push(this);

        BinaryTree curNode;
        while( !nodeStack.empty() ) {
            curNode = nodeStack.pop();
            resultVec.add(Integer.toString(curNode.value));

            if (curNode.left != null) { nodeStack.push(curNode.left); }
            if (curNode.right != null) { nodeStack.push(curNode.right); }
        }

        // Reverse result.
        for (int i = resultVec.size()-1; i >= 0; i--) {
            result.append(resultVec.get(i) + " ");
        }

        return result.toString().trim();
    }

    public String printInInOrderRec() {
        StringBuilder result = new StringBuilder();
        buildInOrderRec(result);
        return result.toString().trim();
    }
    private void buildInOrderRec(StringBuilder result) {
        if (this.left != null) { this.left.buildInOrderRec(result); }
        result.append(this.value + " ");
        if (this.right != null) { this.right.buildInOrderRec(result); }
    }

    // Reference: https://leetcode.com/discuss/36713/solutions-iterative-recursive-traversal-different-solutions
    // Time: O(n), Space: O(n)
    // TODO: An algorithm called Morris traversal provides O(1) space & O(n) time complexity.
    public String printInInOrder() {
        StringBuilder result = new StringBuilder();
        Stack<BinaryTree> nodeStack = new Stack<BinaryTree>();

        BinaryTree curNode = this;
        while (curNode != null || !nodeStack.empty()) {
            if (curNode != null) {
                nodeStack.push(curNode);
                curNode = curNode.left;
            } else {
                curNode = nodeStack.pop();
                result.append(curNode.value + " ");
                curNode = curNode.right;
            }
        }
        return result.toString().trim();
    }

    public String printInLevelOrder() {
        StringBuilder result = new StringBuilder();
        Queue<BinaryTree> nodeQueue = new LinkedList<>();
        nodeQueue.add(this);

        BinaryTree curNode;
        while( !nodeQueue.isEmpty() ) {
            curNode = nodeQueue.poll();
            result.append(curNode.value + " ");
            if (curNode.left != null) { nodeQueue.add(curNode.left); }
            if (curNode.right != null) { nodeQueue.add(curNode.right); }
        }

        return result.toString().trim();
    }

}