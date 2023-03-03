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

    public void insertItemAtBeginning(int i) {
        Node node = new Node(i);
        insertNodeAtBeginning(node);
    }
    public void insertNodeAtBeginning(Node node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    public void insertItem(int i) {
        Node node = new Node(i);
        insertNodeAtEnd(node);
    }

    public void insertNodeAtEnd(Node node) {
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

    public boolean isCyclic() {
        if (this.head == null || this.head.next == null) {
            return false;       // no cycle as list is empty or have 1 item
        }
        Node current = this.head;
        Node fast = this.head.next;
        while(current.next != null) {
            if (current == fast) {
                return true;        // cycle is detected
            }
            current = current.next;
            if (fast.next == null || fast.next.next == null) {
                return false;       // we reached at the end, no cycle
            }
            fast = fast.next.next;
        }

        return false;
    }
}
