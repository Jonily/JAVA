package 选项事件;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


//选项事件
public class ItemEventTest extends JFrame implements ItemListener {
    JComboBox colorBox;//选择颜色的下拉框


    public ItemEventTest() {
        this.setSize(300, 300);
        this.setTitle("选项事件实例");
        this.setLayout(null);
        colorBox=new JComboBox();
        colorBox.setSize(70, 30);
        colorBox.setLocation(60, 60);
        colorBox.addItem("红色");
        colorBox.addItem("绿色");
        colorBox.addItem("蓝色");
        colorBox.addItemListener(this);
        //将下拉框和选项事件处理对象注册
        this.add(colorBox);
        this.setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) {
        JComboBox com=(JComboBox)e.getSource();
        //将事件源强制转换为下拉框对象
        if(com.getSelectedItem().toString().equals("红色"))
        {
            this.getContentPane().setBackground(Color.red);
        }
        else
        {
            if(com.getSelectedItem().toString().equals("绿色"))
            {
                this.getContentPane().setBackground(Color.green);
            }
            else
            {
                this.getContentPane().setBackground(Color.blue);
            }
        }
        System.out.println("选项改变");
    }

    public static void main(String[] args) {
        ItemEventTest itemEventTest = new ItemEventTest();
    }
}
