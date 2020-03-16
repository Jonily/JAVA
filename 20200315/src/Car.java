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
public  class carTeam {
    private Car carnum;
    private Car carlead;
    private Car cardriver;
    private Car carlength;
    private Car carcolor;
    private Car carprice;
    private Car carbrand;
    private Car carspeed;
    private Car cargoal;
    private Car carstart;

    //私有属性的set和get
    public void setCarnum(Car carnum) {
        this.carnum = carnum;
    }

    public Car getCarnum() {
        return carnum;
    }
    public void setCarlead(Car carlead) {
        this.carlead = carlead;
    }

    public Car getCarlead() {
        return carlead;
    }
    public void setCardriver(Car cardriver) {
        this.cardriver = cardriver;
    }

    public Car getCardriver() {
        return cardriver;
    }
    public void setCarlength(Car carlength) {
        this.carlength = carlength;
    }

    public Car getCarlength() {
        return carlength;
    }
    public void setCarcolor(Car carcolor) {
        this.carcolor = carcolor;
    }

    public Car getCarcolor() {
        return carlead;
    }
    public void setCarprice(Car carprice) {
        this.carprice = carprice;
    }

    public Car getCarprice() {
        return carprice;
    }
    public void setCarbrand(Car carbrand) {
        this.carbrand = carbrand;
    }

    public Car getCarbrand() {
        return carbrand;
    }
    public void setCarspeed(Car carspeed) {
        this.carspeed= carspeed;
    }

    public Car getspeed() {
        return carspeed;
    }
    public void setCargoal(Car cargoal) {
        this.cargoal= cargoal;
    }

    public Car getgoal() {
        return cargoal;
    }
    public void setCarstart(Car carstart) {
        this.carstart= carstart;
    }

    public Car getstart() {
        return carstart;
    }

    //构造方法
    public carTeam(Car carnum,Car carlead, Car cardriver,Car carlength,Car carcolor, Car carprice, Car carbrand, Car carspeed, Car cargoal, Car carstart) {
        setCarnum(carnum);
        setCarlead(carlead);
        setCardriver(cardriver);
        setCarlength(carlength);
        setCarcolor(carcolor);
        setCarprice(carprice);
        setCarbrand(carbrand);
        setCarspeed( carspeed);
        setCargoal(cargoal);
        setCarstart(carstart);

    }
}


