/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import static java.awt.Color.pink;
import static java.awt.Color.white;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author dytc0
 */
public class validate {
    public static boolean checkNullText(JTextField txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }

    public static boolean checkNullText(JTextArea txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
    public static boolean checkMaNV(JTextField txt) {
        String id = txt.getText();
        String rgx = "CL[000-999]{2}";
        if (id.matches(rgx)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(txt.getRootPane(),"Không đúng định dạng. VD: NV001");
            return false;
        }
    }
}
