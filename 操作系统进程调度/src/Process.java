import java.util.*;

public class Process extends Thread {
    public static void main(String[] args) {
        Process process = new Process();
        process.run();
    }
    private int num; //要运行的进程个数
    public List<PCB> use = new ArrayList<>();//就绪的进程
    private List<PCB> run = new ArrayList<>();//正在运行的进程
    private List<PCB> finish = new ArrayList<>();//已经完成的进程
    private int count; //记录时间片
    private String sign;//标志第一次的运行

    private void work(){
        System.out.println("******************************************");
        System.out.println("*************   优先级调度   ************");
        //输入需要工作的进程
        System.out.println("请输入进程个数(至少有有1个进程)");
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        for (int i = 1; i <= num; i++) {
            System.out.println("请输入第" + i + "个进程名");
            Scanner scan1 = new Scanner(System.in);
            String name = scan1.next();
            System.out.println("请输入第" + i + "个进程优先数");
            Scanner scan2 = new Scanner(System.in);
            int pri = scan2.nextInt();
            System.out.println("请输入第" + i + "个进程所需服务时间");
            Scanner scan3 = new Scanner(System.in);
            int workTime = scan3.nextInt();

            use.add(new PCB(name,workTime ,pri ));
            System.out.println("");
        }
            sign = "第一个进程";
             this.run();
    }
    public void run(){
        boolean flag = true;
        if("第一次".equals(sign)){
            count = 0;//时间片为0
            Collections.sort(use,new PCBComparator());//第一次进程进入，时间片计数为0，然后对顺序表根据优先级进行排序
            count++;//第一个时间片开始
            while (flag){
                if(run == null){//run中为空意味着此时没有进程运行
                    System.out.println("还没有进程被调度");
                    run.add(use.get(0));//将use里面的第一个，也就是优先级最高的放入
                }
                use.get(0).pri -= 1; //使加入到run中的进程优先级减1
                use.get(0).workTime -= 1; // 使加入到run中的进程运行时间减1
                use.get(0).state = "运行中";// 使加入到run中的进程状态改为run
                //每个进程循环进行判断，如果运行时间为0后更改运行状态为finish
                for (int i = 0; i < use.size(); ++i) {
                    if (use.get(i).workTime == 0) {
                        use.get(i).state = "运行结束";
                    }
                }
                System.out.println("经过了" + (count) + "个时间片后，" + use.get(0).name + "被调用." + "还需" + use.get(0).workTime + "时间");
                System.out.println("经过时间片数" + "      " + "进程ID" + "     " + "该进程优先数" + "    " + "所需时间片数" + "     调度状态");
                //打印未完成进程,use中就是还没有被运行的进程
                for (int j = 0; j < use.size(); j++)
                    System.out.println(count + "                  " + use.get(j).name + "        " + use.get(j).pri
                            + "              " + use.get(j).workTime + "             " + use.get(j).state);


                //如果进程已经结束，则加入到finish，
                for(int i = 0; i < use.size(); i++){
                    if(use.get(i).workTime == 0){
                        use.get(i).state = "运行结束";
                        finish.add(use.get(i));
                        use.remove(i);
                    }
                }
                //如果finish中放的进程等于一开始的进程数，说明进程全部执行完毕
                if(finish.size() == num){
                    flag = false;
                    System.out.println("进程全部执行完毕！");
                }
                try{
                    sleep(1000);//间隔1000毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //打印已经完成的进程，finish中就是已经完成的进程
                for (int j = 0; j < finish.size(); j++)
                    System.out
                            .println(count + "                  " + finish.get(j).name + "        " + finish.get(j).pri
                                    + "              " + finish.get(j).workTime + "               " + finish.get(j).state);
                Collections.sort(use,new PCBComparator());
                count++;

            }

        }


    }

}
//利用比较器对use根据优先级pri进行从大到小排序
class PCBComparator implements Comparator<PCB> {
    @Override
    public int compare(PCB o1, PCB o2) {
        int pri1 = o1.pri;
        int pri2 = o2.pri;
        return pri2 - pri1;
    }
}


