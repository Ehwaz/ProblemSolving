package ehwaz.problem_solving.ds.heap.implementation;

import java.util.*;

/**
 * Created by Sangwook on 2016-05-09.
 * Ref: https://www.youtube.com/watch?v=W81Qzuz4qH0
 */
public class MyMaxHeap<T extends  Comparable<T>> {
    private ArrayList<T> elements;

    public MyMaxHeap() {
        elements = new ArrayList<T>();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void insert(T elem) {
        elements.add(elem);
        siftUp();
    }

    public String toString() {
        return elements.toString();
    }

    public T delete() throws NoSuchElementException {
        if (elements.size() == 0) {
            throw new NoSuchElementException();
        }
        if (elements.size() == 1) {
            return elements.remove(0);
        }

        T returnVal = elements.get(0);
        elements.set(0, elements.remove(elements.size() - 1));
        siftDown();
        return returnVal;
    }

    private void siftUp() {
        int curIdx = elements.size() -1;
        int parentIdx;
        T curItem, parentItem;
        while (curIdx > 0) {
            parentIdx = (curIdx - 1) / 2;
            curItem = elements.get(curIdx);
            parentItem = elements.get(parentIdx);
            if (curItem.compareTo(parentItem) > 0) {
                elements.set(curIdx, parentItem);
                elements.set(parentIdx, curItem);
                curIdx = parentIdx;
            } else {
                break;
            }
        }
    }

    private void siftDown() {
        int curIdx = 0;
        int curLeftChildIdx = 2 * curIdx + 1;
        int curRightChildIdx, biggerChildIdx;
        T temp;
        while (curLeftChildIdx < elements.size()) {
            curRightChildIdx = curLeftChildIdx + 1;
            biggerChildIdx = curLeftChildIdx;
            if (curRightChildIdx < elements.size()) {
                if (elements.get(curRightChildIdx).compareTo(elements.get(curLeftChildIdx)) > 0) {
                    biggerChildIdx = curRightChildIdx;
                }
            }
            if (elements.get(curIdx).compareTo(elements.get(biggerChildIdx)) < 0) {
                temp = elements.get(curIdx);
                elements.set(curIdx, elements.get(biggerChildIdx));
                elements.set(biggerChildIdx, temp);
                curIdx = biggerChildIdx;
                curLeftChildIdx = 2 * curIdx + 1;
            } else {
                break;
            }
        }
    }
}
