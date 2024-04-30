package secure.legit.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RepositoryGitHubEvent extends GitHubEvent {
    String action;
    RepositoryData repository;
}
