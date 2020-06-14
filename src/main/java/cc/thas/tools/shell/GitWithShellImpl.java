package cc.thas.tools.shell;

import cc.thas.tools.Git;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static cc.thas.tools.shell.GitCommand.exec;

/**
 * @author <a href="mailto:thascc1024@gmail.com">thas</a>
 * @date 2020/6/14 20:29
 */
public class GitWithShellImpl implements Git {

    public static final String EMPTY_STRING = "";
    private final File path;

    public GitWithShellImpl(File path) {
        assert path != null && path.isDirectory();
        this.path = path;
    }

    @Override
    public void init() {
        exec("git init", path);
    }

    @Override
    public void config(String key, String value) {
        exec(String.format("git config %s %s", key, value), path);
    }

    @Override
    public void configUsername(String username) {
        config("user.name", username);
    }

    @Override
    public void configEmail(String email) {
        config("user.email", email);
    }

    @Override
    public void clone(String url) {
        clone(url, null, null);
    }

    @Override
    public void clone(String url, String origin, String checkoutBranch) {
        exec(String.format("git clone %s %s %s", url, origin != null ? origin : EMPTY_STRING,
            checkoutBranch != null ? checkoutBranch : EMPTY_STRING), path);
    }

    @Override
    public void add(String target) {
        exec(String.format("git add %s", target), path);
    }

    @Override
    public void addAll() {
        add("-A");
    }

    @Override
    public void commit(String message) {
        exec(String.format("git commit -m \"%s\"", message), path);
    }

    @Override
    public List<String> listRemotes() {
        return listRemotes(false);
    }

    @Override
    public List<String> listRemotes(boolean verbose) {
        return exec(String.format("git remote %s", verbose ? "-v" : EMPTY_STRING), path).getResults();
    }

    @Override
    public void remote(String remoteName, String remoteUrl) {
        List<String> remoteNames = listRemotes();
        if (remoteName != null && remoteNames.contains(remoteName)) {
            setRemote(remoteName, remoteUrl);
        } else {
            addRemote(remoteName, remoteUrl);
        }
    }

    @Override
    public void addRemote(String remoteName, String remoteUrl) {
        exec(String.format("git remote add %s %s", remoteName, remoteUrl), path);
    }

    @Override
    public void setRemote(String remoteName, String remoteUrl) {
        exec(String.format("git remote set-url %s %s", remoteName, remoteUrl), path);
    }

    @Override
    public void push(String repository, String refspec) {
        push(repository, refspec, false);
    }

    @Override
    public void push(String repository, String refspec, boolean force) {
        push(repository, refspec, force, 60, TimeUnit.SECONDS);
    }

    @Override
    public void push(String repository, String refspec, boolean force, long timeout, TimeUnit timeUnit) {
        exec(String.format("git push --set-upstream %s %s %s", repository, refspec, force ? "-f" : EMPTY_STRING), path,
            timeout, timeUnit);
    }
}
