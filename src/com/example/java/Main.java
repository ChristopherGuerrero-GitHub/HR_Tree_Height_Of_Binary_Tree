package com.example.java;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        /*
            This program is a solution to HackerRank problem Tree Height of Binary Tree.

            The height of a binary tree is the number of edges between the tree's root and
            its furthest leaf. This means that a tree containing a single node has a height
            of 0.

            The first input will be the number of node values to be expected. The following
            integer values will be the tree node values to create. Pass the chain of
            tree node to the height method to find the height of the Binary Tree and
            return the single integer value of the height as the output

            Note: A binary search tree is a binary tree in which the value of each parent
            node's left child is less than the value the parent node, and the value of the
            parent node is less than the value of its right child.

         */

/*
        Input:
        7
        3
        5
        2
        1
        4
        6
        7   Output: 3
*/


        //Get input from console and define variables
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        //get the values for the nodes of the tree
        //invoke the insert method to create the
        //tree node chain started from the root node
        Node root = null;
        while(t-- > 0){
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();

        //invoke the height method to traverse throught the
        //Binary Search Tree and return the single integer
        //value that will represent the height.
        int height = height(root);
        System.out.println(height);

    }

    /*
        This insert method will accept two argument with the first one being a node
        value with the very first node being the root and then after that is the next
        node created will be the one passed as the node/parent of interest. The second
        parameter is the value of the next node to be created in the Tree.
     */
    public static Node insert(Node root, int data){
        if (root == null){      //base case
            return new Node(data);
        } else {
            Node curr;
            if (data < root.data){
                curr = insert(root.left,data); //traverse on left side of tree
                root.left = curr;
            }else {
                curr = insert(root.right,data); // traverse on the right side of tree
                root.right = curr;
            }
            return root;
        }

    }

    /*
        This height method traverse left and traverse right of the Binary Search Tree
        by recursively invoke the height method. A leftSum and rightSum will be
        incremented to track the height of the tree.
     */
    public static int height(Node root){
        int leftSum = 0, rightSum = 0;

        if(root.left != null){
            leftSum = height(root.left);
            leftSum++;
        }
        if (root.right != null){
            rightSum = height(root.right);
            rightSum++;
        }

        return leftSum > rightSum ? leftSum : rightSum;


    }

}
