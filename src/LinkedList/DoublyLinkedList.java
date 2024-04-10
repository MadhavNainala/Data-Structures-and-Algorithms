package LinkedList;

import java.util.NoSuchElementException;

import LinkedList.SinglyLinkedList.ListNode;

public class DoublyLinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int length;
	
	public static class ListNode{
		int data;
		ListNode previous;
		ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.previous = null;
			this.next = null;
		}
	}
	
	public DoublyLinkedList(){
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int length() {
		return length;
	}
	
	public void displayForward() {
		if(head == null) {
			return;
		}
		ListNode current = head;
		while(current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.println("null");		
	}
	
	public void displayBackward() {
		if(tail == null) {
			return;
		}
		ListNode current = tail;
		while(current != null) {
			System.out.print(current.data + "->");
			current = current.previous;
		}
		System.out.println("null");		
	}
	
	public void insertFirst(int value) {
	    ListNode newNode = new ListNode(value);
	    if(isEmpty()) {
	        tail = newNode;
	    } else {
	        head.previous = newNode;
	    }
	    newNode.next = head;
	    head = newNode;
	    length++;
	}
	
	public void insertEnd(int value) {
		ListNode newNode = new ListNode(value);
		if(isEmpty()) {
			head = newNode;
		}else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;
		length++;
	}
	
	public ListNode deleteFirstNode() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = head;
		if(head == tail) {
			tail = null;
		}else {
			head.next.previous = null;
		}
		head = head.next;
		temp.next = null;
		length--;
		return temp;
	}
	
	public ListNode deleteLastNode() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = tail;
		if(head == tail) {
			head = null;
		}else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		temp.previous = null;
		length--;
		return temp;
	}
	
	public static void main(String[] args) {
		
		DoublyLinkedList dll = new DoublyLinkedList();
		
		dll.insertFirst(1);
		dll.insertFirst(10);
		
		dll.insertEnd(12);
		dll.insertEnd(2);
		
		dll.displayForward();
		dll.displayBackward();
		
		dll.deleteFirstNode();
		
		dll.displayForward();
		dll.displayBackward();
		
		dll.deleteLastNode();
		
		dll.displayForward();
		dll.displayBackward();
		
		
	}

}
