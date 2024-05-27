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
        tree.inorder(); // Вывод: 20 30 40 50 60 70 80

        // Поиск узла в дереве
        System.out.println(tree.search(30)); // Вывод: true
        System.out.println(tree.search(90)); // Вывод: false
    }
}
