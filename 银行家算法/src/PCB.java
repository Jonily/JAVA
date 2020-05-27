public class PCB {//定义进程类
    public String name;//进程名字
    public Resource[] Max;//进程的最大需求量
    public Resource[] Allocation;// 表示每一个进程已经分配得到的资源
    public Resource[] Need;//用以表示每一个进程尚需的各类资源数
    public Resource[] Request; // 用来表示进程所申请的各类资源
    public boolean Finish = false;//表示进程是否完成

    @Override
    public String toString() {
        return this.name + (Finish ? "进程已经得到足够资源" : "需要等待");
    }

    public PCB(String name, Resource[] max, Resource[] allocation,Resource[] request) {
        this.name = name;
        Max = max;
        Allocation = allocation;
        Request = request;
        Need = new Resource[Max.length];
        for (int i = 0; i <Need.length ; i++) {//在need中放入最大需求量-已经分配了的资源量
            Need[i] = new Resource(Max[i].name,Max[i].num - Allocation[i].num);
        }

    }
}

