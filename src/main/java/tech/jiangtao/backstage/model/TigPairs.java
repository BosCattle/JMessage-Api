package tech.jiangtao.backstage.model;

public class TigPairs {
    private Long nid;

    private Long uid;

    private String pkey;

    private String pval;

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey == null ? null : pkey.trim();
    }

    public String getPval() {
        return pval;
    }

    public void setPval(String pval) {
        this.pval = pval == null ? null : pval.trim();
    }
}