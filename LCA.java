//This is my Java Code for the Lowest Common Ancestor Problem
//My graphh at the moment is structured as a binary tree

import java.util.List;
import java.util.ArrayList;

//add a node
// v is equal to a value
class Node { 

    int data; 
    Node left, right; 
  
    Node(int v) {

        data = v; 
        left = right = null; 
    
    } 
} 

public class LCA {

	Node root; 

    private List<Integer> path0 = new ArrayList<>(); 
    private List<Integer> path1 = new ArrayList<>(); 

 	//finds path from root to node
    int LCA(int n0, int n1) 
    { 
        path0.clear(); 
        path1.clear(); 
        return LCAInternal(root, n0, n1); 
    } 

    private int LCAInternal(Node root, int n0, int n1) { 
  
        if (!findPath(root, n0, path0) || !findPath(root, n1, path1)) { 
            System.out.println((path0.size() > 0) ? "n0 is present" : "n0 is missing"); 
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing"); 
            return -1; 
        } 
  
        int x; 
        for (x = 0; x < path1.size() && x < path0.size(); x++) 
        { 
            if (!path0.get(x).equals(path1.get(x))) 
                break; 
        } 
  
        return path0.get(x-1); 
    }

    private boolean findPath(Node root, int n, List<Integer> path) 
    { 
        // base case 
        if (root == null) { 
            return false; 
        } 
          
        // Saves this node unless its not on the path 
        // from the root to the wanted node 
        path.add(root.data); 
  
        if (root.data == n) { 
            return true; 
        } 
  
        if (root.right != null && findPath(root.right, n, path)) { 
            return true; 
        } 

        if (root.left != null && findPath(root.left, n, path)) { 
            return true; 
        } 
  
        path.remove(path.size()-1); 
  
        return false; 
    }

	
    public static void main(String[] args) 
    { 
        LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
  
        System.out.println("LCA(6, 7) = " + tree.LCA(6,7)); 
        System.out.println("LCA(3, 5) = " + tree.LCA(3,5)); 
        System.out.println("LCA(8, 9) = " + tree.LCA(8,9)); 
        System.out.println("LCA(5, 6) = " + tree.LCA(5,6));
        System.out.println("LCA(7, 9) = " + tree.LCA(7,9));
        System.out.println("LCA(8, 6) = " + tree.LCA(8,6));
        System.out.println("LCA(4, 5) = " + tree.LCA(4,5));

      
    } 
}