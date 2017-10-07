
public class BubbleSort {
	static int arr[]={5,4,3,6,7};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort b=new BubbleSort();
		//b.logic(arr);
		b.logicRecursive(arr, arr.length);
		b.display();

	}
	
	void logic(int data[]){
		int len=arr.length;
		for(int i=0;i<len-1;i++){
			for(int j=0;j<len-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
		}
	}
	
	void logicRecursive(int data[],int len){
		if(len==1){
			return;
		}
		
		for(int i=0;i<len-1;i++){
			if(data[i]>data[i+1]){
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		logicRecursive(data,len-1);
	}
	
	void display(){
		System.out.println("Sorted list:");
		for(int i=0;i<arr.length;i++){
			System.out.print(" "+arr[i]);
		}
	}
	

}
