package algorithm.dataStructure.Test;

import algorithm.dataStructure.LinkedList;
import algorithm.pojo.Node;

public class TestLinkedList {
    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertNodeAtBeginning(5);
        linkedList.printLinkedList();

        linkedList.insertNodeAtBeginning(4);
        linkedList.printLinkedList();


        linkedList.insertNodeAtEnd(6);
        linkedList.printLinkedList();

        int searchItem = 6;
        Node node = linkedList.searchItem(searchItem);
        if (node != null) {
            System.out.println("Found node with item " + searchItem + " at Node: " + node + " with data: " + node.data);
        }

        linkedList.deleteNodeWithItem(4);
        linkedList.printLinkedList();
    }
}
