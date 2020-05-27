public class Banker {
    public Resource[] Work;// 当前系统可以给的进程的各类资源
    public PCB[] pcb; // 所有的进程

    public Banker(Resource[] Available, PCB[] pcb) {
        Work = Available;//在进程开始的时候work和available是相等的
        this.pcb = pcb;
        //系统剩余可用资源
        actualWork();
    }
    public void makeReq(PCB pcb) {
            for (int i = 0; i < Work.length ; i++) {
                //初始系统总资源减去申请就是当前可利用的资源
                if(!isFinish() && !isSafe()){
                    Work[i].num -=  pcb.Request[i].num;
                    pcb.Allocation[i].num += pcb.Request[i].num;
                    pcb.Need[i].num -= pcb.Request[i].num;
                }

            }
        }
    public void actualWork() {
        for (int i = 0; i < Work.length ; i++) {
            //初始系统总资源减去已分配资源就是当前可利用的资源
            Work[i].num -=  pcbUsed(i);

        }
    }
    public int pcbUsed(int index){
        int sum = 0;
        for (PCB p: pcb
             ) {
            sum += p.Allocation[index].num;
        }
        return sum;

    }
    public boolean isRequest(){
        for (PCB p: pcb) {
            for (int i = 0; i <p.Allocation.length; i++) {
                if(p.Request[i].num <= p.Need[i].num){
                    if(p.Request[i].num <= Work[i].num){
                        return true;
                    }

                }

            }
        }
        return false;
    }

    public void Run(){
                    if(!isRequest()){
                        for (PCB p:pcb
                             ) {
                            makeReq(p);
                        }
                    }
        runPcb();
    }

    public void runPcb(){//进程运行

        for (int i = 0; !isFinish() && !isSafe(); i++) {//只要进程没有完成或者不安全都要继续循环，直到安全或者完成
            if(i == pcb.length){
                i = 0;
            }
            if(pcb[i].Finish){
                continue;
            }
            //判断是否需要等待
            if(!isWait(pcb[i])){
                //不需要等待则进行资源给予
                makeRecourse(pcb[i]);
                System.out.println(pcb[i]);
                System.out.println();
                displayWorks();
            }
        }
        System.out.println();
        if(isSafe()){
            System.out.println("系统安全");
        }else {
            System.out.println("系统不安全");
        }
    }
    //资源给予
    public void makeRecourse(PCB pcb){
        //运行到这说明该进程可以得到足够的资源,那么直接将该进程已分配的资源放回到系统中
        //并将finish改为true
        for (int i = 0; i < this.Work.length; i++) {
            this.Work[i].num += pcb.Allocation[i].num;
            pcb.Finish = true;
        }
    }
    //判断是否为安全状态
    public boolean isSafe() {
        for (PCB p : pcb) {
            if (! p.Finish) {
                return false;
            }
        }
        return true;
    }
    private void displayWorks() {
        System.out.println("此时系统可用资源为:");
        System.out.println("====================");
        for (Resource r : this.Work) {
            System.out.println(r);
        }
        System.out.println("====================");
    }
    //判断是否需要等待
    public boolean isWait(PCB pcb){
        for (int i = 0; i < Work.length ; i++) {
            if(Work[i].num < pcb.Need[i].num){
                return true;//系统可提供的资源有一个种类如果小于进程中对应类所需要的数量需要等待
            }
        }
        return false;//不需要等待
    }
    //判断进程是否已经完成
    public boolean isFinish(){
        for (PCB p: pcb
             ) {
            if(!p.Finish){//如果进程没有完成
                if(isWait(p)){//如果进程需要等待
                    return false;//说明进程没有完成
                }
            }
        }
        return true;//进程已经完成
    }


}
