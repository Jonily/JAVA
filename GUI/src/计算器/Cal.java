package 计算器;
import java.awt.*;
import javax.swing.*;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/28 16:37
 */

public class Cal extends JFrame {
   //计算器上的控件
    JTextField showText;//显示文本框
    JButton zeroBt;//按钮0
    JButton equalsBt;//等号按钮
    JPanel leftPanel;//左边面板
    JButton[] leftBts;//左边面板上的按钮数组（10个按钮对象）
    JPanel centerPanel;//中间面板
    JButton[] centerBts;//中间面板上的按钮数组（12个按钮对象）
    JPanel rightPanel;//右边面板
    JButton[] rightBts;//右边面板上的按钮数组（4个按钮对象）

    public Cal(){
        this.setSize(400,500);
        this.setTitle("计算器");
        this.setLayout(null);
        init();
        this.setVisible(true);
    }

    //初始化窗口中所包含的二级容器及控件的方法
    public void init(){
        //三个单独控件的创建及摆放
        showText = new JTextField();
        showText.setSize(360,50);
        showText.setLocation(10,10);
        this.add(showText);

        zeroBt = new JButton("0");
        zeroBt.setSize(140,52);
        zeroBt.setLocation(10,356);
        this.add(zeroBt);

        equalsBt = new JButton("=");
        equalsBt.setSize(70,108);
        equalsBt.setLocation(300,299);
        this.add(equalsBt);


        //左边面板的摆放和面板上控件的摆放
        initLeftPanel();


        //中间面板的摆放和面板上控件的摆放
        initCenterPanel();


        //右边面板的摆放和面板上控件的摆放
        initRightPanel();
    }



    //左边面板初始化
    private void initLeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setSize(140,280);
        leftPanel.setLocation(10,70);
       // leftPanel.setBackground(Color.);
        //在左边面板中摆放10个按钮
        //设置左边面板的布局方式为5行2列网格布局
        leftPanel.setLayout(new GridLayout(5,2,5,5));
        String[] leftBtNames = {"MC","MR","<-","CE","7","8","4","5","1","2"};
        leftBts = new JButton[10];
        for(int i = 0;i < leftBts.length; i++){
            leftBts[i] = new JButton(leftBtNames[i]);
            leftPanel.add(leftBts[i]);
        }
        this.add(leftPanel);
    }

    //中间面板初始化
    private void initCenterPanel() {
        centerPanel = new JPanel();
        centerPanel.setSize(140,340);
        centerPanel.setLocation(155,70);
        //centerPanel.setBackground(Color.darkGray);
        //在左边面板中摆放10个按钮
        //设置左边面板的布局方式为5行2列网格布局
        centerPanel.setLayout(new GridLayout(6,2,5,5));
        String[] centerBtNames = {"MS","M+","C","+-","9","/","6","*","3","-","*","+"};
        centerBts = new JButton[12];
        for(int i = 0;i < centerBts.length; i++){
            centerBts[i] = new JButton(centerBtNames[i]);
            centerPanel.add(centerBts[i]);
        }
        this.add(centerPanel);
    }

    //右边面板初始化
    private void initRightPanel() {
        rightPanel = new JPanel();
        rightPanel.setSize(70,225);
        rightPanel.setLocation(300,70);
        //rightPanel.setBackground(Color.darkGray);
        //在左边面板中摆放10个按钮
        //设置左边面板的布局方式为5行2列网格布局
        rightPanel.setLayout(new GridLayout(4,1,5,5));
        String[] rightBtNames = {"M-","√","%","1/X"};
        rightBts = new JButton[4];
        for(int i = 0;i < rightBts.length; i++){
            rightBts[i] = new JButton(rightBtNames[i]);
            rightPanel.add(rightBts[i]);
        }
        this.add(rightPanel);
    }

    public static void main(String[] args) {
        Cal cal = new Cal();
    }

}
