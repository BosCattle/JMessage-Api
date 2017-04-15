package tech.jiangtao.backstage.model;

public class TigGroupMember {
    private Integer id;

    private String groupId;

    private String userId;

    private Byte isReceived;

    private Byte authority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Byte getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(Byte isReceived) {
        this.isReceived = isReceived;
    }

    public Byte getAuthority() {
        return authority;
    }

    public void setAuthority(Byte authority) {
        this.authority = authority;
    }
}