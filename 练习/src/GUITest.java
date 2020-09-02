import javax.swing.*;

public class GUITest extends JFrame {

    JLabel user,password;
    JTextField userText;
    JPasswordField passwordField;
    JButton loginButter,quitButter;

    public GUITest(){
        this.setSize(400,300);
        this.setTitle("denglu");
        init();
        this.setVisible(true);

    }

    private void init() {
        user = new JLabel("用户");
        password = new JLabel("密码");

        userText = new JTextField();
        passwordField = new JPasswordField();

        loginButter = new JButton("dneglu");
        quitButter = new JButton("tuichu");

        this.setLayout(null);

        user.setSize(60,30);
        user.setLocation(60,60);
        this.add(user);


        password.setSize(60,30);
        password.setLocation(60,120);
        this.add(password);


        userText.setSize(170,30);
        userText.setLocation(170,60);
        this.add(userText);


        passwordField.setSize(170,30);
        passwordField.setLocation(170,120);
        this.add(passwordField);

        loginButter.setSize(80, 30);//设置控件的大小
        //userLabel.setLocation(new Point(40,60));
        loginButter.setLocation(90, 180);//设置控件的左上角坐标
        this.add(loginButter);

        quitButter.setSize(80, 30);//设置控件的大小
        //userLabel.setLocation(new Point(40,60));
        quitButter.setLocation(200, 180);//设置控件的左上角坐标
        this.add(quitButter);



    }

}
class test1{
    public static void main(String[] args) {

        GUITest guiTest = new GUITest();


    }

}
