package secure.legit.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeamGitHubEvent extends GitHubEvent {
    Team team;
    String action;
}
/*
{
  "action": "created",
  "team": {
    "name": "test team",
    "id": 9939766,
    "node_id": "T_kwDOCfimNM4Al6s2",
    "slug": "test-team",
    "description": "",
    "privacy": "closed",
    "notification_setting": "notifications_enabled",
    "url": "https://api.github.com/organizations/167290420/team/9939766",
    "html_url": "https://github.com/orgs/jacob2bs/teams/test-team",
    "members_url": "https://api.github.com/organizations/167290420/team/9939766/members{/member}",
    "repositories_url": "https://api.github.com/organizations/167290420/team/9939766/repos",
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
 */
