package secure.legit.detector;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import secure.legit.data.AnomalyInfo;

import java.time.ZonedDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PushAnomalyDetectorTest {
    private static PushAnomalyDetector anomalyDetector;

    @BeforeAll
    public static void setUp() {
        anomalyDetector = new PushAnomalyDetector(new Gson());
    }

    @Test
    public void detectAnomaly_shouldReturnFalseWhenTimeIsNormalTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().withHour(18);
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent("2024-04-17T13:11:30+03:00", String.valueOf(zonedDateTime.toEpochSecond())));
        assertFalse(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldReturnTrueWhenTimeIsRestTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().withHour(15);
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent("2024-04-17T13:11:30+03:00", String.valueOf(zonedDateTime.toEpochSecond())));
        assertTrue(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldReturnFalseWhenTimeIsRestTimeButDifferentTimeZone() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().withHour(15);
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent("2024-04-17T13:11:30+00:00", String.valueOf(zonedDateTime.toEpochSecond())));
        assertFalse(anomalyInfo.isPresent());
    }

    @Test
    public void detectAnomaly_shouldReturnTrueWhenTimeIsRestTimeInDifferentTimeZone() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now().withHour(18);
        Optional<AnomalyInfo> anomalyInfo = anomalyDetector.detectAnomaly(buildEvent("2024-04-17T13:11:30+00:00", String.valueOf(zonedDateTime.toEpochSecond())));
        assertTrue(anomalyInfo.isPresent());
    }

    private String buildEvent(String timeZonedField, String pushedEpoch) {
        return STR."""
                {
                  "ref": "refs/heads/main",
                  "before": "ac1795df7702fdb79c9d0889bc734119dc6f380d",
                  "after": "8bf60c41dc65825333d6d39ae51abd0f0ed1caac",
                  "repository": {
                    "id": 787834847,
                    "node_id": "R_kgDOLvVn3w",
                    "name": "github-anomily-detector",
                    "full_name": "jacob2bs/github-anomily-detector",
                    "private": false,
                    "owner": {
                      "name": "jacob2bs",
                      "email": null,
                      "login": "jacob2bs",
                      "id": 167290420,
                      "node_id": "O_kgDOCfimNA",
                      "avatar_url": "https://avatars.githubusercontent.com/u/167290420?v=4",
                      "gravatar_id": "",
                      "url": "https://api.github.com/users/jacob2bs",
                      "html_url": "https://github.com/jacob2bs",
                      "followers_url": "https://api.github.com/users/jacob2bs/followers",
                      "following_url": "https://api.github.com/users/jacob2bs/following{/other_user}",
                      "gists_url": "https://api.github.com/users/jacob2bs/gists{/gist_id}",
                      "starred_url": "https://api.github.com/users/jacob2bs/starred{/owner}{/repo}",
                      "subscriptions_url": "https://api.github.com/users/jacob2bs/subscriptions",
                      "organizations_url": "https://api.github.com/users/jacob2bs/orgs",
                      "repos_url": "https://api.github.com/users/jacob2bs/repos",
                      "events_url": "https://api.github.com/users/jacob2bs/events{/privacy}",
                      "received_events_url": "https://api.github.com/users/jacob2bs/received_events",
                      "type": "Organization",
                      "site_admin": false
                    },
                    "html_url": "https://github.com/jacob2bs/github-anomily-detector",
                    "description": "A command-line based application ",
                    "fork": false,
                    "url": "https://github.com/jacob2bs/github-anomily-detector",
                    "forks_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/forks",
                    "keys_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/keys{/key_id}",
                    "collaborators_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/collaborators{/collaborator}",
                    "teams_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/teams",
                    "hooks_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/hooks",
                    "issue_events_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/issues/events{/number}",
                    "events_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/events",
                    "assignees_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/assignees{/user}",
                    "branches_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/branches{/branch}",
                    "tags_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/tags",
                    "blobs_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/git/blobs{/sha}",
                    "git_tags_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/git/tags{/sha}",
                    "git_refs_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/git/refs{/sha}",
                    "trees_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/git/trees{/sha}",
                    "statuses_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/statuses/{sha}",
                    "languages_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/languages",
                    "stargazers_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/stargazers",
                    "contributors_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/contributors",
                    "subscribers_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/subscribers",
                    "subscription_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/subscription",
                    "commits_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/commits{/sha}",
                    "git_commits_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/git/commits{/sha}",
                    "comments_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/comments{/number}",
                    "issue_comment_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/issues/comments{/number}",
                    "contents_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/contents/{+path}",
                    "compare_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/compare/{base}...{head}",
                    "merges_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/merges",
                    "archive_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/{archive_format}{/ref}",
                    "downloads_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/downloads",
                    "issues_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/issues{/number}",
                    "pulls_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/pulls{/number}",
                    "milestones_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/milestones{/number}",
                    "notifications_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/notifications{?since,all,participating}",
                    "labels_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/labels{/name}",
                    "releases_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/releases{/id}",
                    "deployments_url": "https://api.github.com/repos/jacob2bs/github-anomily-detector/deployments",
                    "created_at": 1713345410,
                    "updated_at": "2024-04-17T09:16:50Z",
                    "pushed_at": \{pushedEpoch},
                    "git_url": "git://github.com/jacob2bs/github-anomily-detector.git",
                    "ssh_url": "git@github.com:jacob2bs/github-anomily-detector.git",
                    "clone_url": "https://github.com/jacob2bs/github-anomily-detector.git",
                    "svn_url": "https://github.com/jacob2bs/github-anomily-detector",
                    "homepage": null,
                    "size": 1,
                    "stargazers_count": 0,
                    "watchers_count": 0,
                    "language": null,
                    "has_issues": true,
                    "has_projects": true,
                    "has_downloads": true,
                    "has_wiki": true,
                    "has_pages": false,
                    "has_discussions": false,
                    "forks_count": 0,
                    "mirror_url": null,
                    "archived": false,
                    "disabled": false,
                    "open_issues_count": 0,
                    "license": null,
                    "allow_forking": true,
                    "is_template": false,
                    "web_commit_signoff_required": false,
                    "topics": [

                    ],
                    "visibility": "public",
                    "forks": 0,
                    "open_issues": 0,
                    "watchers": 0,
                    "default_branch": "main",
                    "stargazers": 0,
                    "master_branch": "main",
                    "organization": "jacob2bs",
                    "custom_properties": {

                    }
                  },
                  "pusher": {
                    "name": "jacub2b",
                    "email": "64401763+jacub2b@users.noreply.github.com"
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
                  },
                  "created": false,
                  "deleted": false,
                  "forced": false,
                  "base_ref": null,
                  "compare": "https://github.com/jacob2bs/github-anomily-detector/compare/ac1795df7702...8bf60c41dc65",
                  "commits": [
                    {
                      "id": "8bf60c41dc65825333d6d39ae51abd0f0ed1caac",
                      "tree_id": "fd73807996fa631fe368568f2a87bd7c46096115",
                      "distinct": true,
                      "message": "Update README.md",
                      "timestamp": "2024-04-30T11:05:24+03:00",
                      "url": "https://github.com/jacob2bs/github-anomily-detector/commit/8bf60c41dc65825333d6d39ae51abd0f0ed1caac",
                      "author": {
                        "name": "jacub2b",
                        "email": "64401763+jacub2b@users.noreply.github.com",
                        "username": "jacub2b"
                      },
                      "committer": {
                        "name": "GitHub",
                        "email": "noreply@github.com",
                        "username": "web-flow"
                      },
                      "added": [

                      ],
                      "removed": [

                      ],
                      "modified": [
                        "README.md"
                      ]
                    }
                  ],
                  "head_commit": {
                    "id": "8bf60c41dc65825333d6d39ae51abd0f0ed1caac",
                    "tree_id": "fd73807996fa631fe368568f2a87bd7c46096115",
                    "distinct": true,
                    "message": "Update README.md",
                    "timestamp": "\{timeZonedField}",
                    "url": "https://github.com/jacob2bs/github-anomily-detector/commit/8bf60c41dc65825333d6d39ae51abd0f0ed1caac",
                    "author": {
                      "name": "jacub2b",
                      "email": "64401763+jacub2b@users.noreply.github.com",
                      "username": "jacub2b"
                    },
                    "committer": {
                      "name": "GitHub",
                      "email": "noreply@github.com",
                      "username": "web-flow"
                    },
                    "added": [

                    ],
                    "removed": [

                    ],
                    "modified": [
                      "README.md"
                    ]
                  }
                }
                """;
    }
}
