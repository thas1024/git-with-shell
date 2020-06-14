package cc.thas.tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:thascc1024@gmail.com">thas</a>
 * @date 2020/6/14 10:09
 */
public interface Git {

    void config(String key, String value);

    void configUsername(String username);

    void configEmail(String email);

    void init();

    void clone(String url);

    void clone(String url, String origin, String checkoutBranch);

    void add(String target);

    void addAll();

    void commit(String message);

    List<String> listRemotes();

    List<String> listRemotes(boolean verbose);

    void remote(String remoteName, String remoteUrl);

    void addRemote(String remoteName, String remoteUrl);

    void setRemote(String remoteName, String remoteUrl);

    void push(String repository, String refspec);

    void push(String repository, String refspec, boolean force);

    void push(String repository, String refspec, boolean force, long timeout, TimeUnit timeUnit);
}
