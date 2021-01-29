package dashboard;

import dashboard.api.GitHubApi;
import org.junit.jupiter.api.Test;
import org.kohsuke.github.GHIssue;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GitHubApiTest {

    private final String token = "MY_SECRET_TOKEN"; // 여기에 토큰을 입력

    @Test
    void 깃허브_연결_테스트() {
        try {
            GitHubApi gitHubApi = new GitHubApi(token);
        } catch (IOException e) {
            fail();
        }
    }
}