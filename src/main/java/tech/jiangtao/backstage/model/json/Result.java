package tech.jiangtao.backstage.model.json;

/**
 * @class: Result </br>
 * @description:  </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 12/04/2017 10:29 PM</br>
 * @version: 0.0.1 </br>
 **/
public class Result {

  public boolean result;
  public String message;

  public Result(boolean result, String message) {
    this.result = result;
    this.message = message;
  }

  public boolean isResult() {
    return result;
  }

  public void setResult(boolean result) {
    this.result = result;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
