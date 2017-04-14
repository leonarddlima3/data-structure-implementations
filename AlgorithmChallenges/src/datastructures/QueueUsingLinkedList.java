/* @Author : Leonard D'lima
 * @Description : This program illustrates queue using linked list implementation
 */
package datastructures;

public class QueueUsingLinkedList {
	static Node front=null;
	static Node rear=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingLinkedList qull=new QueueUsingLinkedList();
		qull.queue(3);
		qull.queue(1);
		qull.dequeue();
		qull.parse();
	}
	
	public void queue(int data){
		Node temp=new Node();
		temp.data=data;
		temp.next=null;
		if(front==null){
			front=temp;
			rear=temp;
			return;
		}
		Node temp1=rear;
		temp1.next=temp;
		rear=temp;
		
	}
	
	public void dequeue(){
		if(front==null){
			return;
		}
		if(front==rear){
			front=null;
			rear=null;
			return;
		}
		Node temp=front;
		front=temp.next;
	}
	
	public void parse(){
		if(front==null){
			return;
		}
		Node temp=front;
		while(temp!=rear){
			System.out.println(temp.data);
			temp=temp.next;
		}
		System.out.println(temp.data);
	}
	
}
