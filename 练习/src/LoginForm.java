import java.awt.*;
import javax.swing.*;

public class LoginForm extends JFrame //创建一个继承框架窗口类的登录窗口类
{
    //定义窗口中包含的控件
    JLabel userLabel,pwLabel;//定义两个标签，一个用户名标签，一个密码标签
    JTextField userText;//用于输入用户名的文本框
    JPasswordField pwText;//用户输入密码的密码框
    JButton loginBt,quitBt;//定义两个按钮，一个是登录按钮，一个是退出按钮

    public LoginForm()//在构造方法中设置窗体的相关属性
    {
        this.setSize(400, 300);//设置窗体的尺寸（即宽度和高度）
        //this.setSize(new Dimension(400,300));
        this.setTitle("登录窗口");//设置窗体的标题
        //this.getContentPane().setBackground(Color.WHITE);
        init();//在构造方法中调用初始化控件的方法
        this.setVisible(true);//设置窗体可见
    }

    private void init()//初始化登录窗口中控件的方法
    {
        userLabel=new JLabel("用户名");//初始化用户标签对象，并设置标签上的文本
        pwLabel=new JLabel("密    码");
        //pwLabel.setText("密    码");//初始化密码标签对象，并设置标签上的文本
        userText=new JTextField();//初始化用户文本框
        pwText=new JPasswordField();//初始化密码框对象
        loginBt=new JButton("登录");//初始化登录按钮对象
        quitBt=new JButton("退出");
       // quitBt.setText("退出");//初始化退出按钮对象
        ////以下是默认的边界布局方式
		/*this.add(userLabel,BorderLayout.WEST);//登录窗口添加控件对象
		this.add(pwLabel,BorderLayout.EAST);
		this.add(userText,BorderLayout.NORTH);
		this.add(pwText,BorderLayout.SOUTH);
		this.add(loginBt);
		this.add(quitBt);*/
        ////改为流布局方式
		/*this.setLayout(new FlowLayout());
		//通过创建一个匿名的流布局对象来设置登录窗口的布局方式为流布局
		this.add(userLabel);
		this.add(userText);
		this.add(pwLabel);
		this.add(pwText);
		this.add(loginBt);
		this.add(quitBt);*/
        //改为网格布局方式
		/*this.setLayout(new GridLayout(3,2));
		//将当前的登录窗口的布局方式改为网格布局，划分成3行两列
		this.add(userLabel);
		this.add(userText);
		this.add(pwLabel);
		this.add(pwText);
		this.add(loginBt);
		this.add(quitBt);*/
        //改为精确布局方式，即设置每个空间的位置
        this.setLayout(null);//设置布局对象为空
        userLabel.setSize(60, 30);//设置控件的大小
        //userLabel.setLocation(new Point(40,60));
        userLabel.setLocation(60, 60);//设置控件的左上角坐标
        this.add(userLabel);

        userText.setSize(170, 30);//设置控件的大小
        //userLabel.setLocation(new Point(40,60));
        userText.setLocation(140, 60);//设置控件的左上角坐标
        this.add(userText);

        pwLabel.setSize(60, 30);//设置控件的大小
        //userLabel.setLocation(new Point(40,60));
        pwLabel.setLocation(60, 120);//设置控件的左上角坐标
        this.add(pwLabel);

        pwText.setSize(170, 30);//设置控件的大小
        //userLabel.setLocation(new Point(40,60));
        pwText.setLocation(140, 120);//设置控件的左上角坐标
        this.add(pwText);

        loginBt.setSize(80, 30);//设置控件的大小
        //userLabel.setLocation(new Point(40,60));
        loginBt.setLocation(90, 180);//设置控件的左上角坐标
        this.add(loginBt);

        quitBt.setSize(80, 30);//设置控件的大小
        //userLabel.setLocation(new Point(40,60));
        quitBt.setLocation(200, 180);//设置控件的左上角坐标
        this.add(quitBt);
    }
}

class test{
    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();

    }

 }