package deal;

import Interface.DeleteRiver;
import dao.RiverDao;
import exception.riverException;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 16:47
 */
public class DeleteDeal implements ActionListener {

    private DeleteRiver event;

    public DeleteDeal(DeleteRiver event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取删除的名字
        String name = event.text.getText();
        if (name == null || name.trim().equals("")) {
            JOptionPane.showMessageDialog(event, "请填写完整信息");
            return;
        }
        RiverDao dao = new RiverDao();
        try {
            dao.deleteRiverByName(name.trim());
        } catch (riverException ex) {
            JOptionPane.showMessageDialog(event, "删除失败");
        }
        event.text.setText("");
        JOptionPane.showMessageDialog(event, "删除成功");
    }
}
