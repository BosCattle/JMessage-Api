package tech.jiangtao.backstage.controller.addition;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tech.jiangtao.backstage.mapper.TigNodesMapper;
import tech.jiangtao.backstage.mapper.TigPairsMapper;
import tech.jiangtao.backstage.mapper.TigUsersMapper;
import tech.jiangtao.backstage.model.TigUsers;
import tech.jiangtao.backstage.model.json.Account;
import tech.jiangtao.backstage.model.json.Friends;

/**
 * @class: CommonController </br>
 * @description: 一些公共的接口</br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 10/04/2017 3:21 PM</br>
 * @version: 0.0.1 </br>
 **/

@Api(value = "账户接口")
@RestController
@RequestMapping("/account")
public class AccountController {

  @Autowired
  private TigUsersMapper tigUsersMapper;

  @Autowired
  private TigNodesMapper tigNodesMapper;

  @Autowired
  private TigPairsMapper tigPairsMapper;

  /**
   * 注册账户
   * @param userJid
   * @param nickName
   * @param avatar
   * @param sex
   * @param sigsture
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  @ApiOperation(value = "用户注册", httpMethod = "POST", response = Account.class,
      notes = "用户注册")
  public @ResponseBody Account createAccount(
      @ApiParam(required = true, name = "userJid", value = "用户userId") @RequestParam("userJid")
          String userJid,
      @ApiParam(required = true, name = "nickName", value = "用户昵称") @RequestParam("nickName")
          String nickName,
      @ApiParam(required = true, name = "avatar", value = "用户头像") @RequestParam("avatar")
          String avatar,
      @ApiParam(required = true, name = "sex", value = "性别") @RequestParam("sex")
          String sex,
      @ApiParam(required = true, name = "sigsture", value = "个性签名") @RequestParam("sigsture")
          String sigsture) throws Exception {

    return null;
  }

  /**
   * 更新用户信息
   * @param userJid
   * @param nickName
   * @param avatar
   * @param sex
   * @param sigsture
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/update", method = RequestMethod.POST)
  @ApiOperation(value = "用户资料更新", httpMethod = "POST", response = Account.class,
      notes = "用户资料更新")
  public @ResponseBody Account updateAccount(
      @ApiParam(name = "userJid", value = "用户userId") @RequestParam("userJid")
          String userJid,
      @ApiParam(name = "nickName", value = "用户昵称") @RequestParam("nickName")
          String nickName,
      @ApiParam(name = "avatar", value = "用户头像") @RequestParam("avatar")
          String avatar,
      @ApiParam(name = "sex", value = "性别") @RequestParam("sex")
          String sex,
      @ApiParam(name = "sigsture", value = "个性签名") @RequestParam("sigsture")
          String sigsture) throws Exception {

    return null;
  }
}
