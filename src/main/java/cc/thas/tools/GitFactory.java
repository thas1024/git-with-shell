package cc.thas.tools;

import cc.thas.tools.shell.GitCommand;
import cc.thas.tools.shell.GitCommandllegalException;
import cc.thas.tools.shell.GitWithShellImpl;

import java.io.File;

/**
 * @author <a href="mailto:thascc1024@gmail.com">thas</a>
 * @date 2020/6/14 10:50
 */
public class GitFactory {

    public static Git newGitInstance(File path) {
        if (path == null || !path.isDirectory()) {
            throw new GitCommandllegalException("Git repo path is null or not a directory");
        }
        if (GitCommand.checkGitCommand()) {
            return new GitWithShellImpl(path);
        }
        return null;
    }

}
