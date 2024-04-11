package LinkedList;

import java.util.NoSuchElementException;

public class CircularLinkedList {

	private ListNode last;
	private int length;
	
	public static class ListNode{
		
		public int data;
		public ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
		
	}
	
	public CircularLinkedList() {
		this.last = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int length() {
		return length;
	}
	
	public void display()
	{
		if (last == null) {
			return;
		}
		ListNode first = last.next;
		while(first != last) {
			System.out.print(first.data + "=>");
			first = first.next;
		}
		System.out.println(first.data);
	}
	
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		if(last == null) {
			last = newNode; 
		}else {
			newNode.next = last.next;
		}		
		last.next = newNode;
		length++;
	}
	
	public void insertEnd(int value) {
		ListNode newNode = new ListNode(value);
		if(last == null) {
			last = newNode;
			last.next = last;
		}
		else {
			newNode.next =last.next;
			last.next = newNode;
			last = newNode;			
		}	
		length++;
	}
	
	public int deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = last.next;
		int result = temp.data;
		if(last.next == last) {
			last = null;
		}
		else {
			last.next = temp.next;
		}		
//		temp.next = null;
		length--;
		return result;
	
	}
	
	public static void main(String[] args) {
//			ListNode firstNode = new ListNode(1);
//			ListNode secondNode = new ListNode(10);
//			ListNode thirdNode = new ListNode(5);
//			ListNode fourthNode = new ListNode(2);
//			
//			firstNode.next = secondNode;
//			secondNode.next = thirdNode;
//			thirdNode.next = fourthNode;
//			fourthNode.next = firstNode;
			
			CircularLinkedList cll = new CircularLinkedList();
			
//			cll.last = fourthNode;
			
//			cll.insertFirst(10);
//			cll.insertFirst(15);
			
			cll.insertEnd(2);
			cll.insertEnd(5);
			cll.insertEnd(9);
			
			cll.display();
            
			System.out.println(cll.deleteFirst());

			cll.display();
		}
	
	
}
