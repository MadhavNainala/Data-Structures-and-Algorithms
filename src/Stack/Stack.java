package Stack;

import java.util.EmptyStackException;

public class Stack {
	
	private ListNode top;
	private int length;
	
	public Stack() {
		this.top = null;
		this.length = 0;
	}
	
	public static class ListNode{
		int data;
		ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int length() {
		return length;
	}
	
	public void push(int data) {
		ListNode temp = new ListNode(data);
		temp.next = top;
		top = temp;
		length++;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		int result=top.data;
		top = top.next;
		length--;
		return result;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		int result=top.data;
		return result;
		
	}
	
	public static void main(String[] args) {
		Stack s = new Stack();
		
		s.push(10);
		s.push(15);
		s.push(2);
		
		System.out.println(s.peek());
		s.pop();
		System.out.println(s.peek());

		
	}
	
	

}
