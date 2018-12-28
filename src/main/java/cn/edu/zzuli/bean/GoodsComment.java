package cn.edu.zzuli.bean;

/**
 * 商品下的用户评论
 */
public class GoodsComment {
    private Integer cdId;

    private String context;

    private String assessLevel;

    private Integer userId;

    @Override
    public String toString() {
        return "GoodsComment{" +
                "cdId=" + cdId +
                ", context='" + context + '\'' +
                ", assessLevel='" + assessLevel + '\'' +
                ", userId=" + userId +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCdId() {
        return cdId;
    }

    public void setCdId(Integer cdId) {
        this.cdId = cdId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    public String getAssessLevel() {
        return assessLevel;
    }

    public void setAssessLevel(String assessLevel) {
        this.assessLevel = assessLevel == null ? null : assessLevel.trim();
    }
}