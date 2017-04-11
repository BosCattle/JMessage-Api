package tech.jiangtao.backstage.controller.addition;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangtao.backstage.model.json.Account;
import tech.jiangtao.backstage.service.TigAccountService;

/**
 * @class: CommonController </br>
 * @description: 一些公共的接口</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 10/04/2017 3:21 PM</br>
 * @version: 0.0.1 </br>
 **/

@Api(value = "账户",description = "与账户相关的接口",tags = "账户")
@RestController
@RequestMapping("/account")
public class AccountTigController {

  @Autowired
  private TigAccountService tigAccountService;

  /**
   * 注册账户
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ApiOperation(value = "用户注册", httpMethod = "POST", response = Account.class,
      notes = "用户注册")
  @ApiImplicitParams({
      @ApiImplicitParam(required = true, name = "userJid", value = "用户userId"),
      @ApiImplicitParam(required = true, name = "nickName", value = "用户昵称"),
      @ApiImplicitParam(required = true, name = "password", value = "密码"),
      @ApiImplicitParam(required = true, name = "avatar", value = "用户头像"),
      @ApiImplicitParam(required = true, name = "sex", value = "性别"),
      @ApiImplicitParam(required = true, name = "signature", value = "个性签名")
  })
  public @ResponseBody Account createAccount(
      @RequestParam("userJid") String userJid,
      @RequestParam("nickName") String nickName,
      @RequestParam("password") String password, String avatar, boolean sex, String signature)
      throws Exception {
    try {
      return tigAccountService.insertAccount(userJid, nickName, avatar, sex, signature, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 更新用户信息
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  @ApiOperation(value = "用户资料更新", httpMethod = "POST", response = Account.class,
      notes = "用户资料更新")
  public @ResponseBody Account updateAccount(
      @ApiParam(required = true, name = "uid", value = "用户唯一标识uid") @RequestParam("uid") long uid,
      @ApiParam(name = "userJid", value = "用户userId") @RequestParam("uid") String userJid,
      @ApiParam(name = "nickName", value = "用户昵称") String nickName,
      @ApiParam(name = "avatar", value = "用户头像") String avatar,
      @ApiParam(name = "sex", value = "性别,0:男，1:女") boolean sex,
      @ApiParam(name = "signature", value = "个性签名") String signature) throws Exception {
    try {
      return tigAccountService.updateAccount(uid, userJid, nickName, avatar, sex, signature);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
