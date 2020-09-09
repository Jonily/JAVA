

//animal 名字分别为狗 2  》猫 3 》鸭 4 》 鸡 9
public class Animals {
    private String name;
    private Integer age;
    private Animals next;

    public Animals() {

    }
    public Animals(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Animals getNext() {
        return next;
    }

    public void setNext(Animals next) {
        this.next = next;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", next=" + next +
                '}';
    }
}
