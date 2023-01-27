package algorithm.dataStructure;

public class Stack {
    public int[] arr;
    private int top;

    public Stack(int size) {
        arr = new int[size];
        top = -1;
    }

    /**
     * If stack is not full, given item pushes an item on the top of the stack
     *
     * @param i
     *      integer value i to be stored on the stack
     */
    public void push(int i) {
        if (isStackFull()) {
            System.out.println("Error: item " + i + "cannot be added. Stack is full.");
            System.exit(1);
        }
        this.top +=1;
        this.arr[this.top] = i;
        System.out.println("Pushing item " + i);
    }

    /**
     * If stack is not empty, given method pops the top item from the stack
     *
     * @return
     *      integer value from the top of the stack
     */
    public int pop() {
        if (isStackEmpty()) {
            System.out.println("Error: Stack is Empty");
            System.exit(1);
        }
        int item = this.arr[this.top];
        System.out.println("Popping item " + item);

        this.top--;
        return item;
    }

    private boolean isStackEmpty() {
        return (this.top == -1);
    }

    private boolean isStackFull() {
        return (this.top == this.arr.length - 1);
    }
}