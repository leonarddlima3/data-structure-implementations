
public class StackImpl {
	public static int arr[]=new int[10];
	public static int top=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StackImpl s=new StackImpl();
		s.push(10);
		s.push(6);
		s.pop();
		s.pop();
		s.pop();
		s.push(10);
		s.push(6);
		s.push(10);
		s.push(6);
		s.display();
		

	}
	
	void push(int data){
		if(top==arr.length-1){
			System.out.println("Stack overflow");
			return;
		}
		arr[++top]=data;
		
	}
	
	int pop(){
		if(top==-1){
			System.out.println("Stack underflow");
			return -1;
		}
		return --top;
	}
	
	void display(){
		System.out.println("Displaying array elements:");
		if(top==-1){
			System.out.println("Stack empty");
			return;
		}
		for(int i=0;i<=top;i++){
			System.out.print(" "+arr[i]);
		}
	}

}
