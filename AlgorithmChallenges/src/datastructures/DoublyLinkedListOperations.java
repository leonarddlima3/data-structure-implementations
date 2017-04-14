/* @Author : Leonard D'lima
 * @Description : This program illustrates doubly linked list operations
 * viz., insertion at end, insertion at beginning, insertion after specific element, deletion, deletion at end, deletion after specific element, traversal
 */
package datastructures;

public class DoublyLinkedListOperations {
	static DoublyNode head = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedListOperations dllo = new DoublyLinkedListOperations();
		dllo.insertAtEnd(4);
		dllo.insertAtEnd(2);
		dllo.insertAtBeginning(3);
		dllo.insertAtBeginning(1);
		dllo.insertAfterElement(3, 7);
		dllo.insertAfterElement(2, 8);
		dllo.delete(7);
		dllo.deleteAtEnd();
		dllo.deleteAtBeginning();
		dllo.deleteAfterElement(4);
		dllo.parse();
	}
	
	void deleteAfterElement(int element){
		if(head==null){
			return;
		}
		DoublyNode temp=head;
		while(temp.next!=null){
			if(temp.data==element){
				temp.prev.next=temp.next;
				temp.next.prev=temp.prev;
				temp.prev=null;
				temp.next=null;
				return;
			}
			temp=temp.next;
		}
		if(temp.data==element){
			temp.prev.next=null;
			temp.prev=null;
		}
	}
	
	void deleteAtBeginning(){
		if(head==null){
			return;
		}
		DoublyNode temp=head;
		if(temp.next!=null){
			DoublyNode temp1=temp.next;
			temp1.prev=null;
			temp.next=null;
			head=temp1;
			return;
		}
		head=null;
	}
	
	void deleteAtEnd(){
		if(head==null){
			return;
		}
		DoublyNode temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		DoublyNode temp1=temp.prev;
		temp.prev=null;
		temp1.next=null;
	}

	void delete(int data) {
		if (head == null) {
			return;
		}
		DoublyNode temp = head;
		while (temp.next != null) {
			if (temp.data == data) {
				if (temp.prev != null)
					temp.prev.next = temp.next;
				else
					head = temp.next;
				temp.next.prev = temp.prev;
				temp.prev = null;
				temp.next = null;
				return;
			}
			temp = temp.next;
		}
		if (temp.data == data) {
			temp.prev.next = null;
			temp.next = null;
		}
	}

	void insertAfterElement(int element, int data) {
		if (head == null) {
			return;
		}
		DoublyNode temp = new DoublyNode();
		temp.data = data;
		temp.prev = null;
		temp.next = null;
		DoublyNode temp1 = head;
		while (temp1 != null) {
			if (temp1.data == element) {
				temp.next = temp1.next;
				temp1.next = temp;
				temp.prev = temp1;
				if (temp.next != null)
					temp.next.prev = temp;
				return;
			}
			temp1 = temp1.next;
		}
	}

	void insertAtBeginning(int data) {
		DoublyNode temp = new DoublyNode();
		temp.data = data;
		temp.prev = null;
		temp.next = null;
		if (head == null) {
			head = temp;
			return;
		}
		temp.next = head;
		temp.next.prev = temp;
		head = temp;
	}

	void insertAtEnd(int data) {
		DoublyNode temp = new DoublyNode();
		temp.data = data;
		temp.next = null;
		temp.prev = null;
		if (head == null) {
			head = temp;
			return;
		}
		DoublyNode temp1 = head;
		while (temp1.next != null) {
			temp1 = temp1.next;
		}
		temp1.next = temp;
		temp.prev = temp1;
	}

	void parse() {
		if (head == null) {
			return;
		}
		DoublyNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

}
