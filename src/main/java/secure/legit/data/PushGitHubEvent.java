package secure.legit.data;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PushGitHubEvent extends GitHubEvent {
    private Pusher pusher;
    private Commit head_commit;
    private RepositoryData repository;
}

/*
Event example:
{
  "ref": "refs/heads/main",
  "before": "ac1795df7702fdb79c9d0889bc734119dc6f380d",
  "after": "27888bc9ed0c8ec89bd05b84e08b88871fe9c14b",
  "repository": {
    "id": 787836046,
    "node_id": "R_kgDOLvVsjg",
    "name": "test-repo",
    "full_name": "jacob2bs/test-repo",
    "private": true,
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
    "html_url": "https://github.com/jacob2bs/test-repo",
    "description": null,
    "fork": false,
    "url": "https://github.com/jacob2bs/test-repo",
    "forks_url": "https://api.github.com/repos/jacob2bs/test-repo/forks",
    "keys_url": "https://api.github.com/repos/jacob2bs/test-repo/keys{/key_id}",
    "collaborators_url": "https://api.github.com/repos/jacob2bs/test-repo/collaborators{/collaborator}",
    "teams_url": "https://api.github.com/repos/jacob2bs/test-repo/teams",
    "hooks_url": "https://api.github.com/repos/jacob2bs/test-repo/hooks",
    "issue_events_url": "https://api.github.com/repos/jacob2bs/test-repo/issues/events{/number}",
    "events_url": "https://api.github.com/repos/jacob2bs/test-repo/events",
    "assignees_url": "https://api.github.com/repos/jacob2bs/test-repo/assignees{/user}",
    "branches_url": "https://api.github.com/repos/jacob2bs/test-repo/branches{/branch}",
    "tags_url": "https://api.github.com/repos/jacob2bs/test-repo/tags",
    "blobs_url": "https://api.github.com/repos/jacob2bs/test-repo/git/blobs{/sha}",
    "git_tags_url": "https://api.github.com/repos/jacob2bs/test-repo/git/tags{/sha}",
    "git_refs_url": "https://api.github.com/repos/jacob2bs/test-repo/git/refs{/sha}",
    "trees_url": "https://api.github.com/repos/jacob2bs/test-repo/git/trees{/sha}",
    "statuses_url": "https://api.github.com/repos/jacob2bs/test-repo/statuses/{sha}",
    "languages_url": "https://api.github.com/repos/jacob2bs/test-repo/languages",
    "stargazers_url": "https://api.github.com/repos/jacob2bs/test-repo/stargazers",
    "contributors_url": "https://api.github.com/repos/jacob2bs/test-repo/contributors",
    "subscribers_url": "https://api.github.com/repos/jacob2bs/test-repo/subscribers",
    "subscription_url": "https://api.github.com/repos/jacob2bs/test-repo/subscription",
    "commits_url": "https://api.github.com/repos/jacob2bs/test-repo/commits{/sha}",
    "git_commits_url": "https://api.github.com/repos/jacob2bs/test-repo/git/commits{/sha}",
    "comments_url": "https://api.github.com/repos/jacob2bs/test-repo/comments{/number}",
    "issue_comment_url": "https://api.github.com/repos/jacob2bs/test-repo/issues/comments{/number}",
    "contents_url": "https://api.github.com/repos/jacob2bs/test-repo/contents/{+path}",
    "compare_url": "https://api.github.com/repos/jacob2bs/test-repo/compare/{base}...{head}",
    "merges_url": "https://api.github.com/repos/jacob2bs/test-repo/merges",
    "archive_url": "https://api.github.com/repos/jacob2bs/test-repo/{archive_format}{/ref}",
    "downloads_url": "https://api.github.com/repos/jacob2bs/test-repo/downloads",
    "issues_url": "https://api.github.com/repos/jacob2bs/test-repo/issues{/number}",
    "pulls_url": "https://api.github.com/repos/jacob2bs/test-repo/pulls{/number}",
    "milestones_url": "https://api.github.com/repos/jacob2bs/test-repo/milestones{/number}",
    "notifications_url": "https://api.github.com/repos/jacob2bs/test-repo/notifications{?since,all,participating}",
    "labels_url": "https://api.github.com/repos/jacob2bs/test-repo/labels{/name}",
    "releases_url": "https://api.github.com/repos/jacob2bs/test-repo/releases{/id}",
    "deployments_url": "https://api.github.com/repos/jacob2bs/test-repo/deployments",
    "created_at": 1713345581,
    "updated_at": "2024-04-17T09:19:42Z",
    "pushed_at": 1713348690,
    "git_url": "git://github.com/jacob2bs/test-repo.git",
    "ssh_url": "git@github.com:jacob2bs/test-repo.git",
    "clone_url": "https://github.com/jacob2bs/test-repo.git",
    "svn_url": "https://github.com/jacob2bs/test-repo",
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
  "compare": "https://github.com/jacob2bs/test-repo/compare/ac1795df7702...27888bc9ed0c",
  "commits": [
    {
      "id": "27888bc9ed0c8ec89bd05b84e08b88871fe9c14b",
      "tree_id": "41ff430b1300fcaa721c2f347588d51e79d291a0",
      "distinct": true,
      "message": "Update README.md",
      "timestamp": "2024-04-17T13:11:30+03:00",
      "url": "https://github.com/jacob2bs/test-repo/commit/27888bc9ed0c8ec89bd05b84e08b88871fe9c14b",
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
    "id": "27888bc9ed0c8ec89bd05b84e08b88871fe9c14b",
    "tree_id": "41ff430b1300fcaa721c2f347588d51e79d291a0",
    "distinct": true,
    "message": "Update README.md",
    "timestamp": "2024-04-17T13:11:30+03:00",
    "url": "https://github.com/jacob2bs/test-repo/commit/27888bc9ed0c8ec89bd05b84e08b88871fe9c14b",
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
 */

