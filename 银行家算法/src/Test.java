
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("输入资源有几种:");
        int resKindNum = scan.nextInt();
        Resource[] Available = new Resource[resKindNum];//系统总资源
        System.out.println();
        System.out.println("输入每个系统资源名称、系统资源数量");


        for (int i = 0; i < Available.length; i++) {
            System.out.println("初始化第" + (i +1) + "个资源");
            System.out.println();
            System.out.print("资源名称:");
            String name = scan.next();
            System.out.println();
            System.out.print("该资源数量:");
            int num = scan.nextInt();
            Available[i] = new Resource(name, num);
            System.out.println();
            System.out.println("第" + (i +1) + "个资源初始化完毕");
            System.out.println("====================");
        }


        System.out.println();
        System.out.println("系统资源初始化完毕,开始初始化进程");
        System.out.println();


        System.out.print("输入进程个数:");
        int pcbNums = scan.nextInt();
        PCB[] pcbs = new PCB[pcbNums];


        for (int i = 0; i < pcbNums; i++) {
            System.out.println("初始化第" + (i +1) + "个进程");
            System.out.println();
            System.out.print("输入进程名:");
            String name = scan.next();
            System.out.println();
            System.out.print("输入该进程最大需求资源:");
            Resource[] max = new Resource[resKindNum];
            int[] maxResNum = new int[resKindNum];
            for (int j = 0; j < resKindNum; j++) {
                maxResNum[j] = scan.nextInt();
            }


            for (int j = 0; j < max.length; j++) {

                max[j] = new Resource(Available[j].name, maxResNum[j]);
            }


            System.out.println();
            System.out.print("输入该进程已分配资源数目:");
            Resource[] allocation = new Resource[resKindNum];
            int[] allocReesNum = new int[resKindNum];
            for (int j = 0; j < resKindNum; j++) {
                allocReesNum[j] = scan.nextInt();
            }

            for (int j = 0; j < allocation.length; j++) {
                allocation[j] = new Resource(Available[j].name, allocReesNum[j]);
            }
            System.out.println();

            System.out.println();
            System.out.print("输入该进程申请资源数目:");
            Resource[] request = new Resource[resKindNum];
            int[] requestNum = new int[resKindNum];
            for (int j = 0; j < resKindNum; j++) {
                requestNum[j] = scan.nextInt();
            }

            for (int j = 0; j < allocation.length; j++) {
                request[j] = new Resource(Available[j].name, requestNum[j]);
            }
            System.out.println();


            //此时一个进程的所有需要的东西都已输入完毕

            pcbs[i] = new PCB(name, max, allocation,request);
            System.out.println("第" + (i +1) + "个进程初始化完毕");
            System.out.println("====================");
        }

        System.out.println();
        System.out.println("========所有进程初始化完毕,开始资源分配========");
        System.out.println();

         Banker banker = new Banker(Available, pcbs);
        banker.Run();
    }
}

