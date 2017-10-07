
public class InsertionSort {
	static int arr[]={5,4,3,2,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort i=new InsertionSort();
		//i.logic(arr);
		i.logicRecursive(arr, arr.length);
		i.display();
	}
	
	void logic(int arr[]){
		int len=arr.length;
		for(int i=1;i<len;i++){
			int key=arr[i];
			for(int j=i-1;j>=0;j--){
				if(arr[j]>key){
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
			
		}
	}
	
	void logicRecursive(int arr[],int n){
		if(n<=1){
			return;
		}
		logicRecursive(arr, n-1);
		int key=arr[n-1];
		int j=n-2;
		
		while(j>=0&&arr[j]>key){
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1]=key;
	}
	
	void display(){
		System.out.println("Sorted list:");
		for(int i=0;i<arr.length;i++){
			System.out.print(" "+arr[i]);
		}
	}

}
