/**
 * @Description: 数组的拷贝
 * @Author HuangZhuoLin
 * @Date 2020/3/15 10:33
 */


/**
 * 第四种copy，利用clone()
 */
import java.util.Arrays;
import java.util.Scanner;
public class Arrays15 {
    public static void main(String[] args) {
        int[] arrays1 = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入十个数字：");
        for (int i = 0; i < arrays1.length; i++) {
            arrays1[i] = sc.nextInt();
        }
        System.out.println("拷贝后：");
        copyArray(arrays1);
    }
    public static void copyArray(int[]a){
        int[] ret =a.clone();
        for (int x:ret) {
            System.out.print(" "+x+" ");
        }
    }
}





/*

*/
/**
 * 第三种copy，利用Array.copyOf()
 *//*

import java.util.Arrays;
import java.util.Scanner;
public class Arrays15 {
    public static void main(String[] args) {
        int[] arrays1 = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入十个数字：");
        for (int i = 0; i < arrays1.length; i++) {
            arrays1[i] = sc.nextInt();
        }
        System.out.println("拷贝后：");
        copyArray(arrays1);
    }
    public static void copyArray(int[]a){
        int[] ret =Arrays.copyOf( a , a.length);
            for (int x:ret) {
                System.out.print(" "+x+" ");
            }
        }
    }
*/


/**
 * 第二种copy，利用System.arraycopy()
 *//*
import java.util.Scanner;
public class Arrays {
    public static void main(String[] args) {
        int[] arrays1 = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入十个数字：");
        for(int i = 0; i<arrays1.length; i++){
            arrays1[i] = sc.nextInt();
        }
        int[] ret = copyArray(arrays1);
        System.out.println("拷贝后：");
        for (int x:ret) {
            System.out.print(" "+x+" ");
        }
    }
    public static int[] copyArray(int[]a){
        int[] ret = new int[a.length];
        System.arraycopy( a,0,ret,0,ret.length);
        return ret;
    }
}*/


/**
 * 第一种copy，利用for循环
 *//*

import java.util.Scanner;
public class Arrays {
    public static void main(String[] args) {
        int[] arrays1 = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入十个数字：");
        for(int i = 0; i<arrays1.length; i++){
            arrays1[i] = sc.nextInt();
        }
        int[] ret = copyArray(arrays1);
        System.out.println("拷贝后：");
        for (int x:ret) {
            System.out.print(" "+x+" ");
        }
    }
    public static int[] copyArray(int[]a){
        int[] ret = new int[a.length];
        for(int i = 0; i<ret.length; i++){
            ret[i]=a[i];
        }
        return ret;
    }
}
*/
