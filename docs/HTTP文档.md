# IM HTTP文档

## 说明

```json
1. Endpoint：
2. common header
  - version-code：版本号
  - version-name：版本名称
  - device：设备唯一编号
  - channel：渠道号
  - platform：平台类型「android、iOS」
  - Authorization: Bearer {yourtokenhere}「注册用户token传到header里面」
  - Accept: **
3. code
  - 200：代表成功返回数据
4. status_code
  - 404：代表没有找到对应的 API 或者 Entity
  - 422：代表没有条件校验不通过
  - 403：用户名或密码不正确
  - 401：未登录
```



## 账户

###  用户注册

* 地址: POST `/account/create`
* demo: http://message.jiangtao.tech/tigase/account/create
* 参数:
  - userJid: 用户注册的唯一标志。eg:dddddd@message.com(**required**)
  - nickName: 账户昵称(**required**)
  - password: 账户密码。>=6(**required**)
  - avatar: 账户头像地址.
  - sex: 性别。true->女，false->男。
  - signature: 个性签名。
* Response

  ```json
  {
  "uid": 195,
  "nid": 104,
  // 用户唯一标志
  "userId": "测试十三@dc-a4b8eb92-xmpp.jiangtao.tech.",
  "nickName": "哈哈哈",
  "avatar": null,
  // 是否是好友关系
  "relative": false,
  // 邀请类型，好友邀请，群邀请
  "inviteType": null,
  "signature": null,
  "sex": false,
  // 权限检查
  "token": "8899bee70a4040558d09c89af1d7ca7a"
  }
  ```



### 用户资料更新

* 地址: POST `/account/update`
* demo: http://message.jiangtao.tech/tigase/account/update
* 参数:
  - uid: 注册时拿到的uid。(**required**)
  - userJid: 用户唯一标志。(**required**)
  - nickName: 昵称。
  - avatar: 用户头像。
  - sex: 性别
  - signature: 个性签名。
* Response:

  ```json
   {
   "uid": 195,
   "nid": 104,
   "userId": "测试十三@dc-a4b8eb92-xmpp.jiangtao.tech.",
   "nickName": "失眠了",
   "avatar": null,
   "relative": false,
   "inviteType": null,
   "signature": null,
   "sex": false,
   "token": null
   }
  ```

### 获取所有的添加好友请求

* 地址: POST `/user/allInvite`

* demo: http://message.jiangtao.tech/tigase/user/allInvite

* 参数

  - userId: 用户唯一标志。(**required**)

* Response:

  ```json
  [
    {
      "account": {
        "uid": 0,
        "nid": 0,
        "userId": "测试九@persistmuc.dc-a4b8eb92-xmpp.jiangtao.tech.",
        "nickName": "测试九",
        "avatar": null,
        "relative": false,
        "inviteType": "FRIEND",
        "signature": null,
        "sex": false,
        "token": null
      },
      "group": null
    },
    {
      "account": {
        "uid": 0,
        "nid": 0,
        "userId": "测试九@dc-a4b8eb92-xmpp.jiangtao.tech.",
        "nickName": "测试九",
        "avatar": null,
        "relative": false,
        "inviteType": "FRIEND",
        "signature": null,
        "sex": false,
        "token": null
      },
      "group": null
    }
  ]
  ```


### 删除好友

* 地址: POST `/user/deleteFriend`
* demo: http://message.jiangtao.tech/tigase/user/deleteFriend
* 参数:
  - uid: 自己本身uid。(**required**)
  - userId: 好友的userId。(**required**)
* Response:

  ```json
  {
  // 删除成功，或者失败的具体原因
  "message": "string",
  // 删除成功,失败
  "result": true
  }
  ```



### 搜索用户

* 地址: GET `/user/queryAccount`
* demo: http://message.jiangtao.tech/tigase/user/queryAccount
* 参数:
  - nickname: 搜索关键字.(**required**)
* Response:

  ```json
  [
  {
    "uid": 50,
    "nid": 15,
    "userId": "测试五@dc-a4b8eb92-xmpp.jiangtao.tech.",
    "nickName": "测试五",
    "avatar": "61506f3f-dc26-4906-bb80-e959495b6d48.jpg",
    "relative": false,
    "inviteType": null,
    "signature": null,
    "sex": false,
    "token": null
  },
  {
    "uid": 43,
    "nid": 47,
    "userId": "测试四@dc-a4b8eb92-xmpp.jiangtao.tech.",
    "nickName": "测试四",
    "avatar": null,
    "relative": false,
    "inviteType": null,
    "signature": null,
    "sex": false,
    "token": null
  }
  ]
  ```



### 查询用户信息

* 地址: POST `/user/queryUser`
* demo: http://message.jiangtao.tech/tigase/user/queryUser
* 参数:
  - userId: 唯一标志。(**required**)
* Response:

  ```json
  {
  "uid": 50,
  "nid": 15,
  "userId": "测试五@dc-a4b8eb92-xmpp.jiangtao.tech.",
  "nickName": "测试五",
  "avatar": "61506f3f-dc26-4906-bb80-e959495b6d48.jpg",
  "relative": false,
  "inviteType": null,
  "signature": null,
  "sex": false,
  "token": null
  }
  ```



### 好友列表

* 地址: POST `/user/queryUserList`
* demo: http://message.jiangtao.tech/tigase/user/queryUserList
* 参数:
  - userId: 唯一标志。(**required**)
* Response:

  ```json
  [
    {
      "uid": 50,
      "nid": 15,
      "userId": "测试五@dc-a4b8eb92-xmpp.jiangtao.tech.",
      "nickName": "测试五",
      "avatar": "61506f3f-dc26-4906-bb80-e959495b6d48.jpg",
      "relative": false,
      "inviteType": null,
      "signature": "null",
      "sex": false,
      "token": null,
      "onlineStatus": 164
    },
    {
      "uid": 51,
      "nid": 18,
      "userId": "vurtex@dc-a4b8eb92-xmpp.jiangtao.tech.",
      "nickName": "vurtex",
      "avatar": "aef61e52-ab9e-4591-8375-e57f96b018b6.jpg",
      "relative": false,
      "inviteType": null,
      "signature": "null",
      "sex": false,
      "token": null,
      "onlineStatus": 46
    }
  ]
  ```



## 群组

### 创建群组

* 地址: POST `/group/create`

* demo: http://message.jiangtao.tech/tigase/group/create

* 参数:
  - groupId: 群组Id。(**required**，群组后缀有区别，注意)
  - userId: 用户id。(**required**)
  - name: 群组名字。(**required**)
  - avatar: 群组头像。
  - description: 群组描述。

* Response:

  ```json
  {
    "uid": 5,
    "groupId": "测试群11@muc-group.dc-a4b8eb92-xmpp.jiangtao.tech.",
    "name": "么么哒",
    "avatar": null,
    "description": null
  }
  ```

  ​

### 添加群成员

* 地址: POST `/group/addMembers`

* demo: http://message.jiangtao.tech/tigase/group/addMembers

* 参数:

  - groupId: 群组Id。(**required**，群组后缀有区别，注意)
  - userId: 用户id。(**required**)
  - userInvitedId: userId数组。(**required**)

* Response:

  ```json
  [
    {
      "authority": true,
      "avatar": "string",
      "inviteType": "FRIEND",
      "nickName": "string",
      "nid": 0,
      "relative": true,
      "sex": true,
      "signature": "string",
      "token": "string",
      "uid": 0,
      "userId": "string"
    }
  ]
  ```

### 删除群成员

* 地址: POST `/group/deleteMember`

* demo: http://message.jiangtao.tech/tigase/group/deleteMember

* 参数:

  - groupId: 群组Id。(**required**，群组后缀有区别，注意)
  - userId: 用户id。(**required**)
  - userIds: userId数组。(**required**)

* Response:

  ```json
  [
    {
      "authority": true,
      "avatar": "string",
      "inviteType": "FRIEND",
      "nickName": "string",
      "nid": 0,
      "relative": true,
      "sex": true,
      "signature": "string",
      "token": "string",
      "uid": 0,
      "userId": "string"
    }
  ]
  ```

### 获取群成员

* 地址: POST `/group/groupMember`

* demo: http://message.jiangtao.tech/tigase/group/groupMember

* 参数:

  - groupId: 群组Id。(**required**，群组后缀有区别，注意)
  - userId: 用户id。(**required**)

* Response:

  ```json
  [
    {
      "authority": true,
      "avatar": "string",
      "inviteType": "FRIEND",
      "nickName": "string",
      "nid": 0,
      "relative": true,
      "sex": true,
      "signature": "string",
      "token": "string",
      "uid": 0,
      "userId": "string"
    }
  ]
  ```

### 获取我加入的群组

* 地址: POST `/group/groups`

* demo: http://message.jiangtao.tech/tigase/group/groups

* 参数:

  - groupId: 群组Id。(**required**，群组后缀有区别，注意)
  - userId: 用户id。(**required**)

* Response:

  ```json
  [
    {
      "avatar": "string",
      "description": "string",
      "groupId": "string",
      "name": "string",
      "uid": 0
    }
  ]
  ```





### 获取是否接受群消息

* 地址: POST `/group/isReceived`

* demo: http://message.jiangtao.tech/tigase/group/isReceived

* 参数:

  - groupId: 群组Id。(**required**，群组后缀有区别，注意)
  - userId: 用户id。(**required**)

* Response:

  ```json
  {
    // 是否有管理员权限
    "authority": 0,
    // 是否接受消息
    "isReceived": 0
  }
  ```

### 更改接受群消息权限

* 地址: POST `/group/updateIsReceived`

* demo: http://message.jiangtao.tech/tigase/group/updateIsReceived

* 参数:

  - groupId: 群组Id。(**required**，群组后缀有区别，注意)
  - userId: 用户id。(**required**)

* Response:

  ```json
  {
    // 是否有管理员权限
    "authority": 0,
    // 是否接受消息
    "isReceived": 0
  }
  ```



## 文件

### 单个文件上传

* 地址: POST `/file/upload`

* demo: http://message.jiangtao.tech/file/upload

* 参数:

  - file: 文件。(**required**，群组后缀有区别，注意)
  - type: 文件类型。(**required**) `image,audio,video,avatar,file`

* Response:

  ```json
  {
    "errorMessage": "string",
    "resourceId": "string",
    "success": true,
    "type": "image"
  }
  ```

### 多个文件上传

* 地址: POST `/file/uploadMultipleFile`

* demo: http://message.jiangtao.tech/tigase/file/uploadMultipleFile

* 参数:

  - files: 文件。(**required**，群组后缀有区别，注意)(array)
  - types: 文件类型。(**required**) (`image,audio,video,avatar,file`)(array)

* Response:

  ```json
  [
    {
    "errorMessage": "string",
    "resourceId": "string",
    "success": true,
    "type": "image"
     }
  ]
  ```





###  文件下载



## 聊天记录

### 查询单聊历史消息

* 地址: POST `/common/queryChatHistory`

* demo: http://message.jiangtao.tech/tigase/common/queryChatHistory

* 参数:

  - userId: 用户userId。(**required**，用户userId)
  - otherSideId: 对方的userId。(**required**,对方的userId)
  - page: 分页，从0开始。
  - timestamp: 时间戳。从时间戳开始查询。

* Response:

  ```json
  [
    {
      "groupId": "string",
      "id": "string",
      "messageExtensionType": 0,
      "messageStatus": true,
      "messageType": "string",
      "receiver": "string",
      "sender": "string",
      "textMessage": "string",
      "thread": "string",
      "time": "2017-05-08T14:59:36.546Z",
      "type": "string"
    }
  ]
  ```

### 查询群聊历史消息

* 地址: POST `/common/queryGroupChatHistory`

* demo: http://message.jiangtao.tech/tigase/common/queryGroupChatHistory

* 参数:

  - userId: 用户userId。(**required**，用户userId)
  - otherSideId: 对方的userId。(**required**,对方的userId)
  - page: 分页，从0开始。
  - timestamp: 时间戳。从时间戳开始查询。

* Response:

  ```json
  [
    {
      "groupId": "string",
      "id": "string",
      "messageExtensionType": 0,
      "messageStatus": true,
      "messageType": "string",
      "receiver": "string",
      "sender": "string",
      "textMessage": "string",
      "thread": "string",
      "time": "2017-05-08T14:59:36.546Z",
      "type": "string"
    }
  ]
  ```



## 推送

### 推送

* 地址: POST `/push`

* demo: http://message.jiangtao.tech/tigase/push

* 参数:

  - type: 推送类型。 (all:推送到所有用户。list:传入需要推送用户的userId)
  - message: 推送消息。
  - userIds: 推送用户的userId.(array)

* Response:

  ```json
  {
    "message": "string",
    "result": true
  }
  ```

  ​