import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/9 9:20
 */

public class InterClass {
    public static  void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int count = sc.nextInt();
        Integer[] arrays = getFiveInTwentyTwo(max,count);
        for( int i =0;i<arrays.length;i++){
            System.out.print(arrays[i]+" ");
        }

    }
    public static Integer[] getFiveInTwentyTwo(int max,int count)
    {
        ArrayList<Integer> list=new ArrayList<Integer>();
        Random random=new Random();
        list.add(random.nextInt(max)+1);//产生的第一个数是不重复的，可以直接放到容器中
        while(list.size()<count)
        {
            int temp=random.nextInt(max)+1;//产生一个新的随机数
            if(!list.contains(temp))//判断容器中是否已经存在这个随机数
            {
                list.add(temp);
            }
        }
        return (Integer[])list.toArray(new Integer[list.size()]);
    }
}


       /* //定义一个数组接收所产生的随机数
        System.out.println("想要产生的随机数个数：");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] array = new int[a];
        Random random = new Random();
        System.out.println("想要产生的随机数范围：");
        int b = sc.nextInt();

        int cuont  = 0;//计数产生的随机数个数
        while (cuont<array.length){
            boolean flag = true;
            int r = random.nextInt(b)+1;
            for (int i = 0;i<array.length;i++){
                if(array[i] == r){
                    flag = false;
                    break;
                }
            }
            if(flag){
                array[cuont] = r;
                System.out.print(r+" ");
                cuont++;
            }
        }
        System.out.println();

        System.out.print(Arrays.toString(array));

    }*/

