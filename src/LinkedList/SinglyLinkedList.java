package LinkedList;

public class SinglyLinkedList {
	
	private ListNode head;
	
	public static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	public int length() {
		if(head == null) {
			return 0;
		}
		int count=0;
		ListNode current = head;
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	public void display(ListNode head) {
		ListNode current = head;
		while(current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.println("null");		
	}
	
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode; 
	}
	
	public void insert(int value, int position) {
		 ListNode newNode = new ListNode(value);
		 if(position == 1) {
			 newNode.next = head;
			 head = newNode; 			
		 }	else {
			 int count = 1;
			 ListNode previous = head;
			 while(count < position -1) {
				 previous = previous.next;
				 count++;
			 }
			 ListNode current = previous.next;
			 previous.next = newNode;
			 newNode.next=current;
			 
		 }
	}
	
	public void insertEnd(int value) {
		 ListNode newNode = new ListNode(value);
	     if(head == null) {
	    	 head = newNode;
	    	 return;
	     }
	     ListNode current = head;
	     while(null != current.next) {
	    	 current = current.next;
	     }
	     current.next = newNode;
	}
	
	public ListNode deleteFirst() {
		if(head == null) {
			return null;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}
	
	public ListNode deleteLast() {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode current = head;
		ListNode previous = null;
		while(current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		return current;
	}
	
	public void delete(int position) {
		if(position == 1) {
			head = head.next;
		}else{
			 int count = 1;
			 ListNode previous = head;
			 while(count < position -1) {
				 previous = previous.next;
				 count++;
			 }
			 ListNode current = previous.next;
			 previous.next = current.next;			 
		 }
	}
	
	public boolean searchKey(int value) {
		ListNode current = head;
		while(current != null) {
			if(current.data == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	public ListNode reverse(ListNode head) {
		if(head == null) {
			return head;
		}
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;		
		}
		return previous;
	}
	
	public ListNode findNthLinkedList(ListNode head, int value) {
		if(head == null) {
			return null;
		}
		if(value<=0) {
			throw new IllegalArgumentException("Invalid Number");
		}
		ListNode previous = head;
		ListNode ref = head;
		int count =0;
		while(count < value) {
			if(ref == null) {
				throw new IllegalArgumentException(value + "greater than number of nodes");
			}
			ref = ref.next;
		    count++;			
		}
		while(ref != null) {
			ref = ref.next;
			previous = previous.next;
		}
		return previous;
	}
	
	public void removeDuplicates(ListNode head) {
		if(head == null) {
			return;
		}
		ListNode current = head;
		while(current != null && current.next != null) {
			if(current.data == current.next.data) {
				current.next = current.next.next;
			}
			else {
				current = current.next;
			}
		}
	}
	
	public ListNode insertInSortedList(int value) {
		ListNode newNode = new ListNode(value);
		if(head == null) {
			return newNode;
		}
		if (newNode.data < head.data) { // if the value is smaller than the head, insert at the beginning
	        newNode.next = head;
	        return newNode;
	    }
		ListNode current = head;
		ListNode temp = null;
		while(current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}
		newNode.next = current;
		temp.next = newNode;
		return head;
		
	}
	
	public void deleteNode(int value) {
		ListNode current = head;
		ListNode temp = null;
		if(current !=  null && current.data == value) {
			head = current.next;
			return;
		}
		while(current != null && current.data != value) {
			temp = current;
			current = current.next;
		}
		if(current == null) return;
		temp.next = current.next;
	}
	
	public boolean containsLoop() {
		ListNode fastptr = head;
		ListNode slowptr = head;
		while(fastptr != null && fastptr.next != null) {
			fastptr = fastptr.next.next;
			slowptr = slowptr.next;
			if(slowptr == fastptr) {
				return true;
			}
		}
		return false;
	}
	
	public ListNode findLoop() {
		ListNode fastptr = head;
		ListNode slowptr = head;
		while(fastptr != null && fastptr.next != null) {
			fastptr = fastptr.next.next;
			slowptr = slowptr.next;
			if(slowptr == fastptr) {
				return getStartingLoop(slowptr);
			}
		}
		return null;
	}
	
	public ListNode getStartingLoop(ListNode slowptr) {
		ListNode temp = head;
		while(temp != slowptr) {
			temp = temp.next;
			slowptr = slowptr.next;
		}
		return temp;
	}
	
	public void findLoopNode() {
		ListNode fastptr = head;
		ListNode slowptr = head;
		while(fastptr != null && fastptr.next != null) {
			fastptr = fastptr.next.next;
			slowptr = slowptr.next;
			if(slowptr == fastptr) {
				removeLoop(slowptr);
				return;
			}
		}
	}
	
	public void removeLoop(ListNode slowptr) {
		ListNode temp = head;
		while(temp.next != slowptr.next) {
			temp = temp.next;
			slowptr = slowptr.next;
		}
		slowptr.next = null;
	}
	
	public ListNode mergeNodes(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(a != null && b != null) {
			if(a.data <= b.data) {
				tail.next = a;
				a = a.next;
			}else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}
		if(a == null) {
			tail.next = b;
		}else {
			tail.next = a;
		}
		return dummy.next;
	}
	
	public ListNode addNodes(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int carry = 0;
		while(a != null || b != null) {
			int x = (a != null) ? a.data : 0;
			int y = (b != null) ? b.data : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			tail.next = new ListNode(sum % 2);
			tail = tail.next;
			if (a.next != null) {
				a = a.next;
			}
			if (b.next != null) {
				b = b.next;
			}			
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.head = new ListNode(1);
		ListNode second = new ListNode(3);
		ListNode third = new ListNode(7);
		ListNode fourth = new ListNode(9);
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        
        System.out.println(sll.containsLoop());
        System.out.println(sll.findLoop().data);
        sll.findLoopNode();
        sll.display(sll.head);

        

	}

}
