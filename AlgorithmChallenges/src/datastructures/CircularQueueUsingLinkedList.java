/* @Author : Leonard D'lima
 * @Description : This program illustrates circular queue using linked list implementation
 */
package datastructures;

public class CircularQueueUsingLinkedList {
	Node front=null;
	Node rear=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueueUsingLinkedList cqull=new CircularQueueUsingLinkedList();
		cqull.queue(5);
		cqull.queue(6);
		cqull.display();
		cqull.dequeue();
		cqull.display();
		cqull.dequeue();
		cqull.display();
		cqull.dequeue();
		cqull.display();
		cqull.queue(7);
		cqull.queue(8);
		cqull.display();
		cqull.dequeue();
		cqull.queue(9);
		cqull.display();
	}
	
	public void dequeue(){
		if(front==null&&rear==null){
			System.out.println("Cannot dequeue any further");
			return;
		}
		if(front==rear){
			front=null;
			rear=null;
			return;
		}
		Node temp=front;
		front=temp.next;
		Node temp1=rear;
		temp1.next=front;
	}
	
	public void queue(int data){
		Node node=new Node();
		node.data=data;
		if(front==null&&rear==null){
			rear=node;
			front=node;
			node.next=node;
			return;
		}
		
		Node temp=rear;
		rear=node;
		node.next=front;
		temp.next=node;
		return;
	}
	
	public void display(){
		if(front==null&&rear==null){
			System.out.println("Queue empty");
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
