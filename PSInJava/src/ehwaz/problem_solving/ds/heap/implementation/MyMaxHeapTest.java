package ehwaz.problem_solving.ds.heap.implementation;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

/**
 * Created by Sangwook on 2016-05-09.
 */
public class MyMaxHeapTest {
    @Test
    public void heapTest1() {
        int[] inputs = {5,11,6,3,12,4,13,7,8,14,1,15,2,9,10};
        int[] sortedInputsAns = {15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        MyMaxHeap<Integer> myheap = new MyMaxHeap<Integer>();
        for (int i : inputs) {
            myheap.insert(i);
        }
        int[] sortedInputs = new int[inputs.length];
        int i = 0;
        while (myheap.isEmpty() == false) {
            sortedInputs[i] = myheap.delete();
            i++;
        }
        Assert.assertEquals(sortedInputs, sortedInputsAns);
    }

    // Testing if class throws intended exceptions.
    @Test(expectedExceptions = NoSuchElementException.class)
    public void heapExceptionTest() {
        MyMaxHeap<Integer> myheap = new MyMaxHeap<Integer>();
        myheap.delete();
    }
}