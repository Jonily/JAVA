package 银行家;

public class Resources {//系统资源类
    public String name;//资源名字用来区分类型
    public int num;//表示资源的数量

    public Resources(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "资源"+ name  + "有" + num;
    }
}
