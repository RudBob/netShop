package cn.edu.zzuli.service.chat;

import cn.edu.zzuli.bean.Message;

import java.util.List;

public interface ChatService {
    Message sendMsgToOther(String content, Integer toOtherId);

    List<Message> showMsg(Integer toUserId);
}
