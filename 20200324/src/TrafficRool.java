/**
 * @Description:  抽象类
 * @Author HuangZhuoLin
 * @Date 2020/3/24 16:52
 */

 abstract class TrafficRool {

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    private String carNum;

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    private String carBrand;

    public TrafficRool(String  carNum,String carBrand){
       this.carNum = carNum;
       this.carBrand = carBrand;
    }

 public abstract void run();

}

class Plane extends TrafficRool{
    public Plane(String carNum,String carBrand ){
        super(carNum,carBrand);
    }
    public void run(){
        System.out.print("飞");
    }
}
class Ship extends TrafficRool{
    public Ship(String carNum,String carBrand){
        super(carNum, carBrand);
    }

    public void run(){
        System.out.print(" ");
    }
}
class TestDemo{
    public static void main(String[] args) {
        TrafficRool trafficRool = new Plane("123","波音777") ;
        trafficRool.run();
    }
}