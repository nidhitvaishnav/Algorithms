package algorithm.dataStructure.Test;

import algorithm.dataStructure.BinaryTree;
import algorithm.dataStructure.BinaryTree.Node;
public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insertKey(5);
        tree.printTree();

        tree.insertKey(3);
        tree.printTree();

        tree.insertKey(2);
        tree.printTree();

        tree.insertKey(7);
        tree.printTree();

        tree.insertKey(4);
        tree.printTree();

        Node n1 = tree.treeSearch(7);
        printNode(n1);

        Node n2 = tree.iterativeTreeSearch(7);
        printNode(n2);

        Node min = tree.getMinimumNodeOfTree();
        printNode(min);

        Node max = tree.getMaximumNodeOfTree();
        printNode(max);

        tree.deleteKey(5);
        tree.printTree();
    }


    private static void printNode(Node node) {
        if (node == null){
            System.out.println("Node is empty");
        } else {
            System.out.println("Node key is: " + node.getKey());
        }
    }
}
