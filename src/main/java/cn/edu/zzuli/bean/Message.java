package cn.edu.zzuli.bean;

import java.time.LocalDateTime;
public class Message {
    private Integer chatDetailId;

    private String content;

    private LocalDateTime chatDatetime;

    private Integer fromUserId;

    private Integer toUserId;

    public static Message msgFactory(String content, Integer toUserId, Integer fromUserId) {
        Message message = new Message();
        message.setContent(content);
        message.setToUserId(toUserId);
        message.setFromUserId(fromUserId);
        message.setChatDatetime(LocalDateTime.now());
        return null;
    }


    public Integer getChatDetailId() {
        return chatDetailId;
    }

    public void setChatDetailId(Integer chatDetailId) {
        this.chatDetailId = chatDetailId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public LocalDateTime getChatDatetime() {
        return chatDatetime;
    }

    public void setChatDatetime(LocalDateTime chatDatetime) {
        this.chatDatetime = chatDatetime;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }
}