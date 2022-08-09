/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 *
 * @author Nguyen Van Thuan
 */
public class CheckData {

    public CheckData() {
    }

    public static boolean chekcKhoangTrang(String text) {
        int temp = text.indexOf(" ");
        if (temp > -1) {
            return true;
        }
        return false;
    }

    public static boolean checkNullString(String text) {
        if (text.isBlank()) {
            return true;
        }
        return false;
    }

    public static boolean checkKyTuKhongDau(String text) { // check ký tự (Không bao gốm dấu)
        Pattern p = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher m = p.matcher(text);// Â
        return m.find();// Fasle
    }

    public static boolean checkKyTuCoDau(String text) { // check ký tự (Tviet có dấu)
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(text);// Â
        return m.find();// true
    }

    public static Boolean checkso(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static Boolean checksoThuc(String text) {
        Pattern pattern = Pattern.compile("[0-9]{1,13}(\\.[0-9]*)?");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean checkNullText(JTextField txt) {
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống ");
            return false;
        }
    }

    public static boolean chekcKhoangTrang3(JTextField txt) {
        int temp = txt.getText().indexOf(" ");
        if (temp > -1) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Không được chứa khoảng trắng");
            return false;
        }

    }

    public static boolean checkNullText(JPasswordField txt) {
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống ");
            return false;
        }
    }

    public static boolean checkNullText(JTextArea txt) {
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống ");
            return false;
        }
    }

    public static String unAccent(String s) {//Convert từ tiếng việt có dấu về tiếng việt 0 dấu
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "d");
    }

    public static boolean chekcKhoangTrang2(String text) {
        int temp = text.indexOf(" ");
        if (temp > -1) {
            return true;
        }
        return false;
    }

}
