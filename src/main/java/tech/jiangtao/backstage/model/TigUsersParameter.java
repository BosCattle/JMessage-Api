package tech.jiangtao.backstage.model;

/**
 * 用户传递进来的参数
 */
public class TigUsersParameter extends TigUsers {

  private String serverName;
  private String userId;

  @Override public String getUserId() {
    return userId;
  }

  public String getServerName() {
    return serverName;
  }

  @Override public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setServerName(String serverName) {
    this.serverName = serverName;
  }
}
