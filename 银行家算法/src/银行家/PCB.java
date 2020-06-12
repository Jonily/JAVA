package 银行家;

public class PCB {//定义进程类
    public String name;//进程名字
    public Resources[] max;//进程的最大需求资源Max
    public Resources[] allocation;//表示每一个进程已经分配得到的资源
    public Resources[] need;//用以表示每一个进程尚需的各类资源数
    public boolean finish = false;//表示进程是否完成

    public PCB(String name, Resources[] max, Resources[] allocation) {
        this.name = name;
        this.max = max;
        this.allocation = allocation;
        this.need = new Resources[max.length];
        for (int i = 0; i < need.length; i++) {//在need中放入最大需求量-已经分配了的资源量
            this.need[i] = new Resources(max[i].name, max[i].num - allocation[i].num);
        }
    }

    @Override
    public String toString() {
        return this.name +(this.finish ? "进程已得到足够资源" : "需要等待");
    }
}
