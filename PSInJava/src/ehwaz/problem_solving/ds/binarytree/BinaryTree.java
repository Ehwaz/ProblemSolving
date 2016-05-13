package ehwaz.problem_solving.ds.binarytree;

import lombok.Getter;
import lombok.Setter;

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

    /* Util functions */
    public int getHeightRec() {
        if (this.left == null && this.right == null) {
            return 1;
        }
        int leftDepth = (this.left != null) ? this.left.getHeightRec() : -1;
        int rightDepth = (this.right != null) ? this.right.getHeightRec() : -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int getHeight() {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(this);

        int curHeight = 0;
        while (true) {
            int nodeNumAtThisLevel = queue.size();
            if (nodeNumAtThisLevel == 0) {
                return curHeight;
            }
            curHeight++;

            while (nodeNumAtThisLevel > 0) {
                BinaryTree newNode = queue.poll();
                if (newNode.left != null) {
                    queue.add(newNode.left);
                }
                if (newNode.right != null) {
                    queue.add(newNode.right);
                }
                nodeNumAtThisLevel--;
            }
        }
    }

    // Ref: http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
    class HeightValue {
        int height = 0;
    }
    public int getDiametorRecUtil(HeightValue HV) {
        if (this.left == null && this.right == null) {
            HV.height = 1;
            return 1;
        }

        HeightValue leftHV = new HeightValue();
        HeightValue rightHV = new HeightValue();
        if (this.left != null) leftHV.height++;
        if (this.right != null) rightHV.height++;

        int leftTreeDiameter = (this.left != null) ? this.left.getDiametorRecUtil(leftHV) : -1;
        int rightTreeDiameter = (this.right != null) ? this.right.getDiametorRecUtil(rightHV) : -1;

        HV.height = Math.max(leftHV.height, rightHV.height) + 1;
        return Math.max(leftHV.height + rightHV.height + 1, Math.max(leftTreeDiameter, rightTreeDiameter));
    }
    public int getDiametorRec() {
        HeightValue hv = new HeightValue();
        return getDiametorRecUtil(hv);
    }

    public int getDiametorRecOn2() {
        if (this.left == null && this.right == null) { return 1; }

        int leftTreeHeight = (this.left != null) ? this.left.getHeight() : -1;
        int rightTreeHeight = (this.right != null) ? this.right.getHeight() : -1;

        int leftTreeDiameter = (this.left != null) ? this.left.getDiametorRecOn2() : -1;
        int rightTreeDiameter = (this.right != null) ? this.right.getDiametorRecOn2() : -1;

        return Math.max(leftTreeHeight + rightTreeHeight + 1, Math.max(leftTreeDiameter, rightTreeDiameter));
    }

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