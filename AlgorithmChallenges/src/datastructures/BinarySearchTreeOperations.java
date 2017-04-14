/* @Author : Leonard D'lima
 * @Description : This program illustrates binary search tree operations
 * viz., insertion, deletion, breadth first search traversal and inorder traversal
 */
package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeOperations {
	
	public static void main(String args[]){
		BinarySearchTreeOperations bsto=new BinarySearchTreeOperations();
		BSTNode root=null;
		root=bsto.insert(root,4);
		root=bsto.insert(root,2);
		root=bsto.insert(root,1);
		root=bsto.insert(root,3);
		root=bsto.insert(root,6);
		root=bsto.insert(root,5);
		root=bsto.insert(root,7);
		bsto.display(root);
		bsto.delete(root, 6);
		bsto.display(root);
		bsto.breadthFirstSearchTraversal(root);
	}
	
	public void breadthFirstSearchTraversal(BSTNode root){
		if(root==null){
			return;
		}
		BSTNode temp=root;
		Queue<BSTNode> queue=new LinkedList<BSTNode>();
		queue.add(temp);
		System.out.println("Breadth first search");
		while(!queue.isEmpty()){
			System.out.println(queue.peek().data);
			temp=queue.remove();
			if(temp.left!=null)
			queue.add(temp.left);
			if(temp.right!=null)
			queue.add(temp.right);
		}
	}
	
	public BSTNode delete(BSTNode root, int data){
		if(root==null)
			return root;
		if(data<root.data){
			root.left=delete(root.left,data);
		}else if(data>root.data){
			root.right=delete(root.right,data);
		}else{
			if(root.left==null&root.right==null){
				root=null;
			}else if(root.left==null){
				root=root.right;
			}else if(root.right==null){
				root=root.left;
			}else{
				BSTNode temp=root.right;
				while(temp.left!=null){
					temp=temp.left;
				}
				root.data=temp.data;
				root.right=delete(root.right,temp.data);
			}
			
		}
		return root;
	}
	
	public BSTNode createBSTNode(int data){
		BSTNode node=new BSTNode();
		node.data=data;
		node.left=null;
		node.right=null;
		return node;
	}
	
	public BSTNode insert(BSTNode root, int data){
		
		if(root==null){
			root=createBSTNode(data);
			return root;
		}
		if(data<=root.data){
			root.left=insert(root.left, data);
		}else if(data>root.data){
			root.right=insert(root.right, data);
		}
		
		return root;
	}
	
	public void display(BSTNode root){
		inorderTraversal(root);
	}
	
	public void inorderTraversal(BSTNode root){
		if(root==null){
			return;
		}
		inorderTraversal(root.left);
		System.out.println(root.data);
		inorderTraversal(root.right);
	}
	
	

}
