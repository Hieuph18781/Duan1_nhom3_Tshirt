/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.Size;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ISizeRepository {
    List<Size> finAll(int position,int pageSize);
    Size save(Size size);
    String dalete(String MaSize);
    
            
}
