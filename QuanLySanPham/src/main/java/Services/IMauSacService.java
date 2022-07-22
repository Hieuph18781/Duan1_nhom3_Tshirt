/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.MauSac;
import ViewsModels.MauSacModel;
import ViewsModels.MauSacModel;
import java.util.List;

/**
 *
 * @author hieu
 */
public interface IMauSacService {
    List<MauSacModel> getproduct();
    MauSacModel createNewProduct(MauSacModel color);
    MauSacModel updateProductById(MauSacModel colors); 
}
