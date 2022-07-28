/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.KhuyenMai;
import java.util.List;

/**
 *
 * @author hieu
 */
public interface IKhuyenmaiRepository {
    public KhuyenMai insert(KhuyenMai km);

    public boolean update(KhuyenMai km);

    public List<KhuyenMai> selectAll();

    public KhuyenMai selectById(KhuyenMai enity);
}
