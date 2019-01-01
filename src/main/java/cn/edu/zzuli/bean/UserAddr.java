package cn.edu.zzuli.bean;

public class UserAddr {
    private Integer addId;

    private String addName;

    private Integer userId;

    private String addNameDetail;

    private String receiverTel;

    private String receiverName;

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName == null ? null : addName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddNameDetail() {
        return addNameDetail;
    }

    public void setAddNameDetail(String addNameDetail) {
        this.addNameDetail = addNameDetail == null ? null : addNameDetail.trim();
    }

    public String getReceiverTel() {
        return receiverTel;
    }

    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel == null ? null : receiverTel.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }
}