/**
 * @Author HuangZhuoLin
 * @Date 2020/3/15 0:31
 */

public class Car {
    public static void main(String[] args) {
        System.out.println("关于汽车的属性如下：");
        Car.AllCar();
    }
    private String carcolor;
    private String carbrand;
    private String cardriver;
    private double carprice;
    private double carlength;

    public Car(String carcolor, String carbrand, String cardriver, double carprice, double carlength){
      this.carcolor = carcolor;
      this.carbrand = carbrand;
      this.cardriver = cardriver;
      this.carprice = carprice;
      this.carlength = carlength;
    }
    public String getCarColor(){
        return carcolor;
    }
    public  void setCarColor(String carcolor){
        this.carcolor = carcolor;
    }
    public String getCarBrand(){
        return carbrand;
    }
    public  void setCarBrand(String carbrand){
        this.carbrand = carbrand;
    }
    public String getCarDriver(){
        return cardriver;
    }
    public  void setCarDriver(String cardriver){
        this.cardriver = cardriver;
    }
    public double getCarPrice(){
        return carprice;
    }
    public  void setCarPrice(double carprice){
        this.carprice = carprice;
    }
    public double getCarLength(){
        return carlength;
    }public  void setCarLength(double carlength){
        this.carlength = carlength;
    }
    public static void CarDriver(){
        System.out.println("这车没有司机!");
    }
    public static void CarBrand(){
        System.out.println("这车是奔驰!");
    }
    public static void CarPrice(){
        System.out.println("这车太贵!");
    }
    public static void CarColor(){
        System.out.println("这车是黑色的!");
    }
    public static void CarLengch(){
        System.out.println("这车长两米五!");
    }
    public static void AllCar(){
        Car car=new Car("黑色","奔驰","马云",1252312315.251,155.536);
        System.out.println("汽车颜色: "+car.carcolor);
        System.out.println("汽车品牌: "+car.carbrand);
        System.out.println("汽车司机: "+car.cardriver);
        System.out.println("汽车价格: "+car.carprice);
        System.out.println("汽车长度: "+car.carlength);
    }
}


