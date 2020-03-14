import java.util.Scanner;
public class arrays1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("要输入的数字个数为：");
        int n = sc.nextInt();
        System.out.println("请输入数字：");
        int[] arrays = new int[999];
        int i = 0;
        for (i = 0; i < n; i++) {
            arrays[i] = sc.nextInt();
        }
        double j = sum(n,arrays);
        System.out.println("输入数字的平均值为："+j);
    }
    public static double sum(int n,int[] arrays){
        int i = 0;
        int ret = 0;
        int j = 0;
        for (i = 0; i< n; i++) {
        ret = ret + arrays[i];
        }
        System.out.println("输入数字求和为："+ret);
        j = ret/n;
        return j ;
 }
}

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字：");
        int []arrays = new int [999];
        int i = 0 ;
        for(i = 0 ; i < arrays.length ; i++){
            arrays[i] = sc .nextInt();
        }
        transform(arrays);
    }
    public static void transform(int []arrays){
        System.out.println("原数组：");
        for (int x:arrays) {
            System.out.print(" "+x+" ");
        }
        System.out.println();
        System.out.println("计算后：");
        for (int i = 0; i<arrays.length ; i++) {
            arrays[i]=arrays[i]*2;
        }
        System.out.println(Arrays.toString(arrays));
    }
}


*/




    /*
    public static void main(String[] args) {
        int [] arrays = {12, 15, 36, 5};
        printArray(arrays);
    }
    public static void printArray(int [] a) {
        for (int x:a ) {
            System.out.println(x);
        }
    }
}*/


    /*
    public static void main(String[] args) {
        int [] arrays = new int [100];
        int i = 0 ;
        for(i = 0 ; i<= 99 ; i++){
            arrays [i] = i+1 ;
        }
        System.out.println(Arrays.toString(arrays));
    }
}*/

