public class PCB {
    public String name; //进程名称
    public int workTime; //运行时间
    public int pri; //优先级
    public String state = "就绪"; //状态 R就绪 F完成

    public PCB(String name, int workTime, int pri) {
        this.name = name;
        this.workTime = workTime;
        this.pri = pri;
    }
}
