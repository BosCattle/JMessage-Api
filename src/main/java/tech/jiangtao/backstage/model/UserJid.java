package tech.jiangtao.backstage.model;

public class UserJid {
    private Long jidId;

    private String jidSha;

    private String jid;

    private Integer historyEnabled;

    public Long getJidId() {
        return jidId;
    }

    public void setJidId(Long jidId) {
        this.jidId = jidId;
    }

    public String getJidSha() {
        return jidSha;
    }

    public void setJidSha(String jidSha) {
        this.jidSha = jidSha == null ? null : jidSha.trim();
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid == null ? null : jid.trim();
    }

    public Integer getHistoryEnabled() {
        return historyEnabled;
    }

    public void setHistoryEnabled(Integer historyEnabled) {
        this.historyEnabled = historyEnabled;
    }
}