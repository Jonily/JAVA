package Interface;

import deal.FindOneRiverDeal;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 11:39
 */
public class FindRiver extends JFrame {

    private JLabel message;
    //编号
    private JLabel name;
    private JTextField nameText;
    private JButton ok;

    private JPanel panel;
    // 标签
    public JLabel[] labels;
    // 返回的信息
    public JLabel[] answers;

    public FindRiver() {
        this.setSize(500, 600);
        this.setTitle("显示具体河流信息");
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        init();
    }

    private void init() {
        message = new JLabel();
        message.setSize(400, 30);
        message.setLocation(0, 0);
        message.setText("根据名称查找信息");
        message.setFont(new Font("", 0, 20));
        this.add(message);
        name = new JLabel("河流名称");
        name.setSize(100, 30);
        name.setLocation(0, 50);
        name.setFont(new Font("", 1, 20));
        nameText = new JTextField();
        nameText.setSize(100, 40);
        nameText.setLocation(110, 50);
        nameText.setFont(new Font("", 0, 20));
        ok = new JButton("查找");
        ok.setFont(new Font("", 1, 15));
        ok.setSize(100, 30);
        ok.setLocation(250, 50);
        FindOneRiverDeal deal = new FindOneRiverDeal(this);
        ok.addActionListener(deal);
        this.add(ok);
        this.add(name);
        this.add(nameText);

        //初始化标签
        panel = new JPanel();
        panel.setSize(350, 340);
        panel.setLocation(100, 140);
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        String[] names = new String[] {"河流名称:", "河流长度:", "地理位置:", "河流类型:", "治理情况:"};
        labels = new JLabel[6];
        answers = new JLabel[6];
        for (int i = 0; i < names.length; i++) {
            labels[i] = new JLabel(names[i]);
            labels[i].setFont(new Font("", 1, 23));
            answers[i] = new JLabel();
            answers[i].setFont(new Font("", 0, 15));
            panel.add(labels[i]);
            panel.add(answers[i]);
        }
        this.add(panel);
    }
}
