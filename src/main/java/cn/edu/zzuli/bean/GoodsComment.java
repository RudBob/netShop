package cn.edu.zzuli.bean;

public class GoodsComment {
    private Integer cdId;

    private String context;

    private String assessLevel;

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