package cc.thas.tools.shell;

/**
 * @author <a href="mailto:thascc1024@gmail.com">thas</a>
 * @date 2020/6/14 21:27
 */
public class GitCommandllegalException extends RuntimeException {
    public GitCommandllegalException() {
        this("Git command is illegal.");
    }

    public GitCommandllegalException(String message) {
        super(message);
    }

    public GitCommandllegalException(String message, Throwable cause) {
        super(message, cause);
    }

    public GitCommandllegalException(Throwable cause) {
        super(cause);
    }

    public GitCommandllegalException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
