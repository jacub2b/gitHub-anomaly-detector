package secure.legit.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RepositoryGitHubEvent extends GitHubEvent {
    String action;
    RepositoryData repository;
}

/*
Example event:
{
  "action": "created",
  "repository": {
    "id": 787978908,
    "node_id": "R_kgDOLveanA",
    "name": "my-repo",
    "full_name": "jacob2bs/my-repo",
    "private": true,
    "owner": {
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
    "html_url": "https://github.com/jacob2bs/my-repo",
    "description": null,
    "fork": false,
    "url": "https://api.github.com/repos/jacob2bs/my-repo",
    "forks_url": "https://api.github.com/repos/jacob2bs/my-repo/forks",
    "keys_url": "https://api.github.com/repos/jacob2bs/my-repo/keys{/key_id}",
    "collaborators_url": "https://api.github.com/repos/jacob2bs/my-repo/collaborators{/collaborator}",
    "teams_url": "https://api.github.com/repos/jacob2bs/my-repo/teams",
    "hooks_url": "https://api.github.com/repos/jacob2bs/my-repo/hooks",
    "issue_events_url": "https://api.github.com/repos/jacob2bs/my-repo/issues/events{/number}",
    "events_url": "https://api.github.com/repos/jacob2bs/my-repo/events",
    "assignees_url": "https://api.github.com/repos/jacob2bs/my-repo/assignees{/user}",
    "branches_url": "https://api.github.com/repos/jacob2bs/my-repo/branches{/branch}",
    "tags_url": "https://api.github.com/repos/jacob2bs/my-repo/tags",
    "blobs_url": "https://api.github.com/repos/jacob2bs/my-repo/git/blobs{/sha}",
    "git_tags_url": "https://api.github.com/repos/jacob2bs/my-repo/git/tags{/sha}",
    "git_refs_url": "https://api.github.com/repos/jacob2bs/my-repo/git/refs{/sha}",
    "trees_url": "https://api.github.com/repos/jacob2bs/my-repo/git/trees{/sha}",
    "statuses_url": "https://api.github.com/repos/jacob2bs/my-repo/statuses/{sha}",
    "languages_url": "https://api.github.com/repos/jacob2bs/my-repo/languages",
    "stargazers_url": "https://api.github.com/repos/jacob2bs/my-repo/stargazers",
    "contributors_url": "https://api.github.com/repos/jacob2bs/my-repo/contributors",
    "subscribers_url": "https://api.github.com/repos/jacob2bs/my-repo/subscribers",
    "subscription_url": "https://api.github.com/repos/jacob2bs/my-repo/subscription",
    "commits_url": "https://api.github.com/repos/jacob2bs/my-repo/commits{/sha}",
    "git_commits_url": "https://api.github.com/repos/jacob2bs/my-repo/git/commits{/sha}",
    "comments_url": "https://api.github.com/repos/jacob2bs/my-repo/comments{/number}",
    "issue_comment_url": "https://api.github.com/repos/jacob2bs/my-repo/issues/comments{/number}",
    "contents_url": "https://api.github.com/repos/jacob2bs/my-repo/contents/{+path}",
    "compare_url": "https://api.github.com/repos/jacob2bs/my-repo/compare/{base}...{head}",
    "merges_url": "https://api.github.com/repos/jacob2bs/my-repo/merges",
    "archive_url": "https://api.github.com/repos/jacob2bs/my-repo/{archive_format}{/ref}",
    "downloads_url": "https://api.github.com/repos/jacob2bs/my-repo/downloads",
    "issues_url": "https://api.github.com/repos/jacob2bs/my-repo/issues{/number}",
    "pulls_url": "https://api.github.com/repos/jacob2bs/my-repo/pulls{/number}",
    "milestones_url": "https://api.github.com/repos/jacob2bs/my-repo/milestones{/number}",
    "notifications_url": "https://api.github.com/repos/jacob2bs/my-repo/notifications{?since,all,participating}",
    "labels_url": "https://api.github.com/repos/jacob2bs/my-repo/labels{/name}",
    "releases_url": "https://api.github.com/repos/jacob2bs/my-repo/releases{/id}",
    "deployments_url": "https://api.github.com/repos/jacob2bs/my-repo/deployments",
    "created_at": "2024-04-17T14:45:30Z",
    "updated_at": "2024-04-17T14:45:31Z",
    "pushed_at": "2024-04-17T14:45:31Z",
    "git_url": "git://github.com/jacob2bs/my-repo.git",
    "ssh_url": "git@github.com:jacob2bs/my-repo.git",
    "clone_url": "https://github.com/jacob2bs/my-repo.git",
    "svn_url": "https://github.com/jacob2bs/my-repo",
    "homepage": null,
    "size": 0,
    "stargazers_count": 0,
    "watchers_count": 0,
    "language": null,
    "has_issues": true,
    "has_projects": true,
    "has_downloads": true,
    "has_wiki": false,
    "has_pages": false,
    "has_discussions": false,
    "forks_count": 0,
    "mirror_url": null,
    "archived": false,
    "disabled": false,
    "open_issues_count": 0,
    "license": null,
    "allow_forking": false,
    "is_template": false,
    "web_commit_signoff_required": false,
    "topics": [

    ],
    "visibility": "private",
    "forks": 0,
    "open_issues": 0,
    "watchers": 0,
    "default_branch": "main",
    "custom_properties": {

    }
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
