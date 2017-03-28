package tech.jiangtao.backstage.model;

public class XmppStanza {
    private Long id;

    private String stanza;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStanza() {
        return stanza;
    }

    public void setStanza(String stanza) {
        this.stanza = stanza == null ? null : stanza.trim();
    }
}