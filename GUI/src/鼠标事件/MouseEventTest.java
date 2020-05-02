package 鼠标事件;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/30 11:24
 */

public class MouseEventTest extends JFrame implements MouseListener {
    private JButton bt;

    public MouseEventTest(){
        this.setSize(300,300);
        this.setTitle("鼠标事件实例");
        this.setLayout(null);
        bt = new JButton("测试按钮");
        bt.setSize(100,30);
        bt.setLocation(30,30);
        this.add(bt);
        bt.addMouseListener(this);
        this.setVisible(true);
    }
    //鼠标进入
    @Override
    public void mouseEntered(MouseEvent e) {
        bt.setText("进入按钮");

    }
//鼠标退出
    @Override
    public void mouseExited(MouseEvent e) {
        bt.setText("离开按钮");

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.print("鼠标点击");


    }
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.print("鼠标按下");
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.print("鼠标释放");

    }

    public static void main(String[] args) {
        MouseEventTest mouseEventTest = new MouseEventTest();
    }

}
