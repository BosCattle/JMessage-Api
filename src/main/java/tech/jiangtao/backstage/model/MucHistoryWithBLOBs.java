package tech.jiangtao.backstage.model;

public class MucHistoryWithBLOBs extends MucHistory {
    private String body;

    private String msg;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}