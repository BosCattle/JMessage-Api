/**
 * 首页
 */
var bosh_service = "ws://localhost:5290/bosh";
var jid = "";
var connected = false;
// 连接状态改变的事件
function onConnect(status) {
  console.log(status);
  if (status == Strophe.Status.CONNFAIL) {
    alert("连接失败！");
  } else if (status == Strophe.Status.AUTHFAIL) {
    alert("登录失败！");
  } else if (status == Strophe.Status.DISCONNECTED) {
    alert("连接断开！");
    connected = false;
  } else if (status == Strophe.Status.CONNECTED) {
    alert("连接成功，可以开始聊天了！");
    connected = true;
    // 当接收到<message>节，调用onMessage回调函数
    connection.addHandler(onMessage, null, 'message', null, null, null);
    // 首先要发送一个<presence>给服务器（initial presence）
    connection.send($pres().tree());
  }

  function login() {
    if (!connected) {
      connection = new Strophe().Connection(bosh_service);
      jid = $("#login-name").val();
      connection.connect(jid, $("#login-pass").val(), onConnect);
    }
  }

  $(function () {
    $("login_button").click = login();
  })
}