/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.ChatLieu;
import DomainModels.DanhMucSanPham;
import DomainModels.KieuDang;
import DomainModels.MauSac;
import DomainModels.SanPham;
import DomainModels.Size;
import java.util.List;

/**
 *
 * @author hieu
 */
public interface ISanPhamRepository {
    public SanPham insert(SanPham Sp);

    public boolean update(SanPham Sp);

    public List<SanPham> selectAll();
    public List<MauSac> selectAllms();
    public List<DanhMucSanPham> selectAlldmsp();
    public List<Size> selectAllsi();
    public List<KieuDang> selectAllkd();
    public List<ChatLieu> selectAllcl();

    public SanPham findById(SanPham ma);
    
}
