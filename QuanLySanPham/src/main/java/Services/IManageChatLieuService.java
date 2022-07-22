/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.ChatLieu;
import ViewsModel.ChatLieuModel;
import java.util.List;

/**
 *
 * @author dytc0
 */
public interface IManageChatLieuService {
    List<ChatLieuModel> getProducts();
    
    ChatLieuModel insert(ChatLieuModel chatLieu);
    ChatLieuModel update(ChatLieuModel chatLieu);
    
}
