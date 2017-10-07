
public class QuickSort {
	static int arr[]={2,1,4,8,6,7,3,5};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort q=new QuickSort();
		q.quickSort(arr, 0, arr.length-1);
		q.display();
	}
	
	void quickSort(int arr[],int start,int end){
		if(start<end){
			int pIndex=partition(arr, start, end);
			
			
			quickSort(arr, start, pIndex-1);
			quickSort(arr, pIndex+1, end);
		}
	}
	
	int partition(int arr[],int start,int end){
		
		int pivot=arr[end];
		
		int pIndex=start;
		for(int i=start;i<end;i++){
			if(arr[i]<=pivot){
				int temp=arr[pIndex];
				arr[pIndex]=arr[i];
				arr[i]=temp;
				pIndex++;
			}
		}
		
		if(arr[pIndex]>pivot){
			int temp=arr[pIndex];
			arr[pIndex]=pivot;
			pivot=temp;
		}
		arr[end]=pivot;
		
		return pIndex;
	}
	
	void display(){
		System.out.println("Sorted list:");
		for(int i=0;i<arr.length;i++){
			System.out.print(" "+arr[i]);
		}
	}

}
