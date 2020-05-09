package 选项事件;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ItemEventTest1 extends JFrame implements ItemListener {
    JComboBox coCom;//学院下拉框
    JComboBox prCom;//专业下拉框

    private String[] coNames={"电控学院","电智学院"};
    private String[] proNames1={"自动化","电气工程及其自动化","智能制造工程"};
    private String[] proNames2={"网络工程","计算机科学与技术","物联网工程","电子科学与技术","光电信息与工程","人工智能","电子信息工程"};

    public ItemEventTest1()
    {
        this.setSize(300,300);
        this.setTitle("下拉框二级联动实例");
        this.init();
        this.setVisible(true);
    }

    private void init()
    {
        this.setLayout(null);
        coCom=new JComboBox();
        for(int i=0;i<coNames.length;i++)
        {
            coCom.addItem(coNames[i]);
        }
        coCom.setSize(120, 30);
        coCom.setLocation(60,60);
        coCom.addItemListener(this);
        this.add(coCom);
        prCom=new JComboBox();
        prCom.setSize(120, 30);
        prCom.setLocation(60,120);
        for(int i=0;i<proNames1.length;i++)
        {
            prCom.addItem(proNames1[i]);
        }
        this.add(prCom);
    }


    public void itemStateChanged(ItemEvent e)
    {
        JComboBox com=(JComboBox)e.getSource();
        prCom.removeAllItems();
        //在添加新的选项之前清空所有的选项
        if(com.getSelectedItem().toString().equals("电控学院"))
        {
            for(int i=0;i<proNames1.length;i++)
            {
                prCom.addItem(proNames1[i]);
            }
        }
        else
        {
            for(int i=0;i<proNames2.length;i++)
            {
                prCom.addItem(proNames2[i]);
            }
        }
    }

    public static void main(String[] args) {
        ItemEventTest1 itemEventTest1 = new ItemEventTest1();
    }
}
