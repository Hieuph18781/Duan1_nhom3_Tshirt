/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nguyen Van Thuan
 */
public class CheckData {

    public CheckData() {
    }
  
    public boolean chekcKhoangTrang(String text) {
        int temp = text.indexOf(" ");
        if (temp > -1) {
            return true;
        }
        return false;
    }

    public boolean checkNullString(String text) {
        if (text.isBlank()) {
            return true;
        }
        return false;
    }

    public boolean checkKyTuKhongDau(String text) { // check ký tự (Không bao gốm dấu)
        Pattern p = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher m = p.matcher(text);// Â
        return m.find();// Fasle
    }

    public boolean checkKyTuCoDau(String text) { // check ký tự (Tviet có dấu)
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(text);// Â
        return m.find();// true
    }

    public Boolean checkso(String text) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}
