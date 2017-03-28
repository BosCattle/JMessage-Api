package tech.jiangtao.backstage.model;

public class BroadcastMsgsRecipientsKey {
    private String msgId;

    private Long jidId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
    }

    public Long getJidId() {
        return jidId;
    }

    public void setJidId(Long jidId) {
        this.jidId = jidId;
    }
}