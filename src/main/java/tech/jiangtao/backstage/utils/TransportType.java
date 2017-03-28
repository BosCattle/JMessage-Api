package tech.jiangtao.backstage.utils;

/**
 * Class: TransportType </br>
 * Description: 文件的类型申明 </br>
 * Creator: jiang </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 2017/2/21 11:28 </br>
 * Update: 2017/2/21 11:28 </br>
 **/
public enum TransportType {
    IMAGE("image"),
    AUDIO("audio"),
    VEDIO("video"),
    AVATAR("avatar"),
    FILE("file");
    private final String text;

    /**
     * @param text
     */
    private TransportType(final String text) {
        this.text = text;
    }

    public static TransportType toTransportType(String textParam) {
        return TransportType.valueOf(textParam);
    }

}
