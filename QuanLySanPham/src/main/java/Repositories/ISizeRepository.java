/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.Size;
import java.util.List;

/**
 *
 * @author Chung
 */
public interface ISizeRepository {
    List<Size> finAll(int position,int pageSize);
    Size save(Size size);
    String dalete(String MaSize);
    public boolean  update (Size size);
    List<Size> find();
    public List<Size> getfullsizedb();
            
}
