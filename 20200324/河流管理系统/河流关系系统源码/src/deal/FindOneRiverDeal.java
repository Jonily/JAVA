package deal;

import Interface.FindRiver;
import dao.RiverDao;
import exception.riverException;
import jdk.nashorn.internal.scripts.JO;
import model.River;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 17:25
 */
public class FindOneRiverDeal implements ActionListener {

    private FindRiver event;

    public FindOneRiverDeal(FindRiver event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = event.nameText.getText();
        if (name == null || name.trim().equals("")) {
            JOptionPane.showMessageDialog(event, "请填写名字");
            return;
        }
        RiverDao dao = new RiverDao();
        River river = null;
        try {
            river = dao.selectByName(name.trim());
            if (river == null) {
                JOptionPane.showMessageDialog(event, "请检查这条河流是否存在");
                return;
            }
        } catch (riverException ex) {
            JOptionPane.showMessageDialog(event, "未查到有这条河流,请检查信息正确性");
            return;
        }
        //"河流名称:", "河流长度:", "地理位置:", "河流类型:", "治理情况:"
        event.answers[0].setText(river.getRiver_name());
        event.answers[1].setText(river.getRiver_length());
        event.answers[2].setText(river.getRiver_location());
        event.answers[3].setText(river.getRiver_class());
        event.answers[4].setText(river.getRiver_status());
    }
}
