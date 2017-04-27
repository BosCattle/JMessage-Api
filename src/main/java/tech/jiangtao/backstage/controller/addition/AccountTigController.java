package tech.jiangtao.backstage.controller.addition;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangtao.backstage.model.json.Account;
import tech.jiangtao.backstage.service.TigAccountService;
import tech.jiangtao.backstage.utils.Authorization;

/**
 * @class: CommonController </br>
 * @description: 一些公共的接口</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 10/04/2017 3:21 PM</br>
 * @version: 0.0.1 </br>
 **/

@Api(value = "账户", description = "与账户相关的接口", tags = "账户")
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
  public @ResponseBody Account createAccount(
      @ApiParam(required = true, name = "userJid", value = "用户userId") @RequestParam("userJid")
          String userJid,
      @ApiParam(required = true, name = "nickName", value = "用户昵称") @RequestParam("nickName")
          String nickName,
      @ApiParam(required = true, name = "password", value = "密码") @RequestParam("password")
          String password,
      @ApiParam(name = "avatar", value = "用户头像") String avatar,
      @ApiParam(name = "sex", value = "性别") boolean sex,
      @ApiParam(name = "signature", value = "个性签名") String signature,
      HttpServletResponse response)
      throws Exception {
    System.out.println(userJid);
    Account account =
        tigAccountService.insertAccount(userJid, nickName, avatar, sex, signature, password);
    response.setHeader(Authorization.AUTHORIZATION, account.getNid() + "-" + account.getToken());
    return account;
  }

  /**
   * 更新用户信息
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  @ApiOperation(value = "用户资料更新", httpMethod = "POST", response = Account.class,
      notes = "用户资料更新")
  public @ResponseBody Account updateAccount(
      @ApiParam(required = true, name = "uid", value = "用户唯一标识uid") @RequestParam("uid") long uid,
      @ApiParam(name = "userJid", value = "用户userId") @RequestParam("userJid") String userJid,
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
