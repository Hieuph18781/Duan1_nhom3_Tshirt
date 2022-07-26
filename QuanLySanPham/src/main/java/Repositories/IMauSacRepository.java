/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.MauSac;
import ViewsModels.MauSacModel;
import java.util.List;

/**
 *
 * @author hieu
 */
public interface IMauSacRepository {
    List<MauSac> findAll();
    public MauSac insert(MauSac danhMucSp);

    public boolean update(MauSac danhMucSp);
    MauSac findById(String ma);
    
}
