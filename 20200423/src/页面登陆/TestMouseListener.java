package 页面登陆;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/23 12:40
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MousePanel extends JPanel{
    int x_pos,y_pos;
    MousePanel(){
        //注册鼠标事件监听器，并用匿名类来实现事件处理程序
        //注意，必须实现(覆盖)接口中的全部方法，哪怕实现代码一句也没有
        addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
            public void mousePressed(MouseEvent e){
                x_pos=e.getX();
                y_pos=e.getY();
                repaint();//本方法会自动触发paintComponent方法的运行
            }
        });

        //注册鼠标移动事件监听器，并用匿名类来实现事件处理程序
        addMouseMotionListener(new MouseMotionListener(){
            public void mouseDragged(MouseEvent e){}
            public void mouseMoved(MouseEvent e){
                x_pos=e.getX();
                y_pos=e.getY();
                repaint();//本方法会自动触发paintComponent方法的运行
            }
        });
    }
    //覆盖父类的paintComponent方法以绘制当前鼠标的坐标
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString( "当前位置：[" + x_pos + ", " + y_pos + "]",x_pos, y_pos);
    }
}


public class TestMouseListener extends JFrame{
    TestMouseListener(){
        super("鼠标位置");
        MousePanel mp=new MousePanel();
        setContentPane(mp);
    }

    public static void main(String args[ ]){
        // TODO Auto-generated method stub
        TestMouseListener f = new TestMouseListener();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 480);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
