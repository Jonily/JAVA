package 银行家;

public class Banker {
    private Resources[] work;// 当前系统可以给的进程的各类资源
    private PCB[] pcbs;//所有进程

    public Banker(Resources[] Available, PCB[] pcbs) {
        this.work = Available;//在进程开始的时候work和available是相等的
        this.pcbs = pcbs;
        //系统剩余可用资源
        actualWork();
    }

    private void actualWork() {
        for (int i = 0; i < this.work.length; i++) {
            //初始系统总资源减去已分配资源就是当前可利用的资源
            this.work[i].num = this.work[i].num - pcbsAllRes(i);
        }
    }
    //计算所有进程已分配的第i个资源总数
    private int pcbsAllRes(int index) {
        int sum = 0;
        for ( PCB p : pcbs
        ) {
            sum += p.allocation[index].num;
        }
        return sum;
    }

    //判断是否为安全状态
    private boolean ifSafe() {
        for (PCB p : pcbs
        ) {
            if (! p.finish) {
                return false;
            }
        }
        return true;
    }

    //进行资源分配
    public void runPcb() {//进程运行
        //对进程进行循环资源分配,当所有进程都需要等待或者所有进程都为安全状态退出循环
        for (int i = 0; !ifSafe() && !isFinish(); i++) {
            //实现循环
            if (i == this.pcbs.length) {
                i = 0;
            }
            //判断当前这个进程是否已经获得过足够资源
            if (pcbs[i].finish) {
                continue;
            }
            //判断当前这个进程是否需要等待
            if (! needWait(pcbs[i])) {
                //进行资源分配
                mainOperation(pcbs[i]);
                System.out.println(pcbs[i]);
                System.out.println();
                displayWorks();
            }
        }
        System.out.println();
        if (ifSafe()) {
            System.out.println("系统处于安全状态");
        } else {
            System.out.println("系统处于不安全状态");
        }
    }

    private void displayWorks() {
        System.out.println("此时系统可用资源为:");
        System.out.println("====================");
        for (Resources r : this.work
        ) {
            System.out.println(r);
        }
        System.out.println("====================");
    }
    //判断进程是否已经完成
    private boolean isFinish() {
        for (PCB p : this.pcbs
        ) {
            //如果该进程已经得到过足够资源就不进行判断
            if (!p.finish) {//如果进程没有完成
                //如果该进程不需要等待就直接返回false
                if (!needWait(p)) {
                    return false;//说明进程没有完成
                }
            }
        }
        return true;
    }
    //资源给予
    private void mainOperation(PCB pcb) {
        //运行到这说明该进程可以得到足够的资源,那么直接将该进程已分配的资源放回到系统中
        //并将finish改为true
        for (int i = 0; i < this.work.length; i++) {
            this.work[i].num += pcb.allocation[i].num;
            pcb.finish = true;
        }
    }

    private boolean needWait(PCB pcb) {
        //挨个判断此时pcb这个进程所需要的每个资源,如果need大于系统当前可分配资源,就说明需要等待
        for (int i = 0; i < this.work.length; i++) {
            if (this.work[i].num < pcb.need[i].num) {
                return true;//系统可提供的资源有一个种类如果小于进程中对应类所需要的数量需要等待
            }
        }
        return false;//不需要等待
    }
}
