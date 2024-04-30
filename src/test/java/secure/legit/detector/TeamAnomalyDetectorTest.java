package secure.legit.detector;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import secure.legit.data.*;

import java.util.Optional;

import static java.lang.StringTemplate.STR;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamAnomalyDetectorTest {
    private static TeamAnomalyDetector detector;

    @BeforeAll
    public static void setUp() {
        detector = new TeamAnomalyDetector(new Gson());
    }

    @Test
    public void detectAnomaly_shouldDetectWhenHackerTeamCreated(){
        Optional<AnomalyInfo> anomalyInfo = detector.detectAnomaly(createTeamEvent(Action.CREATION, "hacker"));
        assertTrue(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldDetectWhenHackerTeamCreatedWithCapital(){
        Optional<AnomalyInfo> anomalyInfo = detector.detectAnomaly(createTeamEvent(Action.CREATION, "Hacker"));
        assertTrue(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldNotDetectWhenGoodTeamCreated(){
        Optional<AnomalyInfo> anomalyInfo = detector.detectAnomaly(createTeamEvent(Action.CREATION, "Legit team"));
        assertFalse(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldNotDetectWhenBadTeamDeleted(){
        Optional<AnomalyInfo> anomalyInfo = detector.detectAnomaly(createTeamEvent(Action.DELETION, "hacker4u"));
        assertFalse(anomalyInfo.isPresent());
    }

    private String createTeamEvent(Action action, String teamName) {
        return STR."""
{
  "action":\{action.value},
  "team": {
    "name":"\{teamName}",
    "id": 9942050,
    "node_id": "T_kwDOCfimNM4Al7Qi",
    "slug": "jude-is-hacker",
    "description": "",
    "privacy": "closed",
    "notification_setting": "notifications_enabled",
    "url": "https://api.github.com/organizations/167290420/team/9942050",
    "html_url": "https://github.com/orgs/jacob2bs/teams/jude-is-hacker",
    "members_url": "https://api.github.com/organizations/167290420/team/9942050/members{/member}",
    "repositories_url": "https://api.github.com/organizations/167290420/team/9942050/repos",
    "permission": "pull",
    "parent": null
  },
  "organization": {
    "login": "jacob2bs",
    "id": 167290420,
    "node_id": "O_kgDOCfimNA",
    "url": "https://api.github.com/orgs/jacob2bs",
    "repos_url": "https://api.github.com/orgs/jacob2bs/repos",
    "events_url": "https://api.github.com/orgs/jacob2bs/events",
    "hooks_url": "https://api.github.com/orgs/jacob2bs/hooks",
    "issues_url": "https://api.github.com/orgs/jacob2bs/issues",
    "members_url": "https://api.github.com/orgs/jacob2bs/members{/member}",
    "public_members_url": "https://api.github.com/orgs/jacob2bs/public_members{/member}",
    "avatar_url": "https://avatars.githubusercontent.com/u/167290420?v=4",
    "description": null
  },
  "sender": {
    "login": "jacub2b",
    "id": 64401763,
    "node_id": "MDQ6VXNlcjY0NDAxNzYz",
    "avatar_url": "https://avatars.githubusercontent.com/u/64401763?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/jacub2b",
    "html_url": "https://github.com/jacub2b",
    "followers_url": "https://api.github.com/users/jacub2b/followers",
    "following_url": "https://api.github.com/users/jacub2b/following{/other_user}",
    "gists_url": "https://api.github.com/users/jacub2b/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/jacub2b/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/jacub2b/subscriptions",
    "organizations_url": "https://api.github.com/users/jacub2b/orgs",
    "repos_url": "https://api.github.com/users/jacub2b/repos",
    "events_url": "https://api.github.com/users/jacub2b/events{/privacy}",
    "received_events_url": "https://api.github.com/users/jacub2b/received_events",
    "type": "User",
    "site_admin": false
  }
}
                """;
    }
}
