/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.KieuDang;
import java.util.List;

/**
 *
 * @author hieu
 */
public interface IKieuDangRepository {
    List<KieuDang> findAll();
    KieuDang Save(KieuDang color);
    KieuDang findById(String ma);
}
