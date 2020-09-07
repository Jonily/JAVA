package deal;

import Interface.FindRiver;
import jdk.nashorn.internal.scripts.JO;

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
        JOptionPane.showMessageDialog(event, "显示成功");
    }
}
