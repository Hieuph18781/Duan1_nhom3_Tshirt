/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.Size;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IManageSizeService {
    List<Size> getSize(int position,int pageSize);
    Size createNewSize(Size size);
    Size UpdateNewSize(Size size);
  
}
