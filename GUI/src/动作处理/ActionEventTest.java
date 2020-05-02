package 动作处理;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/30 10:27
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventTest extends JFrame implements ActionListener {
    private JButton redBt,greenBt,blueBt;
    private JTextField orangeTxt;

    public ActionEventTest(){
        this.setSize(320,300);
        this.setTitle("动作事件实例");
        this.setLayout(null);
        redBt = new JButton("红色");
        redBt.setSize(60,30);
        redBt.setLocation(30,30);
        this.add(redBt);
        greenBt = new JButton("绿色");
        greenBt.setSize(60,30);
        greenBt.setLocation(120,30);
        this.add(greenBt);
        blueBt = new JButton("蓝色");
        blueBt.setSize(60,30);
        blueBt.setLocation(210,30);
        this.add(blueBt);
        orangeTxt = new JTextField("橙色");
        orangeTxt.setSize(60,30);
        orangeTxt.setLocation(30,80);
        this.add(orangeTxt);
        //将动作事件的事件处理对象注册到事件源中
        redBt.addActionListener(this);
        greenBt.addActionListener(this);
        blueBt.addActionListener(this);
        orangeTxt.addActionListener(this);
        this.setVisible(true);
    }

    //该方法中具体实现当用户点击不同按钮后的具体工作
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().getClass().toString().contains("JButton")) {
            JButton bt = (JButton) e.getSource();//获取事件源并强制转换为按钮对象
            if (bt.getText().equals("红色")) {
                this.getContentPane().setBackground(Color.red);
            }else if (bt.getText().equals("绿色")) {
                    this.getContentPane().setBackground(Color.GREEN);
                } else if (bt.getText().equals("蓝色")) {
                    this.getContentPane().setBackground(Color.BLUE);
                }
        } else {
            this.getContentPane().setBackground(Color.ORANGE);
        }
    }

    public static void main(String[] args) {
        ActionEventTest actionEventTest = new ActionEventTest();

    }


}
