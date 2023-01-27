package algorithm.dataStructure.Test;

import algorithm.dataStructure.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack stack = new Stack(2);

        stack.push(1);
        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
    }
}
