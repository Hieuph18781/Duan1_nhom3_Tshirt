/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;


import ViewsModel.KieuDangModel;

import java.util.List;

/**
 *
 * @author hieu
 */
public interface IKieuDangService {
    List<KieuDangModel> getproduct();
    KieuDangModel createNewProduct(KieuDangModel kieudang);
    KieuDangModel updateProductById(KieuDangModel kieudang); 
}
