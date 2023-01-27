package algorithm.dataStructure;

import algorithm.pojo.Node;

public class LinkedList {
    Node head;

    public void printLinkedList() {
        Node node = this.head;
        System.out.print(node.data + " ");
        while (node.next != null) {
            node = node.next;
            System.out.print(node.data + " ");
        }
        System.out.println();
    }

    public void insertNodeAtBeginning(int i) {
        Node node = new Node(i);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    public void insertNodeAtEnd(int i) {
        Node node = new Node(i);
        if (this.head == null) {
            this.head = node;
        } else {
            Node prevNode = this.head;
            while (prevNode.next != null) {
                prevNode = prevNode.next;
            }
            prevNode.next = node;
            node.prev = prevNode;
        }
    }

    public Node searchItem(int i) {
        Node node = this.head;
        while(node != null) {
            if (node.data == i) {
                return node;
            }
            node = node.next;
        }
        System.out.println(i + " is not in the linkedList.");
        return null;
    }

    public void deleteFirst() {
        if (this.head == null) {
            System.out.println("ERROR: LinkedList is empty");
            return;
        }
        Node node = this.head.next;
        node.prev = null;
        this.head = node;
    }

    public void deleteLast() {
        if (this.head == null) {
            System.out.println("ERROR: LinkedList is empty");
            return;
        }
        Node node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        Node prevNode = node.prev;
        prevNode.next = null;
        node.prev = null;
    }

    public void deleteNodeWithItem(int i) {
        Node node = searchItem(i);
        if (node == null) {
            return;
        }
        // deleting first node
        if (node.prev == null) {
            if (node.next == null) {
                this.head = null;
            } else {
                this.head = node.next;
            }
        }
        else if (node.next == null) {           // deleting last node
            node.prev.next = null;
        } else {
            node.prev.next = node.next;
        }
    }
}
