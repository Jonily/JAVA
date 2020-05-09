package 菜单;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuTest extends JFrame implements ActionListener {

    private JButton redBt, greenBt, blueBt;
    //定义有关菜单的对象
    JMenuBar menuBar;//菜单栏
    JMenu colorMenu;//设置窗体背景颜色的菜单
    JMenuItem[] colorMenuItems;//设置窗体背景颜色的菜单项数组


    //初始化按钮的方法
    private void initButton(){
        this.setLayout(null);
        redBt = new JButton("红色");
        redBt.setSize(60, 30);
        redBt.setLocation(30, 30);
        this.add(redBt);
        greenBt = new JButton("绿色");
        greenBt.setSize(60, 30);
        greenBt.setLocation(120, 30);
        this.add(greenBt);
        blueBt = new JButton("蓝色");
        blueBt.setSize(60, 30);
        blueBt.setLocation(210, 30);
        this.add(blueBt);

        redBt.addActionListener(this);
        greenBt.addActionListener(this);
        blueBt.addActionListener(this);
    }


    //初始化菜单的方法
    private void initMenu(){
        colorMenu = new JMenu("设置窗体背景");
        String[] colors = {"红色","绿色","蓝色"};
        colorMenuItems = new JMenuItem[3];
        //定义一个包含三个菜单项的数组
        for(int i = 0; i < 3; i++ ){
            colorMenuItems[i] = new JMenuItem(colors[i]);
            //初始化每个菜单项，给菜单项进行文本赋值
            colorMenuItems[i].addActionListener(this);
            //注册事件源菜单项和事件处理项
            colorMenu.add(colorMenuItems[i]);
            //以菜单为对象，调用方法添加菜单包含的菜单项
        }
        menuBar = new JMenuBar();//初始化菜单栏
        menuBar.add(colorMenu);//将菜单添加到菜单栏上
        this.setJMenuBar((menuBar));
        //以窗口为对象，调用方法设置窗体的菜单栏
    }

    public MenuTest(){
        this.setSize(300,300);
        this.setTitle("菜单实例");
        initMenu();
        initButton();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton item = (AbstractButton)e.getSource();
        //将动作事件的事件源强制转换为菜单项对象
        if(item.getText().equals("红色")){
            this.getContentPane().setBackground(Color.red);
        }else{

            if(item.getText().equals("蓝色")){

                this.getContentPane().setBackground(Color.blue);

            }else{

                    this.getContentPane().setBackground(Color.green);
            }

        }


    }


    public static void main(String[] args) {
        MenuTest menuTest = new MenuTest();

    }
}
