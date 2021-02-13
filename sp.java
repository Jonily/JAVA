public class Sort{
	public static void 	Sort(int[] array){
		SortHelper(array,0,array.length());
	}

	public static void SortHelper(int[] array,int left,int right){
		if(left >= right){
			return;
		}

		int index = find(array,left,right);
		SortHelper(array,left,index-1);
		SortHelper(array,index+1,right);

	}

	public static int find(int[] array,int left,int right){
		int val = array[right];

		int low = left;
		int high = right;

		while(low < high){

			while(low < high && array[low] <= val){
				low++;
			}

			while(low < high && array[high] >= val){
				high--;
			}

			if(low < high){
				swap(array,low,high);
			}
		}

		swap(array,low,right);
		return low;
	}
}