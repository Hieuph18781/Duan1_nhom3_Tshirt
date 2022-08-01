/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;
import ViewsModels.KieuDangModel;
import java.util.List;

/**
 *
 * @author hieu
 */
public interface IKieuDangService {

    List<KieuDangModel> getproduct();

    KieuDangModel createNewProduct(KieuDangModel kieudang);

    public String sua(KieuDangModel kieudang);
    
    public int getMaxIdKieuDang();

    public List<KieuDangModel> findKieuDang(String tenkiedang);
}
