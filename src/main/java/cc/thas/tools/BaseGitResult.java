package cc.thas.tools;

/**
 * TODO
 *
 * @author <a href="mailto:thascc1024@gmail.com">thas</a>
 * @date 2020/6/14 22:39
 */
public class BaseGitResult {

    private boolean success;
    private String message;
    private GitResultErrorCode errorCode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GitResultErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(GitResultErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
