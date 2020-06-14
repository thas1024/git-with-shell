package cc.thas.tools.test;

import cc.thas.tools.Git;
import cc.thas.tools.GitFactory;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author <a href="mailto:thascc1024@gmail.com">thas</a>
 * @date 2020/6/14 21:53
 */
public class GitWithShellImplTest {

    private File tmpDir = new File(
        System.getProperty("java.io.tmpdir") + File.separator + UUID.randomUUID().toString());

    private static final String username = System.getProperty("username");
    private static final String email = System.getProperty("email");
    private static final String repo = System.getProperty("repo");
    private static final String token = System.getProperty("token");

    @Before
    public void before() {
        tmpDir.mkdirs();
    }

    @Test
    public void testPush() throws IOException {
        Git git = GitFactory.newGitInstance(tmpDir);
        git.init();
        git.configUsername(username);
        git.configEmail(email);
        FileUtils.writeStringToFile(new File(tmpDir, "test"), "this is test file.", "UTF-8");
        git.addAll();
        git.commit("test git shell");
        git.remote("origin", String.format("https://%s:%s@github.com/%s/%s", username, token, username, repo));
        git.push("origin", "master", true);
    }

    @After
    public void after() throws IOException {
        FileUtils.forceDeleteOnExit(tmpDir);
    }
}
