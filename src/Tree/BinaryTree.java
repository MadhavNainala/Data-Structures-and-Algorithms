package Tree;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class BinaryTree {
	private TreeNode root;
	
	public static class TreeNode{
		private TreeNode left;
		private TreeNode right;
		private int data;
		
		public TreeNode(int data) {
			this.data=data;
			this.right = null;
			this.left = null;
		}
	
	}
	
	public void createBinaryTree() {
		TreeNode first = new TreeNode(10);
		TreeNode second = new TreeNode(20);
		TreeNode third = new TreeNode(30);
		TreeNode fourth = new TreeNode(10);

        root = first;
        first.left = second;
        first.right = third;
        
        second.left = fourth;
		
	}
	
	public void recursivePreOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		recursivePreOrder(root.left);
		recursivePreOrder(root.right);
	}
	
	public void iterativePreOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
			
		}
	}
	
	public void recursiveInOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		recursiveInOrder(root.left);
		System.out.print(root.data + " ");
		recursiveInOrder(root.right);
	}
	
	public void iterativeInOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		while(!stack.isEmpty() || temp != null) {
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
			
		}
	}
	
	public void recursivePostOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		recursivePostOrder(root.left);
		recursivePostOrder(root.right);
		System.out.print(root.data + " ");
		
	}
	
	public void iterativePostOrder(TreeNode root) {
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<>();
		while(current != null || !stack.isEmpty()) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				TreeNode temp = stack.peek().right;
				if(temp == null) {
					temp = stack.pop();
					System.out.print(temp.data + " ");
					while(!stack.isEmpty() && temp == stack.peek().right)
					{
						temp = stack.pop();
						System.out.print(temp.data + " ");
					}
				}
				else {
					current = temp;
				}
			}
		}
		
	}
	
	public void levelTraversing(TreeNode root) {
		if(root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			TreeNode temp = q.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null) {
				q.offer(temp.left);
			}
			if(temp.right != null) {
				q.offer(temp.right);
			}
		}
	}
	
	public int findMax(TreeNode root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int result = root.data;
		int left = findMax(root.left);
		int right = findMax(root.right);
		if(left > result) {
			result = left;
		}
		if(right > result) {
			result = right;
		}
		return result;
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree();
		bt.recursivePreOrder(bt.root);
		System.out.println("");
		bt.iterativePreOrder(bt.root);
		System.out.println("");
		bt.recursiveInOrder(bt.root);
		System.out.println("");
		bt.iterativeInOrder(bt.root);
		System.out.println(bt.findMax(bt.root));
	}

}
