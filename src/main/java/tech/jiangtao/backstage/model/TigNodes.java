package tech.jiangtao.backstage.model;

public class TigNodes {
    private Long nid;

    private Long parentNid;

    private Long uid;

    private String node;

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public Long getParentNid() {
        return parentNid;
    }

    public void setParentNid(Long parentNid) {
        this.parentNid = parentNid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node == null ? null : node.trim();
    }
}