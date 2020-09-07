package deal;

import Interface.AddRiver;
import dao.RiverDao;
import exception.riverException;
import model.River;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 16:30
 */
public class AddRiverDeal implements ActionListener {

    private AddRiver event;

    public AddRiverDeal(AddRiver event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = event.textFields[0].getText();
        String length = event.textFields[1].getText();
        String location = event.textFields[2].getText();
        //判断信息是否未填写
        if (check(name, length, location)) {
            String riverClass = (String) event.classBox.getSelectedItem();
            String status = (String) event.statusBox.getSelectedItem();
            River river = new River();
            river.setRiver_class(riverClass);
            river.setRiver_length(length.trim());
            river.setRiver_location(location.trim());
            river.setRiver_name(name.trim());
            river.setRiver_status(status);
            //数据库处理
            RiverDao dao = new RiverDao();
            try {
                dao.addRiver(river);
            } catch (riverException ex) {
                JOptionPane.showMessageDialog(event, "增加失败");
            }
            //将面板内容清空
            for (int i = 0; i < 3; i++) {
                event.textFields[i].setText("");
            }
            JOptionPane.showMessageDialog(event, "增加成功");
        } else {
            JOptionPane.showMessageDialog(event, "请完整填写信息!");
        }

    }

    private boolean check(String name, String length, String location) {
        return name != null && !name.trim().equals("") && length != null && !length.trim().equals("") && location != null && !location.trim().equals("");
    }
}
