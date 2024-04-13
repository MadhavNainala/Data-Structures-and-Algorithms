package Queue;

import java.util.NoSuchElementException;

public class Queue {
	private ListNode front;
	private ListNode rear;
	private int length;
	
	public Queue() {
		this.front = null;
		this.rear = null;
		this.length = 0;
	}
	
	public static class ListNode{
		int data;
		ListNode next;
		
		public ListNode(int data){
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
	
	public void enqueue(int data) {
		ListNode temp = new ListNode(data);
		if(isEmpty()) {
			front = temp;
		}else {
			rear.next = temp;
		}
		rear = temp;
		length++;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is Empty");
		}
		int result = front.data;
		front = front.next;
		if(front == null) {
			rear = null;
		}
		length--;
		return result;
	}
	
	public void print() {
		if(isEmpty()) {
			return;
		}
		ListNode current = front;
		while(current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public int first() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is Empty");
		}
		return front.data;		
	}
	
	public int last() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is Empty");
		}
		return rear.data;		
	}
	
	
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(12);
		q.enqueue(20);
		q.print();
		q.dequeue();
		q.print();
	}

}
