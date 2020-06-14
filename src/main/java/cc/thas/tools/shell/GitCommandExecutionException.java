package cc.thas.tools.shell;

/**
 * @author <a href="mailto:thascc1024@gmail.com">thas</a>
 * @date 2020/6/14 20:31
 */
public class GitCommandExecutionException extends RuntimeException {
    public GitCommandExecutionException() {
        this("Git command execute failed.");
    }

    public GitCommandExecutionException(String s) {
        super(s);
    }

    public GitCommandExecutionException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public GitCommandExecutionException(Throwable throwable) {
        super(throwable);
    }

    public GitCommandExecutionException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
