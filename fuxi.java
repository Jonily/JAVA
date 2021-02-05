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
public void heapHeap(int[] array){
	createHeap(array);
	int heapSize = array.length;
	for(int i = 0;i<array.length;i++){
		swap(array,heapSize-1,0);
		heapSize--;
		shiftDown(array,heapSize,0);
	}
}

public void crateHeap(int [] array){
	for(int i = (array.length-1-1)/2;i>=0;i--){
		shfitDown(array,array.length.i);
	}
}

public void shfitDown(int[] arrat,int size,int index){
	int parent = index;
	int child = 2*parent+1;
	while(child<size){
		if((child+1)<size && array[child+1]>array[child]){
			child = child+1;
		}
		if(array[child]>array[parent]){
			swap(array,parent,child);
		}else{
			break;
		}
		parent = child;
		child = 2*parent+1;
	}
}

//直接插入
public static void insertSort(int[] array){
	for(int bound = 1;bound < array.length;bound++){
		int cur = bound-1;
		int tmp = array[bound];
		for(;cur>=0;cur--){
			if(array[cur]>tmp){
				array[cur+1] = array[cur];
			}else{
				break;
			}
		}
		array[cur+1] = tmp;
	}
}

//折半插入
public static void midInsertSort(int[] array){
	for(int bound = 1;bound<array.length;bound++){
		int tmp = array[bound];
		int left = 0;
		int right = bound;
		while(left<right){
			int mid = (left+right)/2;
			if(array[mid] <= tmp){
				left=mid+1;
			}else{
				right = mid;
			}
		}
		for(int i =bound;i>left;i--){
			array[i+1] = array[i];
		}
		array[left] = tmp;
	}
}

//希尔排序
public static void shellSort(int[] array){
	int gap = array.length;
	while(gap>1){
		Sort(array,gap);
		gap/2;

	}
}
public static void Sort(int[] array,int gap){
	for(int bound = gap;bound<array.length;bound++){
		int cur = bound-1;
		int tmp = array[bound];
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

//选择排序
public static void Sort(int[] array){
	for(int bound = 0;bound<array.length;bound++){
		for(int cur=1;cur<array.length;cur++){
			if(array[cur]<array[bound]){
				swap(array,cur,bound);
			}
		}
	}
}
public static void HeapSort(int[] array){
	createHeap(array);
	int headSize = array.length;
	for(int i = 0;i<array.length;i++){
		swap(array,headSize-1,0);
		headSize--;
		shfitDown(array,headSize,0)
		
	}
	
}

public static void createHeap(int[] array){
	for(int i = (array.length-1-1)/2;i>=0;i--){
		shfitDown(array,array.length,i);
	}

}
public static void shfitDown(int[] array,int size,int index){
	int parent = index;
	int child = 2*parent+1;
	while(child<size){
		if(array[child+1]>array[child] &&(child+1)<size){
			child = child+1;
		}
		if(array(child)>array[parent]){
			swap(array,child,parent);
		}else{
			break;
		}
		parent = child;
		child = 2*parent+1;
	}
}
public static void bubbleSort(int[] array){
	for(int bound = 0;bound<array.length;bound++){
		for(int cur = array.length-1;cur>bound;cur--){
			if(array[cur]<array[cur-1]){
				swap(array,cur,cur-1);
			}
		}
	}
}