/* @Author : Leonard D'lima
 * @Description : This program illustrates circular queue using array implementation
 */
package datastructures;

public class CircularQueueUsingArray {
	static int arr[]={-1,-1,-1,-1,-1,-1,-1,-1,-1};
	static int front=-1;
	static int rear=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularQueueUsingArray cqua=new CircularQueueUsingArray();
		cqua.queue(2);
		cqua.queue(4);
		cqua.queue(5);
		cqua.queue(6);
		cqua.queue(7);
		cqua.queue(8);
		cqua.queue(9);
		cqua.queue(10);
		cqua.queue(11);
		cqua.queue(12);
		cqua.display();
		cqua.dequeue();
		cqua.display();
		cqua.queue(13);
		cqua.queue(14);
		cqua.display();
	}
	
	public void queue(int data){
		if(front==-1&&rear==-1){
			front=0;
			rear=0;
			arr[rear]=data;
			return;
		}
		if((rear+1)%arr.length==(front)%arr.length){
			System.out.println("Cannot add more elements to the queue");
			return;
		}else{
			rear=(rear+1)%arr.length;
			arr[rear]=data;
			return;
		}
	}
	
	public void dequeue(){
		if(front==-1&&rear==-1){
			System.out.println("cannot delete further");
			return;
		}
		if(front==rear){
			front=-1;
			rear=-1;
			return;
		}
		front=(front+1)%arr.length;
		
		
	}
	
	public void display(){
		if(front==-1&&rear==-1){
			return;
		}
		int i=front;
		while(i!=rear){
			System.out.println(arr[i]);
			i=(i+1)%arr.length;
		}
		System.out.println(arr[i]);
	}

}
