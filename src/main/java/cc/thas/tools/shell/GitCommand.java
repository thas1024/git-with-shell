package cc.thas.tools.shell;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:thascc1024@gmail.com">thas</a>
 * @date 2020/6/14 11:56
 */
public class GitCommand {

    private static boolean GIT_COMMAND_EXIT = false;
    public static final String GIT_COMMAND = "git";

    public static boolean checkGitCommand() {
        try {
            Runtime.getRuntime().exec("git").waitFor();
            GIT_COMMAND_EXIT = true;
        } catch (Exception e) {
            GIT_COMMAND_EXIT = false;
        }
        return GIT_COMMAND_EXIT;
    }

    static {
        checkGitCommand();
    }

    public static GitCommandResult exec(String command, File path) {
        return exec(command, path, 10, TimeUnit.SECONDS);
    }

    public static GitCommandResult exec(String command, File path, long timeout, TimeUnit unit) {
        if (!command.startsWith(GIT_COMMAND)) {
            throw new GitCommandllegalException("Command is not belong to git.");
        }
        if (!GIT_COMMAND_EXIT) {
            throw new GitCommandNotFoundException();
        }
        try {
            Process process = Runtime.getRuntime().exec(command, null, path);
            process.waitFor(timeout, unit);
            InputStream errorStream = process.getErrorStream();
            InputStream inputStream = process.getInputStream();
            List<String> strings = IOUtils.readLines(inputStream, Charset.defaultCharset());
            List<String> errorMsgs = IOUtils.readLines(errorStream, Charset.defaultCharset());
            return new GitCommandResult(strings, errorMsgs);
        } catch (Exception e) {
            throw new GitCommandExecutionException(e);
        }
    }

}
