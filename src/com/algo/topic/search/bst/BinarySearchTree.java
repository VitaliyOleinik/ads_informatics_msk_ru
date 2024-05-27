package com.algo.topic.search.bst;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

public class BinarySearchTree {

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int value) {
        root = insertValue(root, value);
    }

    private Node insertValue(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertValue(root.left, value);
        } else if (value > root.value) {
            root.right = insertValue(root.right, value);
        }

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    boolean search(int value) {
        return searchValue(root, value) != null;
    }

    private Node searchValue(Node root, int value) {
        if (root == null || root.value == value) {
            return root;
        }

        if (root.value > value) {
            return searchValue(root.left, value);
        }

        return searchValue(root.right, value);
    }

    void printTree() {
        printTreeRec(root, 0);
    }

    private void printTreeRec(Node root, int space) {
        int count = 5; // кол-во пробелов между уровнями
        if (root == null) {
            return;
        }

        space += count;

        printTreeRec(root.right, space);

        System.out.println();
        for (int i = count; i < space; i++)
            System.out.print(" ");
        System.out.print(root.value + "\n");

        printTreeRec(root.left, space);
    }
}

class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Вставка узлов в дерево */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Симметричный обход дерева
        System.out.print("In-order: ");
        tree.inorder(); // Вывод: 20 30 40 50 60 70 80
        System.out.println();

        // Прямой обход дерева
        System.out.print("Pre-order: ");
        tree.preorder(); // Вывод: 50 30 20 40 70 60 80
        System.out.println();

        // Обратный обход дерева
        System.out.print("Post-order: ");
        tree.postorder(); // Вывод: 20 40 30 60 80 70 50
        System.out.println();
        // Поиск узла в дереве
        System.out.println(tree.search(30)); // Вывод: true
        System.out.println(tree.search(90)); // Вывод: false

        tree.printTree();
    }
}
