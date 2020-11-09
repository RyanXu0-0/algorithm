package StackAndQueue_03;

/**
 * @description:
 * @projectName:IDEAProject
 * @see:StackAndQueue_03
 * @author:徐东
 * @createTime:2020/11/9 22:04
 * @version:1.0
 */
public class MyCircularDeque_641 {
    private int capacity;
    private int front;
    private int rear;
    private int[] arr;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque_641(int k) {
        capacity = k + 1;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        arr[front] = value;
        front = (front + 1) % capacity;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear - 1 + capacity) % capacity;
        arr[rear] = value;
        return  true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front -1 + capacity) % capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear + 1 + capacity) % capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return arr[(front - 1 + capacity) % capacity];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (rear == front) return true;
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (front + 1 + capacity) % capacity == rear;
    }
}
