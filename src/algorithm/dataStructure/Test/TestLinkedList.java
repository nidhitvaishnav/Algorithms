package algorithm.dataStructure.Test;

import algorithm.dataStructure.LinkedList;
import algorithm.pojo.Node;

public class TestLinkedList {
    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertItemAtBeginning(5);
        linkedList.printLinkedList();

        linkedList.insertItemAtBeginning(4);
        linkedList.printLinkedList();


        linkedList.insertItem(6);
        linkedList.printLinkedList();

        int searchItem = 6;
        Node node = linkedList.searchItem(searchItem);
        if (node != null) {
            System.out.println("Found node with item " + searchItem + " at Node: " + node + " with data: " + node.data);
        }

        linkedList.deleteNodeWithItem(4);
        linkedList.printLinkedList();

        testCycle();
    }

    private static void testCycle() {
        LinkedList linkedList = new LinkedList();
        System.out.println("0 nodes: is Cycle detected:" + linkedList.isCyclic());
        linkedList.insertItemAtBeginning(2);
        System.out.println("1 nodes: is Cycle detected:" + linkedList.isCyclic());
        linkedList.insertItem(0);
        System.out.println("2 nodes: is Cycle detected:" + linkedList.isCyclic());
        linkedList.insertItem(5);
        System.out.println("3 nodes: is Cycle detected:" + linkedList.isCyclic());
        linkedList.insertItem(1000);
        System.out.println("3 nodes: is Cycle detected:" + linkedList.isCyclic());

        // create a cycle
        Node node = linkedList.searchItem(5);
        linkedList.insertNodeAtEnd(node);
        System.out.println("3 nodes: is Cycle detected:" + linkedList.isCyclic());
    }
}
