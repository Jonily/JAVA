package 快排找第k大;


public class Finder {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2, 2};
        int i = findKth(a, 5, 3);
        System.out.println(i);
    }
        public static int findKth(int[] a, int n, int K) {
            // write code here
            int i = 0;
            i = n-K;
            quickSort(a);
            int b = 0;
            b = a[i];
            return b;

        }

        public static void quickSort(int[] a){
            quickHelper(a,0,a.length - 1);
        }
        public static void quickHelper(int[] a, int left, int right) {
            if(left >= right){
                return;
            }
            int index = patition(a, left , right);
            quickHelper(a, left , index - 1);
            quickHelper(a, index + 1,right);
        }
        public static int patition(int[] a, int left, int right){
            int base = a[right];
            int i = left;
            int j = right;
            while(i < j ){
                while(i < j && a[i] <= base){
                    i++;
                }
                while (i < j && a[j] >= base){
                    j--;
                }
                if(i < j){
                    swap(a,i,j);
                }
            }
            swap(a,i,right);
            return i;
        }
        public static void swap(int[] a, int i, int j){
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
