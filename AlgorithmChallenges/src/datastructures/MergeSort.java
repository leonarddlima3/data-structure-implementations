
public class MergeSort {
	static int arr[]={2,3,1,4,5,6,2};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort m=new MergeSort();
		m.mergeSort(arr, arr.length);
		m.display();
	}
	
	int[] mergeSort(int arr[],int n){
		if(n<2){
			return arr;
		}
		int mid=n/2;
		int l[]=new int[mid];
		int r[]=new int[n-mid];
		for(int i=0;i<mid;i++){
			l[i]=arr[i];
		}
		for(int i=mid;i<n;i++){
			r[i-mid]=arr[i];
		}
		l=mergeSort(l,l.length);
		r=mergeSort(r, r.length);
		
		arr=merge(l, r, arr);
		return arr;
	}
	
	int[] merge(int l[],int r[],int arr[]){
		int lLen=l.length;
		int rLen=r.length;
		int i=0,j=0,k=0;
		while(i<lLen&&j<rLen){
			if(l[i]<=r[j]){
				arr[k]=l[i];
				i++;
				k++;
			}else if(l[i]>r[j]){
				arr[k]=r[j];
				j++;
				k++;
			}
		}
		while(i<lLen){
			arr[k]=l[i];
			i++;
			k++;
		}
		while(j<rLen){
			arr[k]=r[j];
			j++;
			k++;
		}
		
		return arr;
	}
	
	void display(){
		System.out.println("Sorted list:");
		for(int i=0;i<arr.length;i++){
			System.out.print(" "+arr[i]);
		}
	}

}
