package cc.thas.tools.shell;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="mailto:thascc1024@gmail.com">thas</a>
 * @date 2020/6/14 22:38
 */
public class GitCommandResult implements Serializable {
    private List<String> results;
    private List<String> errors;

    public GitCommandResult() {

    }

    public GitCommandResult(List<String> results, List<String> errors) {
        this.results = results;
        this.errors = errors;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
