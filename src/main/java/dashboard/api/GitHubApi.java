package dashboard.api;

import org.apache.commons.lang3.tuple.Pair;
import org.kohsuke.github.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GitHubApi {

    private final GitHub github;

    public GitHubApi(String token) throws IOException {
        this.github = new GitHubBuilder().withOAuthToken(token).build();
    }

    public List<GHIssue> getIssueList(String repoName) throws IOException {
        GHRepository repository = github.getRepository(repoName);

        return repository.getIssues(GHIssueState.ALL);
    }
}