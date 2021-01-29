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

    public Map<String, Integer> getIssueCommentMap(List<GHIssue> issueList) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        List<String> commenterList = new ArrayList<>();
        for (GHIssue issue: issueList) {
            for (GHIssueComment comment: issue.getComments()) {
                String userName = comment.getUser().getName();
                if (!commenterList.contains(userName)) {
                    if (!map.containsKey(userName)) {
                        map.put(userName, 1);
                    } else {
                        map.put(userName, map.get(userName) + 1);
                    }
                    commenterList.add(userName);
                }
            }
            commenterList.clear();
        }
        return map;
    }
}