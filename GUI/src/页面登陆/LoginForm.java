package 页面登陆;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/23 10:45
 */
import java.awt.*;
import javax.swing.*;
public class LoginForm extends JFrame {//创建一个继承框架窗口类的登录窗口类
//窗口中包含的组件
    JLabel userLabel,pwLabel;//定义两个标签，一个用户名标签，一个密码标签
    JTextField userText;//用于输入用户名的文本框
    JPasswordField pwText;//用于输入密码的密码框
    JButton loginBt,quitBt;//定义两个按钮，一个是登录按钮，一个是退出按钮


    public LoginForm(){//在构造方法中设置窗体的相关属性
        this.setSize(400,300);
        //this.setSize(new Dimension(400,300));
        this.setTitle("登录窗口");//设置窗体的标题
        this.getContentPane().setBackground(Color.white);//设置窗体背景颜色
        init();//在构造方法中调用初始化控件方法
        this.setVisible(true);
    }
    private void init(){//初始化登录窗口中控件的方法
         userLabel = new JLabel("用户名");//初始化用户标签对象，并设置标签上的文字
        pwLabel = new JLabel("密码");//初始化密码标签对象，并设置标签上的文本
        /*pwLabel = new JLabel();
        pwLabel.setText("密码");*/
        userText = new JTextField();//初始化用户文本框
        pwText = new JPasswordField();//初始化密码框对象
        loginBt = new JButton("登录");//初始化登录按钮对象
        quitBt = new JButton("退出");//初始化退出按钮对象
        //改为精确布局方式，设置每个空间位置
        this.setLayout(null);//设置布局对象为空
        userLabel.setSize(60,30);//设置控件的大小
        //userLabel.setLocation(new Point(30,30));
        userLabel.setLocation(80,60);//设置控件左上角坐标
        this.add(userLabel);
        userText.setSize(120,20);//设置控件的大小
        userText.setLocation(140,70);//设置控件左上角坐标
        this.add(userText);
        pwLabel.setSize(60,30);//设置控件的大小
        pwLabel.setLocation(80,100);//设置控件左上角坐标
        this.add(pwLabel);
        pwText.setSize(120,20);//设置控件的大小
        pwText.setLocation(140,110);//设置控件左上角坐标
        this.add(pwText);
        loginBt.setSize(80,40);//设置控件的大小
        loginBt.setLocation(70,150);//设置控件左上角坐标
        this.add(loginBt);
        quitBt.setSize(80,40);//设置控件的大小
        quitBt.setLocation(230,150);//设置控件左上角坐标
        this.add(quitBt);





        /* //以下是默认的边界布局
        this.add(userLabel,BorderLayout.NORTH);//登录窗口添加控件对象
        this.add(pwLabel,BorderLayout.EAST);//登录窗口添加控件对象
        this.add(userText,BorderLayout.NORTH);//登录窗口添加控件对象
        this.add(pwText,BorderLayout.SOUTH);//登录窗口添加控件对象
        this.add(loginBt);//登录窗口添加控件对象
        this.add(quitBt);
        //改为流布局方式
        this.setLayout(new FlowLayout());//通过创建一个匿名的流布局对象来设置登录窗口的布局方式为流布局
        this.add(userLabel);//登录窗口添加控件对象
        this.add(userText);//登录窗口添加控件对象
        this.add(pwLabel);//登录窗口添加控件对象
        this.add(pwText);//登录窗口添加控件对象
        this.add(loginBt);//登录窗口添加控件对象
        this.add(quitBt);*/
       /* //改为网格布局
        this.setLayout(new GridLayout(3,2));
        //将当前的登录窗口的布局改为三行两列
        this.add(userLabel);//登录窗口添加控件对象
        this.add(userText);//登录窗口添加控件对象
        this.add(pwLabel);//登录窗口添加控件对象
        this.add(pwText);//登录窗口添加控件对象
        this.add(loginBt);//登录窗口添加控件对象
        this.add(quitBt);*/

    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
    }

}
