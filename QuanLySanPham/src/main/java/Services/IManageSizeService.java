/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewsModels.SizeModel;

import java.util.List;

/**
 *
 * @author Chung
 */
public interface IManageSizeService {
    List<SizeModel> getSize(int position,int pageSize);
    SizeModel createNewSize(SizeModel size);
    SizeModel UpdateNewSize(SizeModel size);
    public String sua(SizeModel size);
    public int getMaxIdSize();
    public List<SizeModel> TimKiem(String ten);
    public List<SizeModel> getfullize();
}
