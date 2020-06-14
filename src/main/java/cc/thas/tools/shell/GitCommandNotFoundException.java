package cc.thas.tools.shell;

/**
 * @author <a href="mailto:thascc1024@gmail.com">thas</a>
 * @date 2020/6/14 20:23
 */
public class GitCommandNotFoundException extends RuntimeException {

    public GitCommandNotFoundException() {
        this("Git command not found.");
    }

    public GitCommandNotFoundException(String s) {
        super(s);
    }

    public GitCommandNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public GitCommandNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public GitCommandNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
