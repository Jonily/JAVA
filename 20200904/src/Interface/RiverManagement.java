package Interface;

import deal.MainInterfaceDeal;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * 主界面
 * User: Listen-Y.
 * Date: 2020-09-04
 * Time: 23:39
 */
@SuppressWarnings("all")
public class RiverManagement extends JFrame {

    //标签
    private JLabel label;
    //实现6个功能按钮
    private JButton[] jButtons;
    //放按钮的面板
    private JPanel panel;

    public RiverManagement() {
        this.setSize(800, 600);
        this.setTitle("河流信息管理");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //点击一个关闭所有并退出程序
        this.setResizable(false);
        this.setVisible(true);
        init();
    }

    //添加控件
    private void init() {
        //添加标签
        label = new JLabel();
        label.setText("欢迎您来到 214么么哒 河流管理主界面");
        label.setFont(new Font("", 1, 30));
        label.setSize(600, 100);
        label.setLocation(140, 50);
        this.add(label);
        //添加按钮
        panel = new JPanel();
        panel.setSize(400, 220);
        panel.setLocation(200, 200);
        panel.setLayout(new GridLayout(3, 2, 20, 40));
        jButtons = new JButton[6];
        String[] names = new String[] {"显示所有河流", "查找具体河流", "增加河流信息",
                                      "修改河流信息", "删除具体河流", "河流整治总览"};
        //添加按钮 注册事件
        MainInterfaceDeal deal = new MainInterfaceDeal(this);
        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton(names[i]);
            jButtons[i].setFont(new Font("", Font.PLAIN, 20));
            //注册监听器
            jButtons[i].addActionListener(deal);
            panel.add(jButtons[i]);
        }
        this.add(panel);
    }
}
