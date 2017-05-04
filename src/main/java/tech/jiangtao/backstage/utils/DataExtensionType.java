package tech.jiangtao.backstage.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;

/**
 * @class: DataExtensionType </br>
 * @description: 传输的数据类型 </br>
 * @creator: kevin </br>
 * @email: jiangtao103cp@gmail.com </br>
 * @date: 04/05/2017 10:07</br>
 * @version: 0.0.1 </br>
 **/
public enum  DataExtensionType {
  TEXT("text"), IMAGE("image"), AUDIO("audio"), VIDEO("video"), FILE("file");
  private final String mValue;

  DataExtensionType(String value) {
    mValue = value;
  }

  @Override @JsonValue public String toString() {
    return mValue;
  }

  private static final Map<String, DataExtensionType> STRING_MAPPING = new HashMap<>();

  static {
    for (DataExtensionType calorieType : DataExtensionType.values()) {
      STRING_MAPPING.put(calorieType.toString().toUpperCase(), calorieType);
    }
  }

  @JsonCreator public static DataExtensionType fromValue(String value) {
    return STRING_MAPPING.get(value.toUpperCase());
  }
}
