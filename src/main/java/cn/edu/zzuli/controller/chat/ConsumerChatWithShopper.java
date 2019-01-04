package cn.edu.zzuli.controller.chat;

import cn.edu.zzuli.bean.Message;
import cn.edu.zzuli.service.chat.ChatService;
import cn.edu.zzuli.util.BaseUtil;
import cn.edu.zzuli.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前端理应使用WebSocket协议进行通讯
 */
@RestController
@RequestMapping(value = "/consumerChatWithShopper")
public class ConsumerChatWithShopper {
    @Autowired
    ChatService chatService;

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    /**
     * 与客服交流，交流记录存入数据库中
     */
    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    public Msg sendMsgToOther(@RequestParam(value = "content") String content,
                              @RequestParam(value = "toUserId") Integer toUserId) {
        Message message = chatService.sendMsgToOther(content, toUserId);
        messagingTemplate.convertAndSendToUser(Integer.toString(toUserId), "/queue/chat", message);

        return Msg.success().addResData("message", message);
    }

    /**
     * 展示聊天记录
     */
    @RequestMapping(value = "/showMsg", method = RequestMethod.POST)
    public Msg sendMsgToOther(@RequestParam(value = "toUserId") Integer toUserId) {
        List<Message> messageList = chatService.showMsg(toUserId);
        if (messageList == null || messageList.size() == 0) {
            return Msg.fail();
        } else {
            return Msg.success().addResData("messageList", messageList);
        }
    }
}
