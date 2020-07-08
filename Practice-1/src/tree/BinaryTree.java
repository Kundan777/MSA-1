package tree;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

//import singlyLinkedList.LinkedList;

public class BinaryTree {
	static class Node { 
        int key; 
        Node left, right; 
          
        // constructor 
        Node(int key){ 
            this.key = key; 
            left = null; 
            right = null; 
        } 
    } 
    static Node root; 
    static Node temp = root; 
    
    static void insert(Node root2, int key) {
		// TODO Auto-generated method stub
		Queue<Node> q=new java.util.LinkedList<Node>();
		q.add(root2);
		while(!q.isEmpty()){
			temp =q.peek();
			q.remove();
			if(temp.left==null){
				temp.left= new Node(key);
				break;
		}
			else 
				q.add(temp.left);
			if(temp.right==null){
				temp.right=new Node(key);
				break;
		}
			else 
				q.add(temp.right);
		}		
    	
	}
    static void inorder(Node root2) {
		if(root2==null){
			return;
		}
		inorder(root2.left);
		System.out.print(root2.key +"   " );
		inorder(root2.right);
		
	}
    static void preorder(Node root2) {
		if(root2==null){
			return;
		}
		
		System.out.print(root2.key +"   " );
		inorder(root2.left);
		inorder(root2.right);
		
	}
   
    static void postorder(Node root2) {
		if(root2==null){
			return;
		}
		
		inorder(root2.left);
		inorder(root2.right);
		System.out.print(root2.key +"   " );
		
		
	}
   
    static void levelOrder(Node root2) {
		// TODO Auto-generated method stub
		Queue<Node> q=new java.util.LinkedList<Node>();
		q.add(root2);
		while(!q.isEmpty()){
			temp =q.peek();
			q.remove();
			System.out.print(temp.key+" ");
			if(temp.left!=null){ 
				q.add(temp.left);
			}
			if(temp.right!=null){
						q.add(temp.right);
		}		
		}
    	
	}
    static void inorderWithoutRec() 
    { 
    	if(root==null)
    		return;
    	Stack<Node> s = new Stack<Node>(); 
        Node curr = root; 
        
        while(curr!=null || s.size() >0){
        	while(curr!=null){
        	s.push(curr);
        	curr=curr.left;
        	}
        	curr=s.pop();
        	System.out.println(curr.key);
        	curr=curr.right;
    }
    }    
    void MorrisTraversal(Node root) 
    { 
        Node current, pre; 
  
        if (root == null) 
            return; 
  
        current = root;
        while(current!=null){
        	if(current.left==null){
        		System.out.println(current.key + " ");
        		current=current.right;
        	}
        	else {
        		pre=current.left;
        		while(pre.right!=null && pre.right!=current){
        			pre=pre.right;
        			 if (pre.right == null) { 
                         pre.right = current; 
                         current = current.left; 
                     } 
      
                     else { 
                         pre.right = null; 
                         System.out.print(current.key + " "); 
                         current = current.right; 
                     } 
        		}
        		
        		
        	}
        	}
    }
    
    static void printPostOrder(int in1[], 
            int pre[], int n) 
{ 

    int root=search(in1,pre[0],n);
    if(root!=0)
    	printPostOrder(in1,Arrays.copyOfRange(pre, 1, n),root);
    if(root!=n-1)
    	printPostOrder(Arrays.copyOfRange(in1, root+1, n), 
                Arrays.copyOfRange(pre, 1+root, n), n - root - 1);
    System.out.print( pre[0] + " "); 
}
    static int search(int[] in1, int x, int n) {
		for(int i=0;i<n;i++)
		
			if(in1[i]==x)
				return i;
			return -1;
			
}
    static int preIndex = 0; 
    void printPost(int[] in, int[] pre, int inStrt, int inEnd) 
    {
    if(inStrt>inEnd)
    	return;
    int inIndex=search(in,inStrt,inEnd,pre[preIndex++]);
    
    printPost(in, pre, inStrt, inIndex - 1); 
    
    // traverse right tree 
    printPost(in, pre, inIndex + 1, inEnd); 

    // print root node at the end of traversal 
    System.out.print(in[inIndex] + " "); 
    }
    int search(int[] in, int startIn, int endIn, int data) 
    { 
        int i = 0; 
        for (i = startIn; i < endIn; i++)  
            if (in[i] == data)  
                return i;             
        return i; 
    } 
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 root = new Node(10); 
	        root.left = new Node(11); 
	        root.left.left = new Node(7); 
	        root.right = new Node(9); 
	        root.right.left = new Node(15); 
	        root.right.right = new Node(8); 
	       
	        System.out.print( "Inorder traversal before insertion:"); 
	        inorderWithoutRec();
	        inorder(root); 
	       
	        System.out.print( "\nInorder traversal before insertion:"); 
	        preorder(root); 
	        
	        System.out.print( "\nInorder traversal before insertion:"); 
	        postorder(root);
	        
	        System.out.print( "\nInorder traversal before insertion:"); 
	        levelOrder(root);
	        
	        int key = 12; 
	        insert(root, key); 
	       
	        System.out.print("\nInorder traversal after insertion:"); 
	        inorder(root); 
	        
	        System.out.print("\nInorder traversal after insertion:"); 
	        preorder(root); 
	        
	        System.out.print("\nInorder traversal after insertion:"); 
	        postorder(root); 
	        
	        System.out.print("\nInorder traversal after insertion:"); 
	        levelOrder(root); 
	}


	


	

}
