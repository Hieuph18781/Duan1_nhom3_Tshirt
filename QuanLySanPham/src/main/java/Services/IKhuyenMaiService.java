/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.KhuyenMaiModel;
import java.util.List;

/**
 *
 * @author hieu
 */
public interface IKhuyenMaiService {
    public String them(KhuyenMaiModel kmModel);
    public String sua(KhuyenMaiModel kmModel);
    public List<KhuyenMaiModel> getListFromDB();
    public int getMaDanhMuc();
    public List<KhuyenMaiModel> findDanhMucSp(String tenDmSp);
}
