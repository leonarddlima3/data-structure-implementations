/* @Author : Leonard D'lima
 * @Description : This program illustrates linked list operations
 * viz., insertion at end, insertion at beginning, insertion after specific element, deletion, deletion at end, deletion after specific element, traversal
 */
package datastructures;

public class LinkedListOperations {
	
	public static Node head=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListOperations llo=new LinkedListOperations();
		llo.insertAtBeginning(4);
		llo.insertAfterElement(7, 4);
		llo.insertAtEnd(2);
		llo.insertAfterElement(1, 7);
		llo.deleteElement(7);
		llo.deleteAtEnd();
		llo.deleteAtBeginning();
		llo.parse();
	}
	
	void deleteAtBeginning(){
		if(head==null){
			return;
		}
		Node temp=head;
		if(temp.next!=null){
			head=temp.next;
			temp=null;
			return;
		}
		head=null;
	}
	
	void deleteAtEnd(){
		if(head==null){
			return;
		}
		Node temp=head;
		if(temp.next==null){
			head=null;
			return;
		}
		Node prevTemp=temp;
		while(temp.next!=null){
			prevTemp=temp;
			temp=temp.next;
		}
		prevTemp.next=null;
	}
	
	void deleteElement(int element){
		if(head==null){
			return;
		}
		Node temp=head;
		if(temp.data==element){
			head=temp.next;
			return;
		}
		while(temp.next!=null){
			if(temp.next.data==element){
				temp.next=temp.next.next;
				return;
			}
			temp=temp.next;
			
		}
		
	}
	
	void insertAtBeginning(int data){
		Node temp=new Node();
		temp.data=data;
		temp.next=null;
		if(head==null){
			head=temp;
			return;
		}
		temp.next=head;
		head=temp;
	}
	
	void insertAtEnd(int data){
		Node temp=new Node();
		temp.data=data;
		temp.next=null;
		if(head==null){
			head=temp;
			return;
		}
		Node temp1=head;
		while(temp1.next!=null){
			temp1=temp1.next;
		}
		temp1.next=temp;
	}
	
	void insertAfterElement(int data,int element){
		Node temp=new Node();
		temp.data=data;
		temp.next=null;
		if(head==null){
			return;
		}
		Node temp1=head;
		while(temp1.next!=null){
			if(temp1.data==element){
				temp.next=temp1.next;
				temp1.next=temp;
				return;
			}
			temp1=temp1.next;
		}
		if(temp1.data==element){
			temp1.next=temp;
		}
	}
	
	void parse(){
		Node temp=head;
		if(temp==null){
			return;
		}
		while(temp.next!=null){
			System.out.println(temp.data);
			temp=temp.next;
		}
		System.out.println(temp.data);
	}

}
