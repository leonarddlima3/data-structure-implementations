/* @Author : Leonard D'lima
 * @Description : This program illustrates queue using array implementation
 */
package datastructures;

public class QueueUsingArray {
	public static int queue[]=new int[10];
	public static int front=-1,rear=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingArray qua=new QueueUsingArray();
		qua.queue(3);
		qua.queue(2);
		qua.dequeue();
		qua.parse();
	}

	void queue(int data){
		if(rear==queue.length-1){
			return;
		}
		if(front==-1&&rear==-1){
			front=rear=0;
			queue[rear]=data;
			return;
		}
		queue[++rear]=data;
	}
	
	void dequeue(){
		if(front==-1){
			return;
		}
		if(front==rear){
			front=rear=-1;
			return;
		}
		front++;
	}
	
	void parse(){
		if(front==-1){
			return;
		}
		for(int i=front;i<=rear;i++){
			System.out.println(queue[i]);
		}
	}
}
