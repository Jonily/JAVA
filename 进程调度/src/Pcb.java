
import java.text.SimpleDateFormat;
import java.util.*;

class ProcessScheduling extends Thread {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ProcessScheduling p = new ProcessScheduling();
        p.select();
    }

    private int num;

    private ArrayList<Pcb> use = new ArrayList<Pcb>();
    private ArrayList<Pcb> finish = new ArrayList<Pcb>();
    private ArrayList<Pcb> run = new ArrayList<Pcb>();

    private int count;
    private String option=null;

    private void select() {
        // TODO Auto-generated method stub
        System.out.println("******************************************");
        System.out.println("*************   优先级调度   ************");
        // 优先数
        System.out.println("请输入进程个数");
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        for (int i = 1; i <= num; ++i) {
            System.out.println("请输入第" + i + "个进程名");
            Scanner sanid = new Scanner(System.in);
            int id = sanid.nextInt();
            System.out.println("请输入第" + i + "个进程优先数");
            Scanner sancount = new Scanner(System.in);
            int sanc = sancount.nextInt();
            System.out.println("请输入第" + i + "个进程所需服务时间");
            Scanner sanneed = new Scanner(System.in);
            int saneed = sanneed.nextInt();

            use.add(new Pcb(id, sanc, saneed));
            System.out.println("");
        }
        option="youxianshu";
        this.run();

    }
     class PCBComparator implements Comparator<Pcb> {
         @Override
         public int compare(Pcb o1, Pcb o2) {
             int pri1 = o1.youxianshu;
             int pri2 = o2.youxianshu;
             return pri2 - pri1;
         }
     }

    @Override
    public void run() {
        boolean flag = true;
        if(option=="youxianshu"){
            count = 0;
            Collections.sort(use,new PCBComparator());
            count++;
            while (flag) {
                if (run == null) {
                    run.add(use.get(0));
                    System.out.println("还没有进程被调度");
                }
                use.get(0).youxianshu -= 1;
                use.get(0).needtime -= 1;
                use.get(0).state = "run";
                for (int i = 0; i < use.size(); ++i) {
                    if (use.get(i).needtime == 0) {
                        use.get(i).state = "finish";
                    }
                }
                System.out.println("经过了" + (count) + "个时间片后，" + use.get(0).id + "被调用." + "还需" + use.get(0).needtime + "时间");
                System.out.println("经过时间片数" + "      " + "进程ID" + "     " + "该进程优先数" + "    " + "所需时间片数" + "     调度状态");
//打印未完成进程
                for (int j = 0; j < use.size(); j++)
                    System.out.println(count + "                  " + use.get(j).id + "        " + use.get(j).youxianshu
                            + "              " + use.get(j).needtime + "             " + use.get(j).state);
//打印完成进程
                for (int j = 0; j < finish.size(); j++)
                    System.out
                            .println(count + "                  " + finish.get(j).id + "        " + finish.get(j).youxianshu
                                    + "              " + finish.get(j).needtime + "               " + finish.get(j).state);
                Collections.sort(use,new PCBComparator());
                count++;

                // 如果进程结束，就加入finish，从run中走
                for (int i = 0; i < use.size(); ++i) {
                    if (use.get(i).needtime == 0) {
                        use.get(i).state = "finish";
                        finish.add(use.get(i));
                        use.remove(i);
                    }
                }
                if (finish.size() == num) {
                    flag = false;
                    System.out.println("进程全部执行");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }}
}
public class Pcb {
    public int id;
    public String state="stop";//状态  F完成 W等待  R运行
    public int youxianshu;//优先数
    public int needtime;//作业长短
    public  Pcb(int id,int youxinashu,int needtime){
        this.id=id;
        this.youxianshu=youxinashu;
        this.needtime=needtime;
    }


}
