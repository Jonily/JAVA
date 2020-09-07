package deal;

import Interface.UpdateRiver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 17:08
 */
public class UpdateDeal implements ActionListener {

    private UpdateRiver event;


    public UpdateDeal(UpdateRiver event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(event, "修改成功");
    }
}
