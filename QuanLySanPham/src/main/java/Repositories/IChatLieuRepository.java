/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repositories;

import DomainModels.ChatLieu;
import java.util.List;

/**
 *
 * @author dytc0
 */
public interface IChatLieuRepository {
    List<ChatLieu> getProducts();
    
    ChatLieu save(ChatLieu chatLieu);
    ChatLieu update2(ChatLieu chatLieu);
}
