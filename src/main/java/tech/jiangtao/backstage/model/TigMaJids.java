package tech.jiangtao.backstage.model;

public class TigMaJids {
    private Long jidId;

    private String jid;

    public Long getJidId() {
        return jidId;
    }

    public void setJidId(Long jidId) {
        this.jidId = jidId;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid == null ? null : jid.trim();
    }
}