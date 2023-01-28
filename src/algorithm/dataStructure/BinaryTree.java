package algorithm.dataStructure;

public class BinaryTree {

    public class Node {
        private int key;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int key) {
            this.key = key;
        }
        public int getKey() {
            return this.key;
        }
    }

    Node root;

    public void insertKey(int i) {
        insertNode(new Node(i));
    }

    private void insertNode(Node node) {
        if (this.root == null) {
            this.root = node;
            return;
        }
        Node i = null;
        Node j = this.root;
        while (j != null) {
            i = j;
            if (j.key > node.key) {
                j = j.left;
            } else {
                j = j.right;
            }
        }
        node.parent = i;
        if (i.key > node.key) {
            i.left = node;
        } else {
            i.right = node;
        }
    }

    public void printTree() {
        printTreeFromNode(this.root);
        System.out.println();
    }

    private void printTreeFromNode(Node x) {
        if (x == null) {
            return;
        }
        printTreeFromNode(x.left);
        System.out.print(x.key + " ");
        printTreeFromNode(x.right);
    }

    public Node treeSearch (int k) {
        return treeSearchFromNode(this.root, k);
    }

    private Node treeSearchFromNode(Node node, int k) {
        while (node == null || node.key ==k) {
            return node;
        }
        if (node.key < k) {
            return treeSearchFromNode(node.right, k);
        } else {
            return treeSearchFromNode(node.left, k);
        }
    }

    public Node iterativeTreeSearch(int k) {
        return iterativeTreeSearchFromNode(this.root, k);
    }

    private Node iterativeTreeSearchFromNode(Node node, int k) {
        while (node != null && node.key != k) {
            if (node.key > k) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public Node getMinimumNodeOfTree() {
        return getMinimumNode(this.root);
    }

    private Node getMinimumNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Node getMaximumNodeOfTree() {
        return getMaximumNode(this.root);
    }

    private Node getMaximumNode(Node node) {
        while(node.right != null) {
            node = node.right;
        }
        return node;
    }

    public void deleteKey(int k) {
        Node node = iterativeTreeSearchFromNode(this.root, k);
        deleteNode(node);
    }

    private void deleteNode(Node node) {
        if (node.left == null) {
            transplantNodes(node, node.right);
        } else if (node.right == null) {
            transplantNodes(node, node.left);
        } else {
            Node z = getMinimumNode(node.right);
            if (z.parent != node) {
                transplantNodes(z, z.right);
                z.right = node.right;
                z.right.parent = z;
            }
            transplantNodes(node, z);
            z.left = node.left;
            z.left.parent = z;
        }
    }

    private void transplantNodes(Node oldNode, Node nodeToTransplant) {
        if (oldNode.parent == null) {
            this.root = nodeToTransplant;
        } else if (oldNode.parent.left == oldNode) {
            oldNode.parent.left = nodeToTransplant;
        } else {
            oldNode.parent.right = nodeToTransplant;
        }
        if (nodeToTransplant != null) {
            nodeToTransplant.parent = oldNode.parent;
        }
    }
}