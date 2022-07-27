/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import DomainModels.ChatLieu;
import Repositories.ChatLieuRepository;
import Repositories.IChatLieuRepository;
import ViewsModels.ChatLieuModel;
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
    public List<ChatLieuModel> getProducts() {
        _lstQlChatLieu = new ArrayList<>();
        var cl = _IChatLieuRepository.getProducts();
        for (ChatLieu x : cl) {
            _lstQlChatLieu.add(new ChatLieuModel(x.getMaChatLieu(), x.getMota(), x.getTenChatLieu()));
        }
        return _lstQlChatLieu;
    }

    @Override
    public ChatLieuModel insert(ChatLieuModel chatLieu) {
        chatLieu.getMaChatLieu();
        var x = _IChatLieuRepository.save(new ChatLieu(chatLieu.getMaChatLieu(), chatLieu.getTenChatLieu(), chatLieu.getMota()));
        return new ChatLieuModel(x.getMaChatLieu(), x.getTenChatLieu(), x.getMota());
    }

    @Override
    public ChatLieuModel update(ChatLieuModel chatLieu) {
        var x = _IChatLieuRepository.update2(new ChatLieu(chatLieu.getMaChatLieu(), chatLieu.getTenChatLieu(),chatLieu.getMota()));
        return new ChatLieuModel(x.getMaChatLieu(), x.getTenChatLieu(), x.getMota());
    }

    @Override
    public int getMaChatLieu() {
        return _lstQlChatLieu.size() + 1;
    }

    @Override
    public List<ChatLieuModel> findChatLieuByName(String tenChatLieu) {
        List<ChatLieuModel> lstFind = new ArrayList<>();
        if (tenChatLieu.isBlank()) {
            return _lstQlChatLieu;
        }
        for (ChatLieuModel x : _lstQlChatLieu) {
            if (x.getTenChatLieu().toLowerCase().contains(tenChatLieu)) {
                lstFind.add(x);
            }
        }
        return lstFind;
    }

}
