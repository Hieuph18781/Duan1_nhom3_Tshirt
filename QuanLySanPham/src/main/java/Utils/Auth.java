/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import ViewsModels.NhanVienModel;

/**
 *
 * @author Nguyen Van Thuan
 */
public class Auth {
    public static NhanVienModel user = null;
    public static void clear(){
        Auth.user=null;
    }
    public static boolean isLogin(){
        return Auth.user != null;
    }
//    public static boolean isManager(){
//        return Auth.isLogin()&&user.get;
//    }
}
