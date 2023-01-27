package algorithm.dataStructure;

public class Queue {
    int [] arr;
    int head;
    int tail;

    public Queue(int size) {
        this.arr = new int[size];
        this.head = -1;
        this.tail = -1;
    }

    public void enqueue(int x) {
        if (isQueueFull()) {
            System.out.println("Queue is full");
            System.exit(0);
        }
        // if queue is empty, increase head and tail by 1
        // else increase tail to the next position and store the data
       if (this.head == -1) {
           this.tail++;
           this.head++;
       } else {
           this.tail = (this.tail + 1) % this.arr.length;
       }
        this.arr[this.tail] = x;

        System.out.println("added " + x);
    }

    public int dequeue() {
        int x;
        if (isQueueEmpty()) {
            System.out.println("Queue is empty");
            System.exit(1);
        }
        // queue has only 1 element, so after dequeuing that element it would become empty, so set them -1
        // else get the data and increase the head to the next position
        if (this.head == this.tail) {
            x = this.arr[this.tail];
            this.head = -1;
            this.tail = -1;
        } else {
            x = this.arr[this.head];
            this.head = (this.head + 1) % this.arr.length;
        }
        return x;
    }

    private boolean isQueueFull() {
        return ((this.tail + 1) % this.arr.length == this.head);
    }

    private boolean isQueueEmpty() {
        return (this.head == -1);
    }
}
