package tech.jiangtao.backstage.model.json;

import tech.jiangtao.backstage.utils.TransportType;

/**
 * Class: FileResult </br>
 * Description: 文件上传或者下载返回的数据 </br>
 * Creator: jiang </br>
 * Email: jiangtao103cp@gmail.com </br>
 * Date: 2017/2/21 11:28 </br>
 * Update: 2017/2/21 11:28 </br>
 **/
public class FileResult {

    private String resourceId;
    private boolean success;
    private TransportType type;
    private String errorMessage;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public TransportType getType() {
        return type;
    }

    public void setType(TransportType type) {
        this.type = type;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
