public class mySort{
	
	//直接插入排序
	public void insertSort(int[] array){
		for(int bound = 1;bound < array.length; bound++){
			int tmp = array[bound];
			int cur = bound - 1;

			for(;cur >= 0; cur--){
				if(array[cur] > tmp){
					array[cur +1] = array[cur];
				}else{
					break;
				}
			}
			array[cur+1] = tmp;
		}
	}

	//折半插入排序
	public void midInsertSort(int[] array){
		for(int i = 1; i< array.length;i++){
			int val = array[i];
			int left = 0;
			int right = i;

			while(left < right){
				int mid = (left + right)/2;
				if(val >= array[mid] ){
					left = mid +1;

				}else{
					right = mid
				}
			}

			for(int j = i; j > left; j-- ){
				array[j] = array[j-1];

			}
			array[left] = val;


		}
	}
}


public void insertSort(int[] array){
	for(int bound = 1; bound < array.length; bound++){
		int  tmp = array[bound];
		int cur = bound - 1;
		for(;cur >= 0;cur--){
			if(array[cur] > tmp){
				array[cur+1] = array[cur];
			}else{
				break;
			}
		}

		array[cur+ 1] = tmp;
	}
}

public void midInsertSort(int[] array){
	for(int i = 1; i<array.length; i++){
		int val = array[i];
		int left = 0;
		int right = i;

		while(left < right){
			int mid = (left + right)/2;
			if(array[mid] <= val){
				left = mid+1;
			}else{
				right = mid;
			}
		}

		for(int j = i; j>left;j--){
			array[j] = array[j-1];
		}

		array[left] = val;
	}
}

public void shellSort(int[] array){
	int gap = array.lengt/2;
	while(gap > 1){
		shellInsertSort(array,gap);
		gap = gap/2;
	}
		shellInsertSort(array,1);

}

public void shellInsertSort(int[] array,int gap){
	for(int bound = gap; bound < array.length; bound++){
		int tmp  = array[bound];
		int cur = bound - gap;

		for(;cur >= 0;cur-=gap){
			if(array[cur] > tmp){
				array[cur + gap] = array[cur];
			}else{
				break;
			}
		}
		array[cur + gap] = tmp;
	}
}