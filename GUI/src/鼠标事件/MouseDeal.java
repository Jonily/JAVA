package 鼠标事件;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/30 12:25
 */

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
public class MouseDeal extends MouseAdapter
{
    private MouseEventTest test;
    public MouseDeal(MouseEventTest test)
    {
        this.test=test;
    }

    public void mouseClicked(MouseEvent e)
    {
        test.getContentPane().setBackground(Color.red);
    }

    public static void main(String[] args) {
        MouseEventTest test=new MouseEventTest();
    }
}
