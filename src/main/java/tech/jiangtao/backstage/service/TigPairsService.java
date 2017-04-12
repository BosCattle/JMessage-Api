package tech.jiangtao.backstage.service;

import tech.jiangtao.backstage.model.TigPairs;

/**
 * @class: TigPairsService </br>
 * @description:  </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 12/04/2017 8:31 PM</br>
 * @version: 0.0.1 </br>
 **/
public interface TigPairsService {

  public TigPairs queryTigPairs(long uid,String pkey) throws Exception;
}
