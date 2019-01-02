package cn.edu.zzuli.service.chat.impl;

import cn.edu.zzuli.bean.Message;
import cn.edu.zzuli.mapper.MessageMapper;
import cn.edu.zzuli.service.chat.ChatService;
import cn.edu.zzuli.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    MessageMapper messageMapper;

    /**
     * 给另一个人发送消息
     *
     * @param content  消息内容
     * @param toUserId 接收者userId
     * @return 成功与否
     */
    @Override
    public Message sendMsgToOther(String content, Integer toUserId) {
        int fromUserId = SessionUtil.getUserIdFromSession();
        Message message = Message.msgFactory(content, toUserId, fromUserId);
        int line = messageMapper.insert(message);
        return messageMapper.selectMsgByTwoUserIdLastMsg(toUserId, fromUserId);
    }

    /**
     * 按时间逆序，每次查出来十条
     *
     * @param toUserId 发送的userId
     * @return List<Message> 信息列表
     */
    @Override
    public List<Message> showMsg(Integer toUserId) {
        int fromUserId = SessionUtil.getUserIdFromSession();
        List<Message> messageList = messageMapper.selectMsgByTwoUserId(toUserId, fromUserId);
        return messageList;
    }
}
