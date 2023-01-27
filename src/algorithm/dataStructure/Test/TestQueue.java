package algorithm.dataStructure.Test;

import algorithm.dataStructure.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue queue = new Queue(2);

        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
