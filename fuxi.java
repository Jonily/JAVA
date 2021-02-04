public void sort(int[] array){
	for(int bound = 1;bound<array.length;bound++){
		int tmp = array[bound];
		int cur = bound-1;
		for(;cur>=0;cur--){
			if(array[cur]>tmp){
				array[cur+1] = array[cur];
			}else{
				break;
			}
		}
		array[cur+1]=tmp;
	}
}
public void sort(int[] array){
	for(int bound =1;bound < array.length;bound++ ){
		int v = array[bound];
		int left = 0;
		int right = bound;

		while(left<right){
			int mid = (left+right)/2;
			if(array[mid]<=v){
				left=mid+1
			}else{
				right=mid;

			}
		}
		for(int i = bound;i>left;i--){
			array[i+1] = array[i];
		}
		array[left] = v;

	}
}


//希尔排序
public void sort(int[] array){
	int gap = array.length;
	while(gap>1){
		insertSort(array,gap);
		gap = gap/2;
	}
	insertSort(array,1);

	
}
public void insertSort(int[] array,int gap){
	for(int bound = gap;bound<array.length;bound++){
		int tmp  = array[bound];
		int cur = bound-gap;
		for(;cur>=0;cur-=gap){
			if(array[cur]>tmp){
				array[cur+gap] = array[cur];
			}else{
				break;
			}
		}
		array[cur+gap] = tmp;

	}
}
//直接选择排序
public void Sort(int[] array){
	for(int bound = 0;bound<array.length;bound++){
		for(int cur = bound+1;cur<array.length;cur++){
			if(array[bound]<array[cur]){
				swap(array,bound,cur);
			}

		}
	}
}
public void heapSort(int[] array){
	createHeap(array);
	int heapSize =  array.length;
	for(int i = 0; i<heapSize;i++){
		swap(array,0,heapSize-1);
		heapSize--;
		shiftDowen(array,heapSize,0);
	}

}
public void createHeap(int[] array){
	for(int i = (array.length-1-1)/2;i>=0;i--){
		shifDown(array,array.length,i);
	}
}
public void shifDown(int[] array,int size,int index){
	int parent = index;
	int child = 2*parent-1;
	while(child < size){
		if(child + 1<size && array[child+1]>array[child]){
			child=child+1;
		}
		if(array[child] > array[parent]){
			swap(array,parent,child);
		}else{
			break;
		}
		parent = child;
		child = 2*parent +1;
	}

}