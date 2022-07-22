/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChatLieu;
import Repositories.ChatLieuRepository;
import Repositories.IChatLieuRepository;
import ViewsModel.ChatLieuModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dytc0
 */
public class ManageChatLieuService implements IManageChatLieuService {

    private final IChatLieuRepository _IChatLieuRepository;
    private List<ChatLieuModel> _lstQlChatLieu;

    public ManageChatLieuService() {
        _IChatLieuRepository = new ChatLieuRepository();
        _lstQlChatLieu = new ArrayList<>();
    }

    @Override
    public List<ChatLieuModel> getProducts(int position, int pageSize) {
        _lstQlChatLieu = new ArrayList<>();
        var cl = _IChatLieuRepository.getProducts(position, pageSize);
        for (ChatLieu x : cl) {
            _lstQlChatLieu.add(new ChatLieuModel(x.getMaChatLieu(), x.getMota(), x.getTenChatLieu()));
        }
        return _lstQlChatLieu;
    }

    @Override
    public ChatLieuModel insert(ChatLieuModel chatLieu) {
        chatLieu.getMaChatLieu();
        var x = _IChatLieuRepository.save(new ChatLieu(chatLieu.getMaChatLieu(), chatLieu.getTenChatLieu(),chatLieu.getMota()));
        return new ChatLieuModel(x.getMaChatLieu(),x.getMota(), x.getTenChatLieu());
    }

    @Override
    public ChatLieuModel update(ChatLieuModel chatLieu) {
        var x = _IChatLieuRepository.update2(new ChatLieu(chatLieu.getMaChatLieu(), chatLieu.getTenChatLieu(),chatLieu.getMota()));
        return new ChatLieuModel(x.getMaChatLieu(),x.getMota(), x.getTenChatLieu());
    }

}