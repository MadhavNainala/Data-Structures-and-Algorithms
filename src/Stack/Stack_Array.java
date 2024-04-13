package Stack;

public class Stack_Array {
	
	private int top;
	private int[] arr;
	
	public Stack_Array() {
		this(10);
	}

	public Stack_Array(int i) {
		this.top = -1;
		this.arr = new int[i];
	}
	
	public void push(int data) {
		if(isFull()) {
			throw new RuntimeException("stack is full");
		}
		top++;
		arr[top] = data;
		
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("stack is full");
		}
		int result = arr[top];
		top--;
		return result;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("stack is full");
		}
		return arr[top];
		
	}
	public boolean isFull() {
		return arr.length == size();
	}
	
	public int size() {
		return top+1;
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
	public static void main(String[] args) {
		Stack_Array s = new Stack_Array();
		
		s.push(10);
		s.push(15);
		s.push(2);
		
		System.out.println(s.peek());
		s.pop();
		System.out.println(s.peek());

		
	}
	

}
